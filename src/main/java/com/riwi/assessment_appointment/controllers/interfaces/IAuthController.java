package com.riwi.assessment_appointment.controllers.interfaces;

import com.riwi.assessment_appointment.controllers.generics.ReadAll;
import com.riwi.assessment_appointment.models.DTOs.request.LoginRequest;
import com.riwi.assessment_appointment.models.DTOs.request.RegistreRequest;
import com.riwi.assessment_appointment.models.entities.UserEntity;
import org.springframework.http.ResponseEntity;

public interface IAuthController extends ReadAll<UserEntity> {
    ResponseEntity<?> registerAdmin(RegistreRequest registerRequestDTO);

    ResponseEntity<?> registerPatient(RegistreRequest registerRequestDTO);
    ResponseEntity<?> registerDoctor(RegistreRequest registerRequestDTO);

    ResponseEntity<?> login(LoginRequest loginRequestDTO);

}
