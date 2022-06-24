package com.example.NationalEquestrianFederation.model;

import com.example.NationalEquestrianFederation.model.enums.Discipline;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "competition_requests")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionRequest {

    @Id
    @Column(name = "application_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = Federation.class, optional = false, cascade = {CascadeType.MERGE})
    private Federation federation;

    @Column(name = "allowed")
    private boolean allowed;

    private boolean checked;

    @Column(name = "name")
    private String competitionName;

    @Column(name = "location")
    private String competitionLocation;

    @Column(name = "start_date")
    private String competitionStartDate;

    @Column(name = "end_date")
    private String competitionEndDate;

    @Column(name = "discipline")
    private Discipline discipline;

    @Column(name = "organizer")
    private String competitionOrganizer;

}
