package com.riwi.assessment_appointment.repositories;

import com.riwi.assessment_appointment.models.entities.SpecialtyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<SpecialtyEntity, Long> {
}
