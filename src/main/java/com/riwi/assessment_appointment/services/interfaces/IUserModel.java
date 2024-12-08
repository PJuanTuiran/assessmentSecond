package com.riwi.assessment_appointment.services.interfaces;

import com.riwi.assessment_appointment.models.entities.UserEntity;
import com.riwi.assessment_appointment.services.generics.Create;
import com.riwi.assessment_appointment.services.generics.Delete;
import com.riwi.assessment_appointment.services.generics.ReadAll;
import com.riwi.assessment_appointment.services.generics.Update;

public interface IUserModel extends Create<UserEntity, >,ReadAll<UserEntity>,Update<UserEntity>,Delete<Long>{ {
}