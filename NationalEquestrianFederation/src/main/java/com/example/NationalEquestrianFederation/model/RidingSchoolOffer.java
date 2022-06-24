package com.example.NationalEquestrianFederation.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "riding_school_offers")
@Data
public class RidingSchoolOffer {

    @Id
    @Column(name = "offer_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "description")
    private String description;

    @ManyToOne(optional = false, targetEntity = HorseClub.class, cascade = CascadeType.MERGE)
    private HorseClub horseClub;

    @Column(name = "is_deleted")
    private boolean isDeleted;

}
