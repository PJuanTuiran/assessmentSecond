package com.riwi.assessment_appointment.models.DTOs.request;

import com.riwi.assessment_appointment.utils.enums.AppointmentStatus;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentRequest {

    @Size(max = 500, message = "Las notas no pueden exceder los 500 caracteres.")
    private String notes;

    @NotBlank(message = "El motivo de la cita es obligatorio.")
    @Size(max = 255, message = "El motivo no puede exceder los 255 caracteres.")
    private String reason;

    @NotNull(message = "La fecha y hora de la cita son obligatorias.")
    @Future(message = "La fecha y hora deben estar en el futuro.")
    private LocalDateTime dateTime;

    @NotNull(message = "El estado de la cita es obligatorio.")
    private AppointmentStatus status;

    @NotNull(message = "El ID del paciente es obligatorio.")
    @Positive(message = "El ID del paciente debe ser un número positivo.")
    private Long patientId;

    @NotNull(message = "El ID del médico es obligatorio.")
    @Positive(message = "El ID del médico debe ser un número positivo.")
    private Long doctorId;
}

