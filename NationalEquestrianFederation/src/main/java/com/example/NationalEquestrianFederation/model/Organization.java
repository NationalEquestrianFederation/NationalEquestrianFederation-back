package com.example.NationalEquestrianFederation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "organizations")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organization {

    @Id
    @Column(name = "organization_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "web_site")
    private String webSite;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    @OneToOne(targetEntity = User.class, optional = false, cascade = {CascadeType.MERGE})
    private User user;

}
