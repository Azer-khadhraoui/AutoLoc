package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.mapper.VehiculeMapper;
import tn.esprit.autoloc.service.VehiculeService;
import tn.esprit.autoloc.web.dto.VehiculeDTO;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeController extends AbstractCrudController<Vehicule, VehiculeDTO> {

    private final VehiculeService vehiculeService;
    private final VehiculeMapper vehiculeMapper;

    public VehiculeController(VehiculeService vehiculeService, VehiculeMapper vehiculeMapper) {
        super(vehiculeService, vehiculeMapper);
        this.vehiculeService = vehiculeService;
        this.vehiculeMapper = vehiculeMapper;
    }

    @PatchMapping("/{idVehicule}/agence/{idAgence}")
    @Operation(summary = "Affecter un véhicule à une agence")
    public VehiculeDTO affecterVehicule(@PathVariable Long idVehicule, @PathVariable Long idAgence) {
        return vehiculeMapper.toDto(vehiculeService.affecterVehicule(idVehicule, idAgence));
    }

    @PatchMapping("/{idVehicule}/equipements/{idEquipement}")
    @Operation(summary = "Affecter un équipement à un véhicule")
    public VehiculeDTO affecterEquipement(@PathVariable Long idVehicule, @PathVariable Long idEquipement) {
        return vehiculeMapper.toDto(vehiculeService.affecterEquipement(idVehicule, idEquipement));
    }

    @DeleteMapping("/{idVehicule}/equipements/{idEquipement}")
    @Operation(summary = "Désaffecter un équipement d'un véhicule")
    public VehiculeDTO desaffecterEquipement(@PathVariable Long idVehicule, @PathVariable Long idEquipement) {
        return vehiculeMapper.toDto(vehiculeService.desaffecterEquipement(idVehicule, idEquipement));
    }
}
