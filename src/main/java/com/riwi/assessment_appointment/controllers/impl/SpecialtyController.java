package com.riwi.assessment_appointment.controllers.impl;

import com.riwi.assessment_appointment.models.entities.SpecialtyEntity;
import com.riwi.assessment_appointment.services.interfaces.ISpecialtyModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specialty")
public class SpecialtyController {


    @Autowired
    private ISpecialtyModel specialtyService;

    @Operation(
            summary = "Crear o actualizar una especialidad",
            description = "Permite crear o actualizar una especialidad médica con los detalles proporcionados.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Especialidad creada o actualizada exitosamente.",
                            content = @Content(schema = @Schema(implementation = SpecialtyEntity.class))),
                    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos.")
            }
    )
    @PostMapping
    public ResponseEntity<SpecialtyEntity> saveSpecialty(@RequestBody SpecialtyEntity specialty) {
        SpecialtyEntity savedSpecialty = specialtyService.create(specialty);
        return ResponseEntity.status(201).body(savedSpecialty);
    }

    @Operation(
            summary = "Obtener todas las especialidades",
            description = "Devuelve una lista con todas las especialidades médicas registradas.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de especialidades obtenida exitosamente.",
                            content = @Content(schema = @Schema(implementation = SpecialtyEntity.class))),
                    @ApiResponse(responseCode = "204", description = "No hay especialidades registradas.")
            }
    )
    @GetMapping
    public ResponseEntity<List<SpecialtyEntity>> getAllSpecialties() {
        List<SpecialtyEntity> specialties = specialtyService.readAll();
        if (specialties.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(specialties);
    }

    @Operation(
            summary = "Obtener una especialidad por ID",
            description = "Devuelve los detalles de una especialidad médica identificada por su ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Especialidad encontrada exitosamente.",
                            content = @Content(schema = @Schema(implementation = SpecialtyEntity.class))),
                    @ApiResponse(responseCode = "404", description = "Especialidad no encontrada.")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<SpecialtyEntity> getSpecialtyById(@PathVariable Long id) {
        return specialtyService.getSpecialtyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body(null));
    }

    @Operation(
            summary = "Eliminar una especialidad por ID",
            description = "Elimina una especialidad médica identificada por su ID.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Especialidad eliminada exitosamente."),
                    @ApiResponse(responseCode = "404", description = "Especialidad no encontrada.")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSpecialty(@PathVariable Long id) {
        boolean deleted = specialtyService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(404).body("Especialidad no encontrada");
        }
    }
}
