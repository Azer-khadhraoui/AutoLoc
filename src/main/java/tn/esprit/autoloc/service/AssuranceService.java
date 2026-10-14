package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Assurance;
import tn.esprit.autoloc.repository.AssuranceRepository;

@Service
public class AssuranceService extends AbstractCrudService<Assurance> {

    public AssuranceService(AssuranceRepository assuranceRepository) {
        super(assuranceRepository, "Assurance");
    }
}
