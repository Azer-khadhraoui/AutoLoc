package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.ModePaiement;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PaiementService extends AbstractCrudService<Paiement> {

    private final PaiementRepository paiementRepository;

    public PaiementService(PaiementRepository paiementRepository) {
        super(paiementRepository, "Paiement");
        this.paiementRepository = paiementRepository;
    }

    public List<Paiement> findByContrat(Long contratId) {
        return paiementRepository.findByContrat_IdContrat(contratId);
    }

    public List<Paiement> findByMode(ModePaiement modePaiement) {
        return paiementRepository.findByModePaiement(modePaiement);
    }

    public BigDecimal totalPayeParContrat(Long contratId) {
        return paiementRepository.totalPayeParContrat(contratId);
    }
}
