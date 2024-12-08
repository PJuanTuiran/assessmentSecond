package com.riwi.assessment_appointment.models.entities;

import com.riwi.assessment_appointment.utils.enums.Roles;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Entity(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private boolean active;
    @Enumerated(EnumType.STRING)
    private Roles role;

    @OneToMany(mappedBy = "patient")
    private ArrayList<AppointmentEntity> appointments;
    @OneToMany(mappedBy = "doctor")
    private ArrayList<AppointmentEntity> assignedAppointments;
    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private SpecialtyEntity specialty;
}
