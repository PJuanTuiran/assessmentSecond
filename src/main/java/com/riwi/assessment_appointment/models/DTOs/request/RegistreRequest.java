package com.riwi.assessment_appointment.models.DTOs.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistreRequest {
    @NotBlank(message = "El nombre no puede estar vacio")
    private String name;
    private String username;
    @Email(message = "El correo no es valido")
    private String email;
    @NotBlank(message = "La contraseña no puede estar vacia")
    private String password;
}
