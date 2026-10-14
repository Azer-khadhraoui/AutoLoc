package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.ContratRepository;

import java.util.List;

@Service
public class ContratService extends AbstractCrudService<Contrat> {

    private final ContratRepository contratRepository;

    public ContratService(ContratRepository contratRepository) {
        super(contratRepository, "Contrat");
        this.contratRepository = contratRepository;
    }

    public Contrat findByClient(Long clientId) {
        return contratRepository.findByClient_IdClient(clientId).orElse(null);
    }

    public Contrat findByReservation(Long reservationId) {
        return contratRepository.findByReservation_IdReservation(reservationId).orElse(null);
    }

    public List<Contrat> findByValide(boolean valide) {
        return contratRepository.findByValide(valide);
    }
}
