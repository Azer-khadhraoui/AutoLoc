package tn.esprit.autoloc.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import java.math.BigDecimal;
import java.util.Set;

public record VehiculeDTO(Long idVehicule, @NotBlank String immatriculation,
                          @NotBlank String marque, @NotBlank String modele,
                          @NotNull CategorieVehicule categorie,
                          @NotNull @Positive BigDecimal tarifJournalier,
                          @NotNull StatutVehicule statut, Long agenceId, Set<Long> equipementIds) {
    public VehiculeDTO {
        equipementIds = equipementIds == null ? Set.of() : Set.copyOf(equipementIds);
    }
}
