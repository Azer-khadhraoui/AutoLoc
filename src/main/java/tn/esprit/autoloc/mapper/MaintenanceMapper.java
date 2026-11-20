package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.web.dto.MaintenanceDTO;

@Mapper(componentModel = "spring", uses = EntityReferenceMapper.class)
public interface MaintenanceMapper extends CrudMapper<Maintenance, MaintenanceDTO> {
    @Override
    @Mapping(target = "idMaintenance", ignore = true)
    @Mapping(target = "vehicule", source = "vehiculeId")
    Maintenance toEntity(MaintenanceDTO dto);

    @Override
    @Mapping(target = "vehiculeId", source = "vehicule")
    MaintenanceDTO toDto(Maintenance entity);

    @Override
    @Mapping(target = "idMaintenance", ignore = true)
    @Mapping(target = "vehicule", source = "vehiculeId")
    void updateEntity(MaintenanceDTO dto, @org.mapstruct.MappingTarget Maintenance entity);
}
