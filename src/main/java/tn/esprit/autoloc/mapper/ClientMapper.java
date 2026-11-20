package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.web.dto.ClientDTO;

@Mapper(componentModel = "spring")
public interface ClientMapper extends CrudMapper<Client, ClientDTO> {
    @Override
    @Mapping(target = "idClient", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    @Mapping(target = "contrat", ignore = true)
    Client toEntity(ClientDTO dto);

    @Override
    ClientDTO toDto(Client entity);

    @Override
    @Mapping(target = "reservations", ignore = true)
    @Mapping(target = "contrat", ignore = true)
    void updateEntity(ClientDTO dto, @org.mapstruct.MappingTarget Client entity);
}
