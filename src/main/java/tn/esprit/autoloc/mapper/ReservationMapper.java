package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import tn.esprit.autoloc.domain.Reservation;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(target = "idReservation", ignore = true)
    @Mapping(target = "client", ignore = true)
    @Mapping(target = "vehicule", ignore = true)
    @Mapping(target = "contrat", ignore = true)
    void updateFromRequest(Reservation source, @MappingTarget Reservation target);
}
