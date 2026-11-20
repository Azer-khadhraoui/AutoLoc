package tn.esprit.autoloc.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record ClientDTO(Long idClient, @NotBlank String nom, @NotBlank String prenom,
                        @NotBlank @Email String email, @NotBlank String telephone,
                        @NotBlank String numPermis, @NotNull LocalDate dateInscription) {
}
