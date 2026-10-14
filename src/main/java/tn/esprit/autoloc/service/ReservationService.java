package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.domain.StatutReservation;
import tn.esprit.autoloc.repository.ReservationRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Service
public class ReservationService extends AbstractCrudService<Reservation> {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        super(reservationRepository, "Reservation");
        this.reservationRepository = reservationRepository;
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

    public boolean existsChevauchement(Long vehiculeId, LocalDate debut, LocalDate fin,
                                       Collection<StatutReservation> statuts) {
        return reservationRepository.existsChevauchement(vehiculeId, debut, fin, statuts);
    }
}
