package com.riwi.assessment_appointment.models.DTOs.response;

import com.riwi.assessment_appointment.utils.enums.Roles;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistreResponse {
    private String message;
    private String username;
    private Roles role;
}
