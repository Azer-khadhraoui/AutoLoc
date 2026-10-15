package tn.esprit.autoloc.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController extends AbstractCrudController<Client> {

    public ClientController(ClientService clientService) {
        super(clientService);
    }
}
