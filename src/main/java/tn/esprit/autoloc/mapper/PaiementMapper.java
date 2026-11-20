package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.web.dto.PaiementDTO;

@Mapper(componentModel = "spring", uses = EntityReferenceMapper.class)
public interface PaiementMapper extends CrudMapper<Paiement, PaiementDTO> {
    @Override
    @Mapping(target = "idPaiement", ignore = true)
    @Mapping(target = "contrat", source = "contratId")
    Paiement toEntity(PaiementDTO dto);

    @Override
    @Mapping(target = "contratId", source = "contrat")
    PaiementDTO toDto(Paiement entity);

    @Override
    @Mapping(target = "idPaiement", ignore = true)
    @Mapping(target = "contrat", source = "contratId")
    void updateEntity(PaiementDTO dto, @org.mapstruct.MappingTarget Paiement entity);
}
