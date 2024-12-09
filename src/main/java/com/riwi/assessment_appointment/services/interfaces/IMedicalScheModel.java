package com.riwi.assessment_appointment.services.interfaces;

import com.riwi.assessment_appointment.models.entities.MedicalScheduleEntity;
import com.riwi.assessment_appointment.services.generics.Create;
import com.riwi.assessment_appointment.services.generics.Delete;
import com.riwi.assessment_appointment.services.generics.ReadAll;
import com.riwi.assessment_appointment.services.generics.Update;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IMedicalScheModel extends  ReadAll<MedicalScheduleEntity>, Delete<Long> {
    public MedicalScheduleEntity create(MedicalScheduleEntity schedule);
    public List<MedicalScheduleEntity> getSchedulesByDoctorAndDate(Long doctorId, LocalDate dia);
    public List<MedicalScheduleEntity> getAvailableSchedulesByDate(LocalDate dia);
    public Optional<MedicalScheduleEntity> getScheduleById(Long id);
}
