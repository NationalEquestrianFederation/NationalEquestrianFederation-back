package com.example.NationalEquestrianFederation.model;

import com.example.NationalEquestrianFederation.model.enums.Gender;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "trainers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trainer {

    @Id
    @Column(name = "trainer_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "gender")
    private Gender gender;

    @ManyToOne(optional = true, targetEntity = HorseClub.class, cascade = CascadeType.MERGE)
    private HorseClub horseClub;

    @Column(name = "is_deleted")
    private boolean isDeleted;

}
