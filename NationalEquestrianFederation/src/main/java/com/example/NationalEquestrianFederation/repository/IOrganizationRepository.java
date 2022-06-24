package com.example.NationalEquestrianFederation.repository;

import com.example.NationalEquestrianFederation.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface IOrganizationRepository extends JpaRepository<Organization, Integer> {

    //SELECT
    @Query("SELECT o FROM Organization o WHERE o.user.id = ?1 ")
    Organization getOrganizationByUser(Integer userId);

    //UPDATE

    @Query("UPDATE Organization o " +
            "SET o.name = ?2, o.phoneNumber = ?3, o.email = ?4, o.webSite = ?5 " +
            "WHERE o.id = ?1")
    @Modifying
    @Transactional
    void editOrganization(Integer id, String name, String phone, String email, String webSite);

}
