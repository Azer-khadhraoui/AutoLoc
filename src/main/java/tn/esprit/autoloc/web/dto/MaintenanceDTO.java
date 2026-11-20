package tn.esprit.autoloc.web.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record MaintenanceDTO(Long idMaintenance, @NotNull LocalDate dateDebut, LocalDate dateFin,
                             String description, @NotNull Long vehiculeId) {
}
