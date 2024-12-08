package com.riwi.assessment_appointment.controllers.impl;

import com.riwi.assessment_appointment.controllers.interfaces.IAppointmentController;
import com.riwi.assessment_appointment.models.DTOs.request.AppointmentRequest;
import com.riwi.assessment_appointment.models.entities.AppointmentEntity;
import com.riwi.assessment_appointment.services.interfaces.IAppointmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController implements IAppointmentController {
    @Autowired
    IAppointmentModel appointmentModel;

    // Crear una cita
    @PostMapping("/create")
    @Override
    public ResponseEntity<?> create(@RequestBody AppointmentRequest request) {
        AppointmentEntity createdAppointment = appointmentModel.create(request);
        return ResponseEntity.status(201).body(createdAppointment);  // Respuesta con código 201 Created
    }

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
    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AppointmentRequest request) {
        AppointmentEntity updatedAppointment = appointmentModel.update(id, request);
        if (updatedAppointment != null) {
            return ResponseEntity.ok(updatedAppointment);  // Respuesta con código 200 OK y cita actualizada
        } else {
            return ResponseEntity.status(404).body("Cita no encontrada");  // Respuesta con código 404 si no se encontró la cita
        }
    }
}
