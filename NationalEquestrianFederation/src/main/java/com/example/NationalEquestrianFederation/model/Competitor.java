package com.example.NationalEquestrianFederation.model;

import com.example.NationalEquestrianFederation.model.enums.Gender;
import com.example.NationalEquestrianFederation.model.enums.Licence;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "competitors")
@Data
public class Competitor {

    @Id
    @Column(name = "competitor_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @Column(name = "name")
    @Getter @Setter private String name;

    @Column(name = "surname")
    @Getter @Setter private String surname;

    @Column(name = "date_of_birth")
    @Getter @Setter private String dateOfBirth;

    @Column(name = "gender")
    @Getter @Setter private Gender gender;

    @Column(name = "licence")
    @Getter @Setter private Licence licence;


}
