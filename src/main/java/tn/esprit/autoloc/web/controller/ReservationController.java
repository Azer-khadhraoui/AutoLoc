package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.domain.StatutReservation;
import tn.esprit.autoloc.mapper.ReservationMapper;
import tn.esprit.autoloc.service.ReservationService;
import tn.esprit.autoloc.web.dto.ReservationDTO;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;

    public ReservationController(ReservationService reservationService, ReservationMapper reservationMapper) {
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }

    @GetMapping
    @Operation(summary = "Lister les réservations")
    public List<ReservationDTO> findAll() {
        return reservationService.findAll().stream()
                .map(reservationMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulter une réservation")
    public ReservationDTO findById(@PathVariable Long id) {
        return reservationMapper.toDto(reservationService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Créer une réservation")
    public ResponseEntity<ReservationDTO> create(@Valid @RequestBody ReservationDTO dto) {
        Reservation reservation = reservationMapper.toEntity(dto);
        Reservation creee = reservationService.creer(reservation, dto.clientId(), dto.vehiculeId());
        return ResponseEntity.ok(reservationMapper.toDto(creee));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier une réservation")
    public ReservationDTO update(@PathVariable Long id, @Valid @RequestBody ReservationDTO dto) {
        Reservation reservation = reservationService.findById(id);
        verifierTransition(reservation.getStatut(), dto.statut());
        reservationMapper.updateFromDto(dto, reservation);
        Reservation miseAJour = reservationService.sauvegarder(
                reservation, dto.clientId(), dto.vehiculeId());
        return reservationMapper.toDto(miseAJour);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une réservation")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        reservationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/statut")
    @Operation(summary = "Faire évoluer le statut d'une réservation")
    public ReservationDTO changerStatut(@PathVariable Long id,
                                        @RequestParam StatutReservation statut) {
        return reservationMapper.toDto(reservationService.changerStatut(id, statut));
    }

    private void verifierTransition(StatutReservation statutActuel, StatutReservation nouveauStatut) {
        if (nouveauStatut != statutActuel && !statutActuel.autoriseTransitionVers(nouveauStatut)) {
            throw new IllegalStateException(
                    "Transition de statut interdite : " + statutActuel + " vers " + nouveauStatut);
        }
    }
}
