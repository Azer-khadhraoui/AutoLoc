package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.web.dto.EmployeDTO;

@Mapper(componentModel = "spring", uses = EntityReferenceMapper.class)
public interface EmployeMapper extends CrudMapper<Employe, EmployeDTO> {
    @Override
    @Mapping(target = "idEmploye", ignore = true)
    @Mapping(target = "agence", source = "agenceId")
    Employe toEntity(EmployeDTO dto);

    @Override
    @Mapping(target = "agenceId", source = "agence")
    EmployeDTO toDto(Employe entity);

    @Override
    @Mapping(target = "idEmploye", ignore = true)
    @Mapping(target = "agence", source = "agenceId")
    void updateEntity(EmployeDTO dto, @org.mapstruct.MappingTarget Employe entity);
}
