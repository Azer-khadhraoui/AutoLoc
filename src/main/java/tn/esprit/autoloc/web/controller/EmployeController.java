package tn.esprit.autoloc.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.EmployeService;

@RestController
@RequestMapping("/api/employes")
public class EmployeController extends AbstractCrudController<Employe> {

    public EmployeController(EmployeService employeService) {
        super(employeService);
    }
}
