package com.example.NationalEquestrianFederation.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "trainers")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trainer extends Person {

    @OneToOne(optional = true, targetEntity = HorseClub.class, cascade = CascadeType.MERGE)
    private HorseClub horseClub;

}
