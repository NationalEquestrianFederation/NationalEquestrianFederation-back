package com.example.NationalEquestrianFederation.repository;

import com.example.NationalEquestrianFederation.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRoleRepository extends JpaRepository<Role, Integer> {

    @Query("SELECT r FROM Role r WHERE r.name = ?1 ")
    Role findByName(String name);

}
