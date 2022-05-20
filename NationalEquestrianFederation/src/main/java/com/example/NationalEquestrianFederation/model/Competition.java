package com.example.NationalEquestrianFederation.model;

import com.example.NationalEquestrianFederation.model.enums.Discipline;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "competitions")
@Data
public class Competition {

    @Id
    @Column(name = "competition_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @Column(name = "name")
    @Getter @Setter private String name;

    @Column(name = "location")
    @Getter @Setter private String location;

    @Column(name = "start_date")
    @Getter @Setter private String startDate;

    @Column(name = "end_date")
    @Getter @Setter private String endDate;

    @Column(name = "discipline")
    @Getter @Setter private Discipline discipline;

}
