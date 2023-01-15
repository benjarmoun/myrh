package com.MyRH.MyRH.Services;

import com.MyRH.MyRH.Entities.Agent;
import com.MyRH.MyRH.Entities.ResHuman;
import com.MyRH.MyRH.Helpers.Enum;
import com.MyRH.MyRH.Repository.AgentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AgentService{
    private final AgentRepository agentRepository;

    @Autowired
    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public List<Agent> findAll() {
        return agentRepository.findAll();
    }

    public Agent findById(int id) {
        Optional<Agent> optional = agentRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new EntityNotFoundException("Agent with id " + id + " not found");
        }
    }
    public UserDetails findByEmail(String email) {
        Optional<Agent> optional = agentRepository.findByEmail(email);
        if (optional.isPresent()) {
            return  new User(
                    optional.get().getEmail(),
                    optional.get().getPassword(),
                    Collections.singleton(new SimpleGrantedAuthority(Enum.role.AGENT.toString())));
        } else {
//            throw new EntityNotFoundException("Agent with email " + email + " not found");
            return null;
        }
    }

    public Agent save(Agent agent) {
        return agentRepository.save(agent);
    }

    public void delete(Agent agent) {
        agentRepository.delete(agent);
    }

// Optional additional methods
}
