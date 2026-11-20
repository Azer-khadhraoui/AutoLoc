package tn.esprit.autoloc.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import tn.esprit.autoloc.domain.RoleEmploye;

public record EmployeDTO(Long idEmploye, @NotBlank String nom, @NotBlank String prenom,
                         @NotNull RoleEmploye role, Long agenceId) {
}
