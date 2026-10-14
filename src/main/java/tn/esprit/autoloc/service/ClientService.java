package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService extends AbstractCrudService<Client> {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        super(clientRepository, "Client");
        this.clientRepository = clientRepository;
    }

    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email).orElse(null);
    }

    public List<Client> search(String search) {
        return clientRepository.findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCase(search, search);
    }
}
