package tn.esprit.autoloc.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.mapper.EquipementMapper;
import tn.esprit.autoloc.service.EquipementService;
import tn.esprit.autoloc.web.dto.EquipementDTO;

@RestController
@RequestMapping("/api/equipements")
public class EquipementController extends AbstractCrudController<Equipement, EquipementDTO> {

    public EquipementController(EquipementService equipementService, EquipementMapper equipementMapper) {
        super(equipementService, equipementMapper);
    }
}
