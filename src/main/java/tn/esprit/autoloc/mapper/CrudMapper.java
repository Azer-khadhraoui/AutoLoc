package tn.esprit.autoloc.mapper;

import org.mapstruct.MappingTarget;

public interface CrudMapper<E, D> {
    E toEntity(D dto);

    D toDto(E entity);

    void updateEntity(D dto, @MappingTarget E entity);
}
