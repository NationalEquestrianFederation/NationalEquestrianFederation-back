package com.example.NationalEquestrianFederation.model;

import com.example.NationalEquestrianFederation.model.enums.Gender;
import com.example.NationalEquestrianFederation.model.enums.Licence;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "riders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rider {

    @Id
    @Column(name = "rider_id", nullable = false)
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

    @Column(name = "licence")
    private Licence licence;

    @ManyToOne(targetEntity = HorseClub.class, optional = false, cascade = {CascadeType.MERGE})
    private HorseClub horseClub;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;


}
