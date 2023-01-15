package com.MyRH.MyRH.Repository;

import com.MyRH.MyRH.Entities.ResHuman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RhRepository extends JpaRepository<ResHuman, Integer> {
    @Query("SELECT r FROM ResHuman r WHERE r.email = :email")
    Optional<ResHuman> findByEmailTest(@Param("email") String email);

    ResHuman findByEmail(String email);
}
