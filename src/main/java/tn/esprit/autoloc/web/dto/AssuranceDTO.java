package tn.esprit.autoloc.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

public record AssuranceDTO(Long idAssurance, @NotBlank String numeroContrat,
                           @NotNull LocalDate dateExpiration, @NotNull Long vehiculeId) {
}
