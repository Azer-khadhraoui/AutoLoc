package tn.esprit.autoloc.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Assurance;
import tn.esprit.autoloc.mapper.AssuranceMapper;
import tn.esprit.autoloc.service.AssuranceService;
import tn.esprit.autoloc.web.dto.AssuranceDTO;

@RestController
@RequestMapping("/api/assurances")
public class AssuranceController extends AbstractCrudController<Assurance, AssuranceDTO> {

    public AssuranceController(AssuranceService assuranceService, AssuranceMapper assuranceMapper) {
        super(assuranceService, assuranceMapper);
    }
}
