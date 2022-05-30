package com.example.NationalEquestrianFederation.repository;

import com.example.NationalEquestrianFederation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.username=?1")
    User findByUsername(String username);

}
