package com.riwi.assessment_appointment.services.interfaces;

import com.riwi.assessment_appointment.models.DTOs.request.AppointmentRequest;
import com.riwi.assessment_appointment.models.entities.AppointmentEntity;
import com.riwi.assessment_appointment.services.generics.Create;
import com.riwi.assessment_appointment.services.generics.Delete;
import com.riwi.assessment_appointment.services.generics.ReadAll;
import com.riwi.assessment_appointment.services.generics.Update;

public interface IAppointmentModel extends Create<AppointmentEntity, AppointmentRequest>, ReadAll<AppointmentEntity>, Update<Long, AppointmentEntity, AppointmentRequest>, Delete<Long> {
}
