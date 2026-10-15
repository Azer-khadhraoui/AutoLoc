package tn.esprit.autoloc.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.ContratService;

@RestController
@RequestMapping("/api/contrats")
public class ContratController extends AbstractCrudController<Contrat> {

    public ContratController(ContratService contratService) {
        super(contratService);
    }
}
