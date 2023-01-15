package com.MyRH.MyRH.Services;

import com.MyRH.MyRH.Entities.JobOffer;
import com.MyRH.MyRH.Repository.JobOfferRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobOfferService {
    private final JobOfferRepository jobOfferRepository;

    @Autowired
    public JobOfferService(JobOfferRepository jobOfferRepository) {
        this.jobOfferRepository = jobOfferRepository;
    }

    public List<JobOffer> findAll() {
        return jobOfferRepository.findAll();
    }

    public JobOffer findById(int id) {
        Optional<JobOffer> optional = jobOfferRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new EntityNotFoundException("JobOffer with id " + id + " not found");
        }
    }

    public JobOffer save(JobOffer jobOffer) {
        return jobOfferRepository.save(jobOffer);
    }

    public void delete(JobOffer jobOffer) {
        jobOfferRepository.delete(jobOffer);
    }

    public boolean deleteJobOfferById(int id) {
        if (findById(id) != null) {
            jobOfferRepository.deleteById(id);
            return true;
        }else
            return false;
    }

    public void acceptJobOffer(int id){
        jobOfferRepository.acceptJobOffer(true, id);
    }

}

