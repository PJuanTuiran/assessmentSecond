package com.riwi.assessment_appointment.models.DTOs.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpecialtyRequest {
    @NotBlank(message = "El nombre de la especialidad es requerido")
    private String name;

}
