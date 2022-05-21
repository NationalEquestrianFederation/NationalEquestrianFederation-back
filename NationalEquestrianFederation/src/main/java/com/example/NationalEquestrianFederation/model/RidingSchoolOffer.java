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
    @Getter
    @Setter
    private Integer id;

    @Column(name = "name")
    @Getter @Setter private String name;

    @Column(name = "price")
    @Getter @Setter private double price;

    @Column(name = "start_date")
    @Getter @Setter private String startDate;

    @Column(name = "end_date")
    @Getter @Setter private String endDate;

    @Column(name = "description")
    @Getter @Setter private String description;

    @Column(name = "horse_club")
    @Getter @Setter private Integer horseClub;

    @Column(name = "is_deleted")
    @Getter @Setter private boolean isDeleted;

}
