package tn.esprit.autoloc.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.mapper.ContratMapper;
import tn.esprit.autoloc.service.ContratService;
import tn.esprit.autoloc.web.dto.ContratDTO;

@RestController
@RequestMapping("/api/contrats")
public class ContratController extends AbstractCrudController<Contrat, ContratDTO> {

    public ContratController(ContratService contratService, ContratMapper contratMapper) {
        super(contratService, contratMapper);
    }
}
