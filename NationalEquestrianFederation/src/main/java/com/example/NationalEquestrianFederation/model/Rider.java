package com.example.NationalEquestrianFederation.model;

import com.example.NationalEquestrianFederation.model.enums.Gender;
import com.example.NationalEquestrianFederation.model.enums.Licence;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "riders")
@Data
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

    @OneToOne(optional = false)
    @JoinColumn(name = "horse_club", referencedColumnName = "horse_club_id")
    private HorseClub horseClub;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    @ManyToMany(targetEntity = Competition.class, fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    private List<Competition> competitions;


}
