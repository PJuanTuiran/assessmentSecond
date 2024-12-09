package com.riwi.assessment_appointment.services.impl;

import com.riwi.assessment_appointment.models.entities.SpecialtyEntity;
import com.riwi.assessment_appointment.repositories.SpecialtyRepository;
import com.riwi.assessment_appointment.services.interfaces.ISpecialtyModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SpecialtyModel implements ISpecialtyModel {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    // Crear o actualizar una especialidad
    public SpecialtyEntity create(SpecialtyEntity specialty) {
        return specialtyRepository.save(specialty);
    }

    // Obtener todas las especialidades
    public List<SpecialtyEntity> readAll() {
        return specialtyRepository.findAll();
    }

    // Obtener una especialidad por ID
    public Optional<SpecialtyEntity> getSpecialtyById(Long id) {
        return specialtyRepository.findById(id);
    }

    // Eliminar una especialidad por ID
    public boolean delete(Long id) {
        if (specialtyRepository.existsById(id)) {
            specialtyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
