package tn.esprit.autoloc.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.mapper.PaiementMapper;
import tn.esprit.autoloc.service.PaiementService;
import tn.esprit.autoloc.web.dto.PaiementDTO;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController extends AbstractCrudController<Paiement, PaiementDTO> {

    public PaiementController(PaiementService paiementService, PaiementMapper paiementMapper) {
        super(paiementService, paiementMapper);
    }
}
