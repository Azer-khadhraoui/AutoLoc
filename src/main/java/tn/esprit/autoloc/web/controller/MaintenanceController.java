package tn.esprit.autoloc.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.MaintenanceService;

@RestController
@RequestMapping("/api/maintenances")
public class MaintenanceController extends AbstractCrudController<Maintenance> {

    public MaintenanceController(MaintenanceService maintenanceService) {
        super(maintenanceService);
    }
}
