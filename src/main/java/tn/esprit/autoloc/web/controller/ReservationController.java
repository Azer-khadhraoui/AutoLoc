package tn.esprit.autoloc.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.ReservationService;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController extends AbstractCrudController<Reservation> {

    public ReservationController(ReservationService reservationService) {
        super(reservationService);
    }
}
