package com.example.NationalEquestrianFederation.model;

import com.example.NationalEquestrianFederation.model.enums.Discipline;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "competitions")
@Data
public class Competition {

    @Id
    @Column(name = "competition_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "discipline")
    private Discipline discipline;

}
