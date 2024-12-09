package com.riwi.assessment_appointment.controllers.impl;

import com.riwi.assessment_appointment.models.entities.MedicalScheduleEntity;
import com.riwi.assessment_appointment.services.interfaces.IMedicalScheModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@Tag(name = "Medical Schedules", description = "API para la gestión de horarios médicos")
public class MedicalScheController {

    @Autowired
    private IMedicalScheModel scheduleService;

    // Crear o actualizar un horario
    @Operation(
            summary = "Crear o actualizar un horario médico",
            description = "Permite crear o actualizar un horario médico con los detalles proporcionados.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Horario creado o actualizado exitosamente.", content = @Content(schema = @Schema(implementation = MedicalScheduleEntity.class))),
                    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos.")
            }
    )
    @PostMapping
    public ResponseEntity<MedicalScheduleEntity> saveSchedule(@RequestBody MedicalScheduleEntity schedule) {
        MedicalScheduleEntity savedSchedule = scheduleService.create(schedule);
        return ResponseEntity.status(201).body(savedSchedule);
    }

    // Eliminar un horario por ID

    @Operation(
            summary = "Eliminar un horario médico",
            description = "Elimina un horario médico identificado por su ID.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Horario eliminado exitosamente."),
                    @ApiResponse(responseCode = "404", description = "Horario no encontrado.")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSchedule(@PathVariable Long id) {
        boolean deleted = scheduleService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(404).body("Horario no encontrado");
        }
    }

    // Obtener todos los horarios

    @Operation(
            summary = "Obtener todos los horarios médicos",
            description = "Devuelve una lista con todos los horarios médicos registrados.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de horarios obtenida exitosamente.", content = @Content(array = @ArraySchema(schema = @Schema(implementation = MedicalScheduleEntity.class)))),
                    @ApiResponse(responseCode = "204", description = "No hay horarios registrados.")
            }
    )
    @GetMapping
    public ResponseEntity<List<MedicalScheduleEntity>> getAllSchedules() {
        List<MedicalScheduleEntity> schedules = scheduleService.readAll();
        if (schedules.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(schedules);
    }


    @Operation(
            summary = "Buscar horarios por médico y día",
            description = "Devuelve una lista de horarios médicos para un doctor específico en un día específico.",
            parameters = {
                    @Parameter(name = "doctorId", description = "ID del médico", required = true, example = "1"),
                    @Parameter(name = "date", description = "Fecha en formato YYYY-MM-DD", required = true, example = "2023-12-08")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de horarios obtenida exitosamente.", content = @Content(array = @ArraySchema(schema = @Schema(implementation = MedicalScheduleEntity.class)))),
                    @ApiResponse(responseCode = "204", description = "No hay horarios registrados para los criterios especificados.")
            }
    )
    // Buscar horarios por médico y día
    @GetMapping("/doctor/{doctorId}/date/{date}")
    public ResponseEntity<List<MedicalScheduleEntity>> getSchedulesByDoctorAndDate(
            @PathVariable Long doctorId,
            @PathVariable LocalDate date) {
        List<MedicalScheduleEntity> schedules = scheduleService.getSchedulesByDoctorAndDate(doctorId, date);
        if (schedules.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(schedules);
    }


    @Operation(
            summary = "Buscar horarios disponibles por día",
            description = "Devuelve una lista de horarios médicos disponibles para un día específico.",
            parameters = {
                    @Parameter(name = "date", description = "Fecha en formato YYYY-MM-DD", required = true, example = "2023-12-08")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de horarios disponibles obtenida exitosamente.", content = @Content(array = @ArraySchema(schema = @Schema(implementation = MedicalScheduleEntity.class)))),
                    @ApiResponse(responseCode = "204", description = "No hay horarios disponibles para la fecha especificada.")
            }
    )
    // Buscar horarios disponibles por día
    @GetMapping("/available/date/{date}")
    public ResponseEntity<List<MedicalScheduleEntity>> getAvailableSchedulesByDate(@PathVariable LocalDate date) {
        List<MedicalScheduleEntity> schedules = scheduleService.getAvailableSchedulesByDate(date);
        if (schedules.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(schedules);
    }


    @Operation(
            summary = "Obtener un horario médico por ID",
            description = "Devuelve los detalles de un horario médico identificado por su ID.",
            parameters = {
                    @Parameter(name = "id", description = "ID del horario médico", required = true, example = "1")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Horario encontrado exitosamente.", content = @Content(schema = @Schema(implementation = MedicalScheduleEntity.class))),
                    @ApiResponse(responseCode = "404", description = "Horario no encontrado.")
            }
    )
    // Obtener un horario por ID
    @GetMapping("/{id}")
    public ResponseEntity<MedicalScheduleEntity> getScheduleById(@PathVariable Long id) {
        return scheduleService.getScheduleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body(null));
    }
}
