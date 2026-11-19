package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.EmployeService;

@RestController
@RequestMapping("/api/employes")
public class EmployeController extends AbstractCrudController<Employe> {

    private final EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        super(employeService);
        this.employeService = employeService;
    }

    @PatchMapping("/{idEmploye}/desaffecter")
    @Operation(summary = "Désaffecter un employé de son agence")
    public Employe desaffecterEmploye(@PathVariable Long idEmploye) {
        return employeService.desaffecterEmploye(idEmploye);
    }

    @PatchMapping("/{idEmploye}/agence/{idAgence}")
    @Operation(summary = "Affecter un employé à une agence")
    public Employe affecterEmploye(@PathVariable Long idEmploye, @PathVariable Long idAgence) {
        return employeService.affecterEmploye(idEmploye, idAgence);
    }
}
