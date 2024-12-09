package com.riwi.assessment_appointment.services.impl;

import com.riwi.assessment_appointment.models.entities.MedicalScheduleEntity;
import com.riwi.assessment_appointment.repositories.MedicalScheRepository;
import com.riwi.assessment_appointment.services.interfaces.IMedicalScheModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class MedicalScheModel implements IMedicalScheModel {


    @Autowired
    private MedicalScheRepository scheduleRepository;

    // Crear o actualizar un horario
    public MedicalScheduleEntity create(MedicalScheduleEntity schedule) {
        return scheduleRepository.save(schedule);
    }

    // Eliminar un horario por ID
    public boolean delete(Long id) {
        if (scheduleRepository.existsById(id)) {
            scheduleRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Obtener todos los horarios
    public List<MedicalScheduleEntity> readAll() {
        return scheduleRepository.findAll();
    }

    // Buscar horarios por médico y día
    public List<MedicalScheduleEntity> getSchedulesByDoctorAndDate(Long doctorId, LocalDate dia) {
        return scheduleRepository.findByDoctorIdAndDia(doctorId, dia);
    }

    // Buscar horarios disponibles en un día específico
    public List<MedicalScheduleEntity> getAvailableSchedulesByDate(LocalDate dia) {
        return scheduleRepository.findByDiaAndAvailabilityTrue(dia);
    }

    // Obtener horario por ID
    public Optional<MedicalScheduleEntity> getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }
}
