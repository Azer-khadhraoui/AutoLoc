package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.EquipementRepository;

@Service
public class EquipementService extends AbstractCrudService<Equipement> {

    private final EquipementRepository equipementRepository;

    public EquipementService(EquipementRepository equipementRepository) {
        super(equipementRepository, "Equipement");
        this.equipementRepository = equipementRepository;
    }

    public Equipement findByLibelle(String libelle) {
        return equipementRepository.findByLibelle(libelle).orElse(null);
    }
}
