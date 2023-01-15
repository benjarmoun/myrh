package com.MyRH.MyRH.Repository;

import com.MyRH.MyRH.Entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AgentRepository extends JpaRepository<Agent, Integer> {
    @Query("SELECT a FROM Agent a WHERE a.email = :email")
    Optional<Agent> findByEmail(@Param("email") String email);
}