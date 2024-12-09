package com.riwi.assessment_appointment.repositories;

import com.riwi.assessment_appointment.models.entities.MedicalScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MedicalScheRepository  extends JpaRepository<MedicalScheduleEntity, Long> {
    List<MedicalScheduleEntity> findByDoctorIdAndDia(Long doctorId, LocalDate dia);

    // Buscar horarios disponibles por día
    List<MedicalScheduleEntity> findByDiaAndAvailabilityTrue(LocalDate dia);
}
