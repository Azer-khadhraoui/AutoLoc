package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.VehiculeService;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeController extends AbstractCrudController<Vehicule> {

    private final VehiculeService vehiculeService;

    public VehiculeController(VehiculeService vehiculeService) {
        super(vehiculeService);
        this.vehiculeService = vehiculeService;
    }

    @PatchMapping("/{idVehicule}/agence/{idAgence}")
    @Operation(summary = "Affecter un véhicule à une agence")
    public Vehicule affecterVehicule(@PathVariable Long idVehicule, @PathVariable Long idAgence) {
        return vehiculeService.affecterVehicule(idVehicule, idAgence);
    }

    @PatchMapping("/{idVehicule}/equipements/{idEquipement}")
    @Operation(summary = "Affecter un équipement à un véhicule")
    public Vehicule affecterEquipement(@PathVariable Long idVehicule, @PathVariable Long idEquipement) {
        return vehiculeService.affecterEquipement(idVehicule, idEquipement);
    }

    @DeleteMapping("/{idVehicule}/equipements/{idEquipement}")
    @Operation(summary = "Désaffecter un équipement d'un véhicule")
    public Vehicule desaffecterEquipement(@PathVariable Long idVehicule, @PathVariable Long idEquipement) {
        return vehiculeService.desaffecterEquipement(idVehicule, idEquipement);
    }
}
