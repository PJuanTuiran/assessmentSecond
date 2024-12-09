package com.riwi.assessment_appointment.services.interfaces;

import com.riwi.assessment_appointment.models.entities.SpecialtyEntity;
import com.riwi.assessment_appointment.services.generics.Create;
import com.riwi.assessment_appointment.services.generics.Delete;
import com.riwi.assessment_appointment.services.generics.ReadAll;

import java.util.Optional;

public interface ISpecialtyModel extends  ReadAll<SpecialtyEntity>, Delete<Long> {
    public SpecialtyEntity create(SpecialtyEntity specialty);
    public Optional<SpecialtyEntity> getSpecialtyById(Long id);
}
