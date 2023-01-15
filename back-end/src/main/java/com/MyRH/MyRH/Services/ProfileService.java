package com.MyRH.MyRH.Services;

import com.MyRH.MyRH.Entities.Profile;
import com.MyRH.MyRH.Repository.ProfileRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService{
    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    public Profile findById(int id) {
        Optional<Profile> optional = profileRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new EntityNotFoundException("Profile with id " + id + " not found");
        }
    }

    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

    public void delete(Profile profile) {
        profileRepository.delete(profile);
    }



    // Optional additional methods
}