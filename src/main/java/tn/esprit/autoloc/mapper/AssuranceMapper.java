package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.domain.Assurance;
import tn.esprit.autoloc.web.dto.AssuranceDTO;

@Mapper(componentModel = "spring", uses = EntityReferenceMapper.class)
public interface AssuranceMapper extends CrudMapper<Assurance, AssuranceDTO> {
    @Override
    @Mapping(target = "idAssurance", ignore = true)
    @Mapping(target = "vehicule", source = "vehiculeId")
    Assurance toEntity(AssuranceDTO dto);

    @Override
    @Mapping(target = "vehiculeId", source = "vehicule")
    AssuranceDTO toDto(Assurance entity);

    @Override
    @Mapping(target = "idAssurance", ignore = true)
    @Mapping(target = "vehicule", source = "vehiculeId")
    void updateEntity(AssuranceDTO dto, @org.mapstruct.MappingTarget Assurance entity);
}
