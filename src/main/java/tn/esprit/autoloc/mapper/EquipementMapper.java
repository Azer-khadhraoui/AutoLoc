package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.web.dto.EquipementDTO;

@Mapper(componentModel = "spring")
public interface EquipementMapper extends CrudMapper<Equipement, EquipementDTO> {
    @Override
    @Mapping(target = "idEquipement", ignore = true)
    @Mapping(target = "vehicules", ignore = true)
    Equipement toEntity(EquipementDTO dto);

    @Override
    EquipementDTO toDto(Equipement entity);

    @Override
    @Mapping(target = "vehicules", ignore = true)
    void updateEntity(EquipementDTO dto, @org.mapstruct.MappingTarget Equipement entity);
}
