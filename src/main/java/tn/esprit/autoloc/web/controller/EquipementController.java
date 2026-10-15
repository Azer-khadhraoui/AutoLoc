package tn.esprit.autoloc.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.EquipementService;

@RestController
@RequestMapping("/api/equipements")
public class EquipementController extends AbstractCrudController<Equipement> {

    public EquipementController(EquipementService equipementService) {
        super(equipementService);
    }
}
