package com.example.NationalEquestrianFederation.model;

import com.example.NationalEquestrianFederation.model.enums.FederationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "federations")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Federation extends Organization {

    @Column(name = "address")
    private String address;

    @Column(name = "federation_type")
    private FederationType federationType;

}
