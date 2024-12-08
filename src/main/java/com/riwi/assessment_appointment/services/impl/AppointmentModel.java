package com.riwi.assessment_appointment.services.impl;

import com.riwi.assessment_appointment.models.DTOs.request.AppointmentRequest;
import com.riwi.assessment_appointment.models.entities.AppointmentEntity;
import com.riwi.assessment_appointment.models.entities.UserEntity;
import com.riwi.assessment_appointment.repositories.AppointmentRepository;
import com.riwi.assessment_appointment.repositories.UserRepository;
import com.riwi.assessment_appointment.services.interfaces.IAppointmentModel;
import com.riwi.assessment_appointment.utils.enums.AppointmentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentModel implements IAppointmentModel {

    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public AppointmentEntity create(AppointmentRequest appointmentRequest) {

        UserEntity patient = userRepository.findById(appointmentRequest.getPatientId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        UserEntity doctor = userRepository.findById(appointmentRequest.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));
        AppointmentStatus status = appointmentRequest.getStatus() != null ? appointmentRequest.getStatus() : AppointmentStatus.SCHEDULED;
        AppointmentEntity appointmentEntity =  AppointmentEntity.builder()
                .notes(appointmentRequest.getNotes())
                .reason(appointmentRequest.getReason())
                .dateTime(appointmentRequest.getDateTime())
                .patient(patient)
                .doctor(doctor)
                .status(status)
                .build();


        return appointmentRepository.save(appointmentEntity);
    }

    @Override
    public boolean delete(Long id) {
        Optional<AppointmentEntity> appointmentEntity = appointmentRepository.findById(id);

        if (appointmentEntity.isPresent()) {
            appointmentRepository.deleteById(id);
            return true;

        }
        return false;



    }

    @Override
    public List<AppointmentEntity> readAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public AppointmentEntity update(Long id,AppointmentRequest appointmentRequest) {
        // Buscar la cita existente por su ID
        AppointmentEntity appointmentEntity = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        UserEntity patient = userRepository.findById(appointmentRequest.getPatientId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        UserEntity doctor = userRepository.findById(appointmentRequest.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));
        AppointmentStatus status = appointmentRequest.getStatus() != null ? appointmentRequest.getStatus() : AppointmentStatus.SCHEDULED;
        appointmentEntity.setNotes(appointmentRequest.getNotes());
        appointmentEntity.setReason(appointmentRequest.getReason());
        appointmentEntity.setDateTime(appointmentRequest.getDateTime());
        appointmentEntity.setPatient(patient);
        appointmentEntity.setDoctor(doctor);
        appointmentEntity.setStatus(status);

        return appointmentRepository.save(appointmentEntity);
    }
}
