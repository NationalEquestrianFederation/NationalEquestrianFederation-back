package com.example.NationalEquestrianFederation.model;

import com.example.NationalEquestrianFederation.model.enums.Licence;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "riders")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rider extends Person {

    @Column(name = "licence")
    private Licence licence;

    @ManyToOne(targetEntity = HorseClub.class, optional = false, cascade = {CascadeType.MERGE})
    private HorseClub horseClub;


}
