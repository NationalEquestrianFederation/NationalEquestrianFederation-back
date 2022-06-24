package com.example.NationalEquestrianFederation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "officials")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Official extends Person {

    @ManyToMany(targetEntity = Discipline.class, cascade = {CascadeType.MERGE})
    private List<Discipline> disciplines;

}
