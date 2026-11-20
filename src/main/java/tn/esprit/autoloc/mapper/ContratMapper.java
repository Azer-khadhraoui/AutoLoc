package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.web.dto.ContratDTO;

@Mapper(componentModel = "spring", uses = EntityReferenceMapper.class)
public interface ContratMapper extends CrudMapper<Contrat, ContratDTO> {
    @Override
    @Mapping(target = "idContrat", ignore = true)
    @Mapping(target = "client", source = "clientId")
    @Mapping(target = "reservation", source = "reservationId")
    @Mapping(target = "paiements", ignore = true)
    Contrat toEntity(ContratDTO dto);

    @Override
    @Mapping(target = "clientId", source = "client")
    @Mapping(target = "reservationId", source = "reservation")
    ContratDTO toDto(Contrat entity);

    @Override
    @Mapping(target = "idContrat", ignore = true)
    @Mapping(target = "client", source = "clientId")
    @Mapping(target = "reservation", source = "reservationId")
    @Mapping(target = "paiements", ignore = true)
    void updateEntity(ContratDTO dto, @org.mapstruct.MappingTarget Contrat entity);
}
