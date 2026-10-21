package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.autoloc.service.AbstractCrudService;

import java.util.List;

public abstract class AbstractCrudController<T> {

    private final AbstractCrudService<T> service;

    protected AbstractCrudController(AbstractCrudService<T> service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Lister les ressources")
    public List<T> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
        @Operation(summary = "Consulter une ressource")
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ressource trouvée"),
            @ApiResponse(responseCode = "404", description = "Ressource introuvable")
        })
    public T findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @Operation(summary = "Créer une ressource")
    @ApiResponse(responseCode = "200", description = "Ressource créée")
    public ResponseEntity<T> create(@RequestBody T entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("/{id}")
        @Operation(summary = "Modifier une ressource")
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ressource modifiée"),
            @ApiResponse(responseCode = "404", description = "Ressource introuvable")
        })
    public T update(@PathVariable Long id, @RequestBody T entity) {
        T existingEntity = service.findById(id);
        String[] ignoredProperties = java.util.Arrays.stream(entity.getClass().getDeclaredFields())
            .filter(field -> field.isAnnotationPresent(jakarta.persistence.Id.class)
                || field.isAnnotationPresent(jakarta.persistence.OneToOne.class)
                || field.isAnnotationPresent(jakarta.persistence.OneToMany.class)
                || field.isAnnotationPresent(jakarta.persistence.ManyToOne.class)
                || field.isAnnotationPresent(jakarta.persistence.ManyToMany.class))
            .map(java.lang.reflect.Field::getName)
            .toArray(String[]::new);
        BeanUtils.copyProperties(entity, existingEntity, ignoredProperties);
        return service.save(existingEntity);
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
