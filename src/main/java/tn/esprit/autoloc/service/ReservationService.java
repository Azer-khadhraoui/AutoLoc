package tn.esprit.autoloc.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.domain.StatutReservation;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.ClientRepository;
import tn.esprit.autoloc.repository.ReservationRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Service
public class ReservationService extends AbstractCrudService<Reservation> {

    private final ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;
    private final VehiculeRepository vehiculeRepository;

    public ReservationService(ReservationRepository reservationRepository,
                              ClientRepository clientRepository,
                              VehiculeRepository vehiculeRepository) {
        super(reservationRepository, "Reservation");
        this.reservationRepository = reservationRepository;
        this.clientRepository = clientRepository;
        this.vehiculeRepository = vehiculeRepository;
    }

    @Transactional
    public Reservation creer(Reservation reservation, Long clientId, Long vehiculeId) {
        associerClientEtVehicule(reservation, clientId, vehiculeId);
        return reservationRepository.save(reservation);
    }

    @Transactional
    public Reservation sauvegarder(Reservation reservation, Long clientId, Long vehiculeId) {
        associerClientEtVehicule(reservation, clientId, vehiculeId);
        return reservationRepository.save(reservation);
    }

    private void associerClientEtVehicule(Reservation reservation, Long clientId, Long vehiculeId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client introuvable avec l'id " + clientId));
        Vehicule vehicule = vehiculeRepository.findById(vehiculeId)
                .orElseThrow(() -> new EntityNotFoundException("Vehicule introuvable avec l'id " + vehiculeId));
        reservation.setClient(client);
        reservation.setVehicule(vehicule);
    }

    public List<Reservation> findByClient(Long clientId) {
        return reservationRepository.findByClient_IdClient(clientId);
    }

    public List<Reservation> findByVehicule(Long vehiculeId) {
        return reservationRepository.findByVehicule_IdVehicule(vehiculeId);
    }

    public List<Reservation> findByStatut(StatutReservation statut) {
        return reservationRepository.findByStatut(statut);
    }

    @Transactional
    public Reservation changerStatut(Long reservationId, StatutReservation nouveauStatut) {
        Reservation reservation = findById(reservationId);
        StatutReservation statutActuel = reservation.getStatut();
        if (!statutActuel.autoriseTransitionVers(nouveauStatut)) {
            throw new IllegalStateException(
                    "Transition de statut interdite : " + statutActuel + " vers " + nouveauStatut);
        }
        reservation.setStatut(nouveauStatut);
        return reservationRepository.save(reservation);
    }

    public boolean existsChevauchement(Long vehiculeId, LocalDate debut, LocalDate fin,
                                       Collection<StatutReservation> statuts) {
        return reservationRepository.existsChevauchement(vehiculeId, debut, fin, statuts);
    }
}
