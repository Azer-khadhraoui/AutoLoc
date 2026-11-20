package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.autoloc.mapper.CrudMapper;
import tn.esprit.autoloc.service.AbstractCrudService;
import java.util.List;

public abstract class AbstractCrudController<E, D> {

    private final AbstractCrudService<E> service;
    private final CrudMapper<E, D> mapper;

    protected AbstractCrudController(AbstractCrudService<E> service, CrudMapper<E, D> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    @Operation(summary = "Lister les ressources")
    public List<D> findAll() {
        return service.findAll().stream().map(mapper::toDto).toList();
    }

    @GetMapping("/{id}")
        @Operation(summary = "Consulter une ressource")
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ressource trouvée"),
            @ApiResponse(responseCode = "404", description = "Ressource introuvable")
        })
    public D findById(@PathVariable Long id) {
        return mapper.toDto(service.findById(id));
    }

    @PostMapping
    @Operation(summary = "Créer une ressource")
    @ApiResponse(responseCode = "200", description = "Ressource créée")
    public ResponseEntity<D> create(@Valid @RequestBody D dto) {
        E entity = service.save(mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDto(entity));
    }

    @PutMapping("/{id}")
        @Operation(summary = "Modifier une ressource")
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ressource modifiée"),
            @ApiResponse(responseCode = "404", description = "Ressource introuvable")
        })
    public D update(@PathVariable Long id, @Valid @RequestBody D dto) {
        E existingEntity = service.findById(id);
        beforeUpdate(existingEntity, dto);
        mapper.updateEntity(dto, existingEntity);
        return mapper.toDto(service.save(existingEntity));
    }

    protected void beforeUpdate(E existingEntity, D incomingDto) {
    }

    @DeleteMapping("/{id}")
        @Operation(summary = "Supprimer une ressource")
        @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Ressource supprimée"),
            @ApiResponse(responseCode = "404", description = "Ressource introuvable")
        })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
