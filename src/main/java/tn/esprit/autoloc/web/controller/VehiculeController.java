package tn.esprit.autoloc.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.VehiculeService;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeController extends AbstractCrudController<Vehicule> {

    public VehiculeController(VehiculeService vehiculeService) {
        super(vehiculeService);
    }
}
