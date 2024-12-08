package com.riwi.assessment_appointment.models.DTOs.response;

import com.riwi.assessment_appointment.utils.enums.Roles;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginResponse {
    private String message;
    private Roles role;
    private String token;
}
