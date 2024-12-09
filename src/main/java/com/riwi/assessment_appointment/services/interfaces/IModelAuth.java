package com.riwi.assessment_appointment.services.interfaces;

import com.riwi.assessment_appointment.models.DTOs.request.LoginRequest;
import com.riwi.assessment_appointment.models.DTOs.request.RegistreRequest;
import com.riwi.assessment_appointment.models.DTOs.response.LoginResponse;
import com.riwi.assessment_appointment.models.DTOs.response.RegistreResponse;
import com.riwi.assessment_appointment.models.entities.UserEntity;
import com.riwi.assessment_appointment.services.generics.Create;
import com.riwi.assessment_appointment.services.generics.Delete;
import com.riwi.assessment_appointment.services.generics.ReadAll;
import com.riwi.assessment_appointment.services.generics.Update;
import com.riwi.assessment_appointment.utils.enums.Roles;

public interface IModelAuth  {
    RegistreResponse register(RegistreRequest registerRequestDTO, Roles role);

    LoginResponse login(LoginRequest loginRequestDTO);
}
