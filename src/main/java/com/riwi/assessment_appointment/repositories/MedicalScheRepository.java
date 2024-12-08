package com.riwi.assessment_appointment.repositories;

import com.riwi.assessment_appointment.models.entities.MedicalScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalScheRepository  extends JpaRepository<MedicalScheduleEntity, Long> {
}
