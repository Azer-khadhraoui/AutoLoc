package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.AgenceRepository;

import java.util.List;

@Service
public class AgenceService extends AbstractCrudService<Agence> {

    private final AgenceRepository agenceRepository;

    public AgenceService(AgenceRepository agenceRepository) {
        super(agenceRepository, "Agence");
        this.agenceRepository = agenceRepository;
    }

    public List<Agence> findByVille(String ville) {
        return agenceRepository.findByVilleIgnoreCase(ville);
    }

    public List<Agence> searchByNom(String nom) {
        return agenceRepository.findByNomContainingIgnoreCase(nom);
    }
}
