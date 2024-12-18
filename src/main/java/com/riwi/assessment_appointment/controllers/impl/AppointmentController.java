package com.riwi.assessment_appointment.controllers.impl;

import com.riwi.assessment_appointment.controllers.interfaces.IAppointmentController;
import com.riwi.assessment_appointment.models.DTOs.request.AppointmentRequest;
import com.riwi.assessment_appointment.models.entities.AppointmentEntity;
import com.riwi.assessment_appointment.services.interfaces.IAppointmentModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/appointment")
@Tag(name = "Appointment Management", description = "API para la gestión de citas en la clínica.")
public class AppointmentController implements IAppointmentController {
    @Autowired
    IAppointmentModel appointmentModel;

    // Crear una cita
    @Operation(
            summary = "Crear una nueva cita",
            description = "Permite crear una cita proporcionando la información necesaria.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Cita creada exitosamente.", content = @Content(schema = @Schema(implementation = AppointmentEntity.class))),
                    @ApiResponse(responseCode = "400", description = "Solicitud inválida.")
            }
    )
    @PostMapping("/create")
    @Override
    public ResponseEntity<?> create(@RequestBody @Valid AppointmentRequest request) {
        AppointmentEntity createdAppointment = appointmentModel.create(request);
        return ResponseEntity.status(201).body(createdAppointment);  // Respuesta con código 201 Created
    }


    @Operation(
            summary = "Eliminar una cita existente",
            description = "Elimina una cita según el ID proporcionado.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Cita eliminada exitosamente."),
                    @ApiResponse(responseCode = "404", description = "Cita no encontrada.")
            }
    )
    // Eliminar una cita
    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean deleted = appointmentModel.delete(id);
        if (deleted) {
            return ResponseEntity.status(200).build();  // Respuesta con código 204 No Content (eliminado correctamente)
        } else {
            return ResponseEntity.status(404).body("Cita no encontrada");  // Respuesta con código 404 si no se encontró la cita
        }
    }


    @Operation(
            summary = "Obtener todas las citas",
            description = "Devuelve una lista de todas las citas registradas.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de citas obtenida exitosamente.", content = @Content(array = @ArraySchema(schema = @Schema(implementation = AppointmentEntity.class)))),
                    @ApiResponse(responseCode = "204", description = "No hay citas registradas.")
            }
    )
    // Leer todas las citas
    @GetMapping("/readAll")
    @Override
    public ResponseEntity<List<AppointmentEntity>> readAll() {
        List<AppointmentEntity> appointments = appointmentModel.readAll();
        if (appointments.isEmpty()) {
            return ResponseEntity.status(204).build();  // Respuesta con código 204 No Content si no hay citas
        }
        return ResponseEntity.ok(appointments);  // Respuesta con código 200 OK y lista de citas
    }


    // Actualizar una cita
    @Operation(
            summary = "Actualizar una cita existente",
            description = "Actualiza la información de una cita según el ID proporcionado.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Cita actualizada exitosamente.", content = @Content(schema = @Schema(implementation = AppointmentEntity.class))),
                    @ApiResponse(responseCode = "404", description = "Cita no encontrada.")
            }
    )
    // Actualizar una cita
    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid AppointmentRequest request) {
        AppointmentEntity updatedAppointment = appointmentModel.update(id, request);
        if (updatedAppointment != null) {
            return ResponseEntity.ok(updatedAppointment);  // Respuesta con código 200 OK y cita actualizada
        } else {
            return ResponseEntity.status(404).body("Cita no encontrada");  // Respuesta con código 404 si no se encontró la cita
        }
    }
}
