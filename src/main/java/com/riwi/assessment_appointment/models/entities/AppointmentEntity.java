package com.riwi.assessment_appointment.models.entities;

import com.riwi.assessment_appointment.utils.enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "appointments")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String notes;
    private String reason;
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private UserEntity patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private UserEntity doctor;
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;


}
