package com.example.NationalEquestrianFederation.model;

import com.example.NationalEquestrianFederation.model.enums.HorseGender;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "horses")
@Data
public class Horse {

    @Id
    @Column(name = "horse_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @Column(name = "name")
    @Getter @Setter private String name;

    @Column(name = "year_of_birth")
    @Getter @Setter private Integer yearOfBirth;

    @Column(name = "owner")
    @Getter @Setter private String owner;

    @Column(name = "gender")
    @Getter @Setter private HorseGender gender;

    @OneToOne(optional = false)
    @JoinColumn(name = "horse_club", referencedColumnName = "horse_club_id")
    @Getter @Setter private HorseClub horseClub;

    @Column(name= "is_deleted")
    @Getter @Setter private boolean isDeleted;

}
