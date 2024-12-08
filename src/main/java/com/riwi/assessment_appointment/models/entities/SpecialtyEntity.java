package com.riwi.assessment_appointment.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
@Entity(name = "specialties")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpecialtyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "specialty")
    private ArrayList<UserEntity> doctors;
}
