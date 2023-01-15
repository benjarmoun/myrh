package com.MyRH.MyRH.Repository;

import com.MyRH.MyRH.Entities.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface JobOfferRepository extends JpaRepository<JobOffer, Integer> {

    @Modifying
    @Transactional
    @Query("update JobOffer j set j.status = :status where j.id = :id")
    void acceptJobOffer(@Param("status") boolean status, @Param("id") Integer id);

}
