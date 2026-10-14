package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutReservation;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Service
public class VehiculeService extends AbstractCrudService<Vehicule> {

    private final VehiculeRepository vehiculeRepository;

    public VehiculeService(VehiculeRepository vehiculeRepository) {
        super(vehiculeRepository, "Vehicule");
        this.vehiculeRepository = vehiculeRepository;
    }

    public Vehicule findByImmatriculation(String immatriculation) {
        return vehiculeRepository.findByImmatriculation(immatriculation).orElse(null);
    }

    public List<Vehicule> findByStatut(StatutVehicule statut) {
        return vehiculeRepository.findByStatut(statut);
    }

    public List<Vehicule> findByCategorie(CategorieVehicule categorie) {
        return vehiculeRepository.findByCategorie(categorie);
    }

    public List<Vehicule> findByAgence(Long agenceId) {
        return vehiculeRepository.findByAgence_IdAgence(agenceId);
    }

    public List<Vehicule> findDisponibles(LocalDate debut, LocalDate fin,
                                          Collection<StatutReservation> statuts) {
        return vehiculeRepository.findDisponibles(debut, fin, statuts);
    }
}
