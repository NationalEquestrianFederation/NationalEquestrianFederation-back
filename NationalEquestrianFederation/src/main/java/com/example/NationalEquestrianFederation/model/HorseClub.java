package com.example.NationalEquestrianFederation.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "horse_clubs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HorseClub {

    @Id
    @Column(name = "horse_club_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address = "";

    @Column(name = "longitude")
    private double longitude = 0;

    @Column(name = "latitude")
    private double latitude = 0;

    @Column(name = "email")
    private String email;

    @Column(name = "description")
    private String description;

    @OneToOne(targetEntity = User.class, optional = false, cascade = {CascadeType.MERGE})
    private User owner;


}
