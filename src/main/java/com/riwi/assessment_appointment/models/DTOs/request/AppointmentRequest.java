package com.riwi.assessment_appointment.models.DTOs.request;

import com.riwi.assessment_appointment.utils.enums.AppointmentStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentRequest {

    private String notes;
    private String reason;
    private LocalDateTime dateTime;
    private AppointmentStatus status;
    private Long patientId;
    private Long doctorId;
}
