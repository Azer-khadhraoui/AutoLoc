package tn.esprit.autoloc.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.mapper.MaintenanceMapper;
import tn.esprit.autoloc.service.MaintenanceService;
import tn.esprit.autoloc.web.dto.MaintenanceDTO;

@RestController
@RequestMapping("/api/maintenances")
public class MaintenanceController extends AbstractCrudController<Maintenance, MaintenanceDTO> {

    public MaintenanceController(MaintenanceService maintenanceService, MaintenanceMapper maintenanceMapper) {
        super(maintenanceService, maintenanceMapper);
    }
}
