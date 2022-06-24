package com.example.NationalEquestrianFederation.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "horse_clubs")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HorseClub extends Organization {

    @OneToOne(targetEntity = Location.class, optional = false, cascade = {CascadeType.MERGE})
    private Location location;

    @Column(name = "description")
    private String description;


}
