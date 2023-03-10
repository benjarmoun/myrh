package com.MyRH.MyRH.Controller;
import com.MyRH.MyRH.DTO.JobOfferRequest;
import com.MyRH.MyRH.Entities.JobOffer;
import com.MyRH.MyRH.Entities.ResHuman;
import com.MyRH.MyRH.Helpers.AuthenticatedUserInfo;
import com.MyRH.MyRH.Services.JobOfferService;
import com.MyRH.MyRH.Services.ProfileService;
import com.MyRH.MyRH.Services.RhService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@RequestMapping("rh")
@RestController
public class JobOfferController {

    private final JobOfferService jobOfferService;
    private final ProfileService profileService;
    private final AuthenticatedUserInfo authUserInfo;
    private final RhService rhService;


    @Autowired
    public JobOfferController(JobOfferService jobOfferService, ProfileService profileService, AuthenticatedUserInfo authUserInfo, RhService rhService) {
        this.jobOfferService = jobOfferService;
        this.profileService = profileService;
        this.authUserInfo = authUserInfo;
        this.rhService = rhService;
    }



    @PostMapping("rh/addJobOffer")
    public ResponseEntity<String> createJobOffer(HttpServletRequest req ,@RequestBody JobOfferRequest request){
        JobOffer jobOffer = new JobOffer(request.getTitle(), request.getDescription(),profileService.findById(request.getProfileId()), request.getCity(), request.getDegree(), request.getSalary(), false, rhService.findRhByEmail(authUserInfo.getEmail(req)));
        if(jobOfferService.save(jobOffer) !=null){
            return ResponseEntity.ok("Job Offer created successfully, waiting for confirmation");
        }else
            return ResponseEntity.status(400).body("Job offer creation failed, Retry later");
    }

    @GetMapping("rh/deleteJobOffer/{id}")
    public ResponseEntity<String> deleteJobOffer(@PathVariable String id){
        if(jobOfferService.deleteJobOfferById(Integer.parseInt(id))){
            return ResponseEntity.ok("Job Offer deleted successfully");
        }else
            return ResponseEntity.status(400).body("Job offer delete failed, Retry later");
    }

    @GetMapping("agent/allJobOffers")
    public ResponseEntity<Object> getAllJobOffer(){
        if(jobOfferService.findAll() != null){
            return ResponseEntity.ok(jobOfferService.findAll());
        }else
            return ResponseEntity.status(400).body("No job offers found!!");
    }

    @GetMapping("jobOffers")
    public ResponseEntity<Object> getAcceptedJobOffers(){
        if(jobOfferService.acceptedJobOffers() != null){
            return ResponseEntity.ok(jobOfferService.acceptedJobOffers());
        }else
            return ResponseEntity.status(400).body("No job offers found!!");
    }
    @GetMapping("agent/pendingJobOffers")
    public ResponseEntity<Object> getPendingJobOffers(){
        if(jobOfferService.pendingJobOffers() != null){
            return ResponseEntity.ok(jobOfferService.pendingJobOffers());
        }else
            return ResponseEntity.status(400).body("No job offers found!!");
    }

    @GetMapping("jobOffer/{id}")
    public ResponseEntity<Object> getAcceptedJobOfferById(@PathVariable int id){
        if(jobOfferService.acceptedJobOfferById(id) != null){
            return ResponseEntity.ok(jobOfferService.acceptedJobOfferById(id));
        }else
            return ResponseEntity.status(400).body("No job offer found!!");
    }

    @GetMapping("agent/jobOffer/{id}")
    public ResponseEntity<Object> getJobOfferById(@PathVariable int id){
        if(jobOfferService.jobOfferById(id) != null){
            return ResponseEntity.ok(jobOfferService.jobOfferById(id));
        }else
            return ResponseEntity.status(400).body("No job offer found!!");
    }

}
