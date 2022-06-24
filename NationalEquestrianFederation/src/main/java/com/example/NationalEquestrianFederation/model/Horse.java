package com.example.NationalEquestrianFederation.model;

import com.example.NationalEquestrianFederation.model.enums.HorseGender;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "horses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Horse {

    @Id
    @Column(name = "horse_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "year_of_birth")
    private Integer yearOfBirth;

    @Column(name = "owner")
    private String owner;

    @Column(name = "gender")
    private HorseGender gender;

    @Column(name = "image", columnDefinition="TEXT")
    private String image;

    @ManyToOne(optional = false, targetEntity = HorseClub.class, cascade = CascadeType.MERGE)
    private HorseClub horseClub;

    @Column(name= "is_deleted")
    private boolean isDeleted = false;

}
