package com.MyRH.MyRH.Controller;


import com.MyRH.MyRH.Entities.JobOffer;
import com.MyRH.MyRH.Helpers.SendMail;
import com.MyRH.MyRH.Services.JobOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("agent")
@RequiredArgsConstructor
public class AgentController {

    private final JobOfferService jobOfferService;
    private final SendMail sendMail;


    @GetMapping("jobOffers")
    public ResponseEntity<List> getAll(){
        return ResponseEntity.ok(jobOfferService.findAll());
    }

    @GetMapping("accept/{jobOfferId}")
    public ResponseEntity<String> acceptJobOffer(@PathVariable String jobOfferId){
        JobOffer jobOffer = jobOfferService.findById(Integer.valueOf(jobOfferId));
        if(jobOffer != null){
            if(!jobOffer.isStatus()){
                jobOfferService.acceptJobOffer(Integer.valueOf(jobOfferId));
                System.out.println("email sent");
                sendMail.sendVerificationCode("benjarmoun123@gmail.com", "Job offer confirmed", "Your job offer: "+jobOffer.getTitle()+" has been posted.");

//                send email after confirmation
                return ResponseEntity.ok("Job offer has been accepted successfully.");
            }
        }
        return ResponseEntity.status(400).body("Failed to accept this job offer, try again!");
    }

    @GetMapping("requests")
    public ResponseEntity<List> getAllPendingJobOffers(){
        return ResponseEntity.ok(jobOfferService.findAll()
                .stream()
                .filter(JO -> (!JO.isStatus()))
                .collect(Collectors.toList()));
    }





}
