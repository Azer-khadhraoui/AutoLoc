package tn.esprit.autoloc.web.dto;

import jakarta.validation.constraints.NotNull;
import tn.esprit.autoloc.domain.StatutReservation;

import java.time.LocalDate;

public record ReservationDTO(
        Long idReservation,
        @NotNull LocalDate dateDebut,
        @NotNull LocalDate dateFin,
        @NotNull Long clientId,
        @NotNull Long vehiculeId,
        @NotNull StatutReservation statut
) {
}
