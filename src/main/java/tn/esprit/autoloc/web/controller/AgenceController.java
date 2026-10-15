package tn.esprit.autoloc.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.AgenceService;

@RestController
@RequestMapping("/api/agences")
public class AgenceController extends AbstractCrudController<Agence> {

    public AgenceController(AgenceService agenceService) {
        super(agenceService);
    }
}
