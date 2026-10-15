package tn.esprit.autoloc.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Assurance;
import tn.esprit.autoloc.service.AssuranceService;

@RestController
@RequestMapping("/api/assurances")
public class AssuranceController extends AbstractCrudController<Assurance> {

    public AssuranceController(AssuranceService assuranceService) {
        super(assuranceService);
    }
}
