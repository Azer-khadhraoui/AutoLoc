package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.mapper.EmployeMapper;
import tn.esprit.autoloc.service.EmployeService;
import tn.esprit.autoloc.web.dto.EmployeDTO;

@RestController
@RequestMapping("/api/employes")
public class EmployeController extends AbstractCrudController<Employe, EmployeDTO> {

    private final EmployeService employeService;
    private final EmployeMapper employeMapper;

    public EmployeController(EmployeService employeService, EmployeMapper employeMapper) {
        super(employeService, employeMapper);
        this.employeService = employeService;
        this.employeMapper = employeMapper;
    }

    @PatchMapping("/{idEmploye}/desaffecter")
    @Operation(summary = "Désaffecter un employé de son agence")
    public EmployeDTO desaffecterEmploye(@PathVariable Long idEmploye) {
        return employeMapper.toDto(employeService.desaffecterEmploye(idEmploye));
    }

    @PatchMapping("/{idEmploye}/agence/{idAgence}")
    @Operation(summary = "Affecter un employé à une agence")
    public EmployeDTO affecterEmploye(@PathVariable Long idEmploye, @PathVariable Long idAgence) {
        return employeMapper.toDto(employeService.affecterEmploye(idEmploye, idAgence));
    }
}
