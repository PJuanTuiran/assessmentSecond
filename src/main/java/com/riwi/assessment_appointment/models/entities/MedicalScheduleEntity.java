package com.riwi.assessment_appointment.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity(name = "schedules")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private UserEntity doctor;

    private LocalDate dia; // Día específico (ej: 2023-12-06)

    @Column(name = "hora_inicio")
    private LocalTime startTime;

    @Column(name = "hora_fin")
    private LocalTime endTime;

    // Indica si el médico está ausente por alguna razón
    private boolean availability;
}
