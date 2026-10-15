package tn.esprit.autoloc.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.PaiementService;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController extends AbstractCrudController<Paiement> {

    public PaiementController(PaiementService paiementService) {
        super(paiementService);
    }
}
