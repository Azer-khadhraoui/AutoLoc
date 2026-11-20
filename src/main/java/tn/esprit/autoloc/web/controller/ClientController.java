package tn.esprit.autoloc.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.mapper.ClientMapper;
import tn.esprit.autoloc.service.ClientService;
import tn.esprit.autoloc.web.dto.ClientDTO;

@RestController
@RequestMapping("/api/clients")
public class ClientController extends AbstractCrudController<Client, ClientDTO> {

    public ClientController(ClientService clientService, ClientMapper clientMapper) {
        super(clientService, clientMapper);
    }
}
