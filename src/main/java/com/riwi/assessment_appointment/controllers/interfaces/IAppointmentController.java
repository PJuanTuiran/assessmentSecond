package com.riwi.assessment_appointment.controllers.interfaces;

import com.riwi.assessment_appointment.controllers.generics.Create;
import com.riwi.assessment_appointment.controllers.generics.Delete;
import com.riwi.assessment_appointment.controllers.generics.ReadAll;
import com.riwi.assessment_appointment.controllers.generics.Update;
import com.riwi.assessment_appointment.models.DTOs.request.AppointmentRequest;
import com.riwi.assessment_appointment.models.entities.AppointmentEntity;

public interface IAppointmentController extends Create<AppointmentEntity, AppointmentRequest>, ReadAll<AppointmentEntity>, Delete<Long>, Update< Long, AppointmentEntity, AppointmentRequest> {
}
