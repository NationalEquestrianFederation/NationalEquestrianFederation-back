package com.example.NationalEquestrianFederation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "competitions_competitors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionApplication {

    @Id
    @Column(name = "competitions_competitors_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = Rider.class, optional = false, cascade = {CascadeType.MERGE})
    private Rider rider;

    @ManyToOne(targetEntity = Horse.class, optional = false, cascade = {CascadeType.MERGE})
    private Horse horse;

    @ManyToOne(targetEntity = Competition.class, optional = false, cascade = {CascadeType.MERGE})
    private Competition competition;

    public CompetitionApplication(Rider rider, Horse horse, Competition competition) {
        this.rider = rider;
        this.horse = horse;
        this.competition = competition;
    }

}
