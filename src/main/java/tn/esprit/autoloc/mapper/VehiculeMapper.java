package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.web.dto.VehiculeDTO;

@Mapper(componentModel = "spring", uses = EntityReferenceMapper.class)
public interface VehiculeMapper extends CrudMapper<Vehicule, VehiculeDTO> {
    @Override
    @Mapping(target = "idVehicule", ignore = true)
    @Mapping(target = "agence", source = "agenceId")
    @Mapping(target = "equipements", source = "equipementIds")
    @Mapping(target = "maintenances", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    Vehicule toEntity(VehiculeDTO dto);

    @Override
    @Mapping(target = "agenceId", source = "agence")
    @Mapping(target = "equipementIds", source = "equipements")
    VehiculeDTO toDto(Vehicule entity);

    @Override
    @Mapping(target = "idVehicule", ignore = true)
    @Mapping(target = "agence", source = "agenceId")
    @Mapping(target = "equipements", source = "equipementIds")
    @Mapping(target = "maintenances", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    void updateEntity(VehiculeDTO dto, @org.mapstruct.MappingTarget Vehicule entity);
}
