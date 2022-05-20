package com.example.NationalEquestrianFederation.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "horse_clubs")
@Data
public class HorseClub {

    @Id
    @Column(name = "horse_club_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @Column(name = "name")
    @Getter @Setter private String name;

    @Column(name = "phone")
    @Getter @Setter private String phone;

    @Column(name = "address")
    @Getter @Setter private String address;

    @Column(name = "email")
    @Getter @Setter private String email;

    @Column(name = "owner")
    @Getter @Setter private Integer owner;


}
