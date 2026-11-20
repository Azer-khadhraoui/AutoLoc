package tn.esprit.autoloc.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.mapper.AgenceMapper;
import tn.esprit.autoloc.service.AgenceService;
import tn.esprit.autoloc.web.dto.AgenceDTO;

@RestController
@RequestMapping("/api/agences")
public class AgenceController extends AbstractCrudController<Agence, AgenceDTO> {

    public AgenceController(AgenceService agenceService, AgenceMapper agenceMapper) {
        super(agenceService, agenceMapper);
    }
}
