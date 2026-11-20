package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityNotFoundException;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.domain.StatutReservation;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.EquipementRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Service
public class VehiculeService extends AbstractCrudService<Vehicule> {

    private final VehiculeRepository vehiculeRepository;
    private final AgenceRepository agenceRepository;
    private final EquipementRepository equipementRepository;

    public VehiculeService(VehiculeRepository vehiculeRepository,
                           AgenceRepository agenceRepository,
                           EquipementRepository equipementRepository) {
        super(vehiculeRepository, "Vehicule");
        this.vehiculeRepository = vehiculeRepository;
        this.agenceRepository = agenceRepository;
        this.equipementRepository = equipementRepository;
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

    @Transactional
    public Vehicule affecterVehicule(Long idVehicule, Long idAgence) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new EntityNotFoundException("Vehicule introuvable avec l'id " + idVehicule));
        Agence nouvelleAgence = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable avec l'id " + idAgence));

        if (vehicule.getAgence() != null) {
            vehicule.getAgence().getVehicules().remove(vehicule);
        }
        vehicule.setAgence(nouvelleAgence);
        nouvelleAgence.getVehicules().add(vehicule);
        return vehiculeRepository.save(vehicule);
    }

    @Transactional
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new EntityNotFoundException("Vehicule introuvable avec l'id " + idVehicule));
        Equipement equipement = equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new EntityNotFoundException("Equipement introuvable avec l'id " + idEquipement));

        vehicule.getEquipements().add(equipement);
        equipement.getVehicules().add(vehicule);
        return vehiculeRepository.save(vehicule);
    }

    @Transactional
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new EntityNotFoundException("Vehicule introuvable avec l'id " + idVehicule));
        Equipement equipement = equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new EntityNotFoundException("Equipement introuvable avec l'id " + idEquipement));

        vehicule.getEquipements().remove(equipement);
        equipement.getVehicules().remove(vehicule);
        return vehiculeRepository.save(vehicule);
    }

    public List<Vehicule> findDisponibles(LocalDate debut, LocalDate fin,
                                          Collection<StatutReservation> statuts) {
        return vehiculeRepository.findDisponibles(debut, fin, statuts);
    }
}
