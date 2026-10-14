package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.MaintenanceRepository;

import java.util.List;

@Service
public class MaintenanceService extends AbstractCrudService<Maintenance> {

    private final MaintenanceRepository maintenanceRepository;

    public MaintenanceService(MaintenanceRepository maintenanceRepository) {
        super(maintenanceRepository, "Maintenance");
        this.maintenanceRepository = maintenanceRepository;
    }

    public List<Maintenance> findByVehicule(Long vehiculeId) {
        return maintenanceRepository.findByVehicule_IdVehicule(vehiculeId);
    }

    public List<Maintenance> findEnCours() {
        return maintenanceRepository.findByDateFinIsNull();
    }
}
