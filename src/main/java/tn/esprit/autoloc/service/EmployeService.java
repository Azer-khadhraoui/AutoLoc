package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityNotFoundException;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.domain.RoleEmploye;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.EmployeRepository;

import java.util.List;

@Service
public class EmployeService extends AbstractCrudService<Employe> {

    private final EmployeRepository employeRepository;
    private final AgenceRepository agenceRepository;

    public EmployeService(EmployeRepository employeRepository, AgenceRepository agenceRepository) {
        super(employeRepository, "Employe");
        this.employeRepository = employeRepository;
        this.agenceRepository = agenceRepository;
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

    @Transactional
    public Employe desaffecterEmploye(Long idEmploye) {
        Employe employe = employeRepository.findById(idEmploye)
                .orElseThrow(() -> new EntityNotFoundException("Employe introuvable avec l'id " + idEmploye));
        if (employe.getAgence() != null) {
            employe.getAgence().getEmployes().remove(employe);
            employe.setAgence(null);
        }
        return employeRepository.save(employe);
    }

    @Transactional
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {
        Employe employe = employeRepository.findById(idEmploye)
                .orElseThrow(() -> new EntityNotFoundException("Employe introuvable avec l'id " + idEmploye));
        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable avec l'id " + idAgence));

        if (employe.getAgence() != null && !employe.getAgence().getIdAgence().equals(idAgence)) {
            throw new IllegalStateException("Desaffectez l'employe de son agence actuelle avant le transfert");
        }

        employe.setAgence(agence);
        agence.getEmployes().add(employe);
        return employeRepository.save(employe);
    }
}
