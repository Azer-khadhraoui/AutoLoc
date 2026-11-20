package tn.esprit.autoloc.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Assurance;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.domain.Vehicule;

@Component
public class EntityReferenceMapper {
    public Agence toAgence(Long id) {
        if (id == null) return null;
        Agence entity = new Agence();
        entity.setIdAgence(id);
        return entity;
    }

    public Long toAgenceId(Agence entity) {
        return entity == null ? null : entity.getIdAgence();
    }

    public Client toClient(Long id) {
        if (id == null) return null;
        Client entity = new Client();
        entity.setIdClient(id);
        return entity;
    }

    public Long toClientId(Client entity) {
        return entity == null ? null : entity.getIdClient();
    }

    public Reservation toReservation(Long id) {
        if (id == null) return null;
        Reservation entity = new Reservation();
        entity.setIdReservation(id);
        return entity;
    }

    public Long toReservationId(Reservation entity) {
        return entity == null ? null : entity.getIdReservation();
    }

    public Vehicule toVehicule(Long id) {
        if (id == null) return null;
        Vehicule entity = new Vehicule();
        entity.setIdVehicule(id);
        return entity;
    }

    public Long toVehiculeId(Vehicule entity) {
        return entity == null ? null : entity.getIdVehicule();
    }

    public Equipement toEquipement(Long id) {
        if (id == null) return null;
        Equipement entity = new Equipement();
        entity.setIdEquipement(id);
        return entity;
    }

    public Long toEquipementId(Equipement entity) {
        return entity == null ? null : entity.getIdEquipement();
    }

    public Contrat toContrat(Long id) {
        if (id == null) return null;
        Contrat entity = new Contrat();
        entity.setIdContrat(id);
        return entity;
    }

    public Long toContratId(Contrat entity) {
        return entity == null ? null : entity.getIdContrat();
    }

    public Assurance toAssurance(Long id) {
        if (id == null) return null;
        Assurance entity = new Assurance();
        entity.setIdAssurance(id);
        return entity;
    }

    public Long toAssuranceId(Assurance entity) {
        return entity == null ? null : entity.getIdAssurance();
    }
}
