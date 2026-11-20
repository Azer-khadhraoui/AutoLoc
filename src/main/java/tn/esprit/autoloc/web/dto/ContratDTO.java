package tn.esprit.autoloc.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDate;

public record ContratDTO(Long idContrat, @NotNull LocalDate dateSignature,
                         @NotNull @PositiveOrZero BigDecimal montantTotal,
                         boolean valide, @NotNull Long clientId, @NotNull Long reservationId) {
}
