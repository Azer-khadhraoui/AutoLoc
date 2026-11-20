package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.web.dto.ReservationDTO;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(target = "idReservation", ignore = true)
    @Mapping(target = "client", ignore = true)
    @Mapping(target = "vehicule", ignore = true)
    @Mapping(target = "contrat", ignore = true)
    Reservation toEntity(ReservationDTO source);

    @Mapping(target = "clientId", source = "client.idClient")
    @Mapping(target = "vehiculeId", source = "vehicule.idVehicule")
    ReservationDTO toDto(Reservation source);

    @Mapping(target = "idReservation", ignore = true)
    @Mapping(target = "client", ignore = true)
    @Mapping(target = "vehicule", ignore = true)
    @Mapping(target = "contrat", ignore = true)
    void updateFromDto(ReservationDTO source, @MappingTarget Reservation target);
}
