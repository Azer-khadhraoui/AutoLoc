package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.web.dto.AgenceDTO;

@Mapper(componentModel = "spring")
public interface AgenceMapper extends CrudMapper<Agence, AgenceDTO> {
    @Override
    @Mapping(target = "idAgence", ignore = true)
    @Mapping(target = "vehicules", ignore = true)
    @Mapping(target = "employes", ignore = true)
    Agence toEntity(AgenceDTO dto);

    @Override
    AgenceDTO toDto(Agence entity);

    @Override
    @Mapping(target = "vehicules", ignore = true)
    @Mapping(target = "employes", ignore = true)
    void updateEntity(AgenceDTO dto, @org.mapstruct.MappingTarget Agence entity);
}
