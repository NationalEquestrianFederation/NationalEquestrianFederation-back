package com.example.NationalEquestrianFederation.repository;

import com.example.NationalEquestrianFederation.model.RidingSchoolOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface IRidingSchoolOfferRepository extends JpaRepository<RidingSchoolOffer, Integer> {

    @Query("SELECT o FROM RidingSchoolOffer o WHERE (?1 = 0 OR o.horseClub = ?1) AND o.isDeleted = false")
    List<RidingSchoolOffer> findOffersByHorseClub(Integer horseClub);

    @Query("UPDATE RidingSchoolOffer o SET o.isDeleted = true WHERE o.id = ?1")
    @Modifying
    @Transactional
    void deleteRidingSchoolOffer(Integer offerId);

}
