package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.domain.StatutReservation;
import tn.esprit.autoloc.service.ReservationService;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController extends AbstractCrudController<Reservation> {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        super(reservationService);
        this.reservationService = reservationService;
    }

    @Override
    protected void beforeUpdate(Reservation existingEntity, Reservation incomingEntity) {
        StatutReservation nouveauStatut = incomingEntity.getStatut();
        if (nouveauStatut != null && nouveauStatut != existingEntity.getStatut()
                && !existingEntity.getStatut().autoriseTransitionVers(nouveauStatut)) {
            throw new IllegalStateException("Transition de statut interdite : "
                    + existingEntity.getStatut() + " vers " + nouveauStatut);
        }
    }

    @PatchMapping("/{id}/statut")
    @Operation(summary = "Faire évoluer le statut d'une réservation")
    public Reservation changerStatut(@PathVariable Long id,
                                     @RequestParam StatutReservation statut) {
        return reservationService.changerStatut(id, statut);
    }
}
