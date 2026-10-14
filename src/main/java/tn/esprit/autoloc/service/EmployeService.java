package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.domain.RoleEmploye;
import tn.esprit.autoloc.repository.EmployeRepository;

import java.util.List;

@Service
public class EmployeService extends AbstractCrudService<Employe> {

    private final EmployeRepository employeRepository;

    public EmployeService(EmployeRepository employeRepository) {
        super(employeRepository, "Employe");
        this.employeRepository = employeRepository;
    }

    public List<Employe> findByAgence(Long agenceId) {
        return employeRepository.findByAgence_IdAgence(agenceId);
    }

    public List<Employe> findByRole(RoleEmploye role) {
        return employeRepository.findByRole(role);
    }

    public List<Employe> findByAgenceAndRole(Long agenceId, RoleEmploye role) {
        return employeRepository.findByAgence_IdAgenceAndRole(agenceId, role);
    }
}
