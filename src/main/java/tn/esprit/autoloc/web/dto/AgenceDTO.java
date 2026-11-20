package tn.esprit.autoloc.web.dto;

import jakarta.validation.constraints.NotBlank;

public record AgenceDTO(Long idAgence, @NotBlank String nom, @NotBlank String adresse,
                        @NotBlank String ville, @NotBlank String telephone) {
}
