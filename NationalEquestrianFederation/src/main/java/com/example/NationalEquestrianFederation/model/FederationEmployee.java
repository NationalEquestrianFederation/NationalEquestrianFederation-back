package com.example.NationalEquestrianFederation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "federation_employees")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FederationEmployee extends Person {

    @Column(name = "position")
    private String position;

}
