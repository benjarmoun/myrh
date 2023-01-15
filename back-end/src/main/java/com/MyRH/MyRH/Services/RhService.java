package com.MyRH.MyRH.Services;

import com.MyRH.MyRH.Entities.ResHuman;
import com.MyRH.MyRH.Helpers.Enum;
import com.MyRH.MyRH.Repository.RhRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RhService {
    private final RhRepository rhRepository;

    @Autowired
    public RhService(RhRepository rhRepository) {
        this.rhRepository = rhRepository;
    }

    public List<ResHuman> findAll() {
        return rhRepository.findAll();
    }

    public ResHuman findById(int id) {
        Optional<ResHuman> optional = rhRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new EntityNotFoundException("Rh with id " + id + " not found");
        }
    }
    public ResHuman findRhByEmail(String email){
        Optional<ResHuman> optional = rhRepository.findByEmailTest(email);
        if(optional.isPresent()){
            return optional.get();
        }else{
            System.out.println("makaynch");
        }
//        return optional.isPresent()? optional.get() : null;
        return rhRepository.findByEmail(email);
    }

    public UserDetails findByEmail(String email) {
        Optional<ResHuman> optional = rhRepository.findByEmailTest(email);
        if (optional.isPresent()) {
            ResHuman user = optional.isPresent() ? optional.get() : null ;
            return user == null ? null : new User(
                    user.getEmail(),
                    user.getPassword(),
                    Collections.singleton(new SimpleGrantedAuthority(Enum.role.ResHuman.toString())));
        } else {
            throw new EntityNotFoundException("Rh with email " + email + " not found");
        }
    }

    public ResHuman save(ResHuman rh) {
        return rhRepository.save(rh);
    }

    public void delete(ResHuman rh) {
        rhRepository.delete(rh);
    }

    // Optional additional methods

}
