package com.MyRH.MyRH.Controller;

import com.MyRH.MyRH.DTO.JobOfferRequest;
import com.MyRH.MyRH.DTO.RegisterRequest;
import com.MyRH.MyRH.Entities.JobOffer;
import com.MyRH.MyRH.Entities.ResHuman;
import com.MyRH.MyRH.Helpers.SendMail;
import com.MyRH.MyRH.Services.JobOfferService;
import com.MyRH.MyRH.Services.RhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
@RestController
public class RhController {

    private final RhService rhService;
//    private final AuthenticatedUserInfo authUserInfo;
    private final SendMail sendMail;
    private ResHuman rh;
    private int codeVer;
    private LocalTime setTime;
    @Autowired
    public RhController(JobOfferService jobOfferService, RhService rhService, SendMail sendMail) {
        this.rhService = rhService;
        this.sendMail = sendMail;
    }

    @PostMapping("register")
    public ResponseEntity<String> register(
            @RequestBody RegisterRequest req
            ){
        rh = new ResHuman(
                req.getUserName(),
                req.getEmail(),
                req.getPassword(),
                req.getAddress(),
                req.getCompanyName(),
                req.getPhoneNum(),
                req.getImageUrl()
        );

        rh.setPassword(BCrypt.hashpw(rh.getPassword(), BCrypt.gensalt(10)));
        codeVer = generateVerifiedCode();
        System.out.println(codeVer);
        sendMail.sendVerificationCode("benjarmoun123@gmail.com", "Code verification", "Code: "+codeVer+" .");
        return ResponseEntity.ok("Code verification has been sent to you.");
    }

    @PostMapping("/code-verification")
    public ResponseEntity<String> verRegistration(
            @RequestBody RegisterRequest req){
        if((req.getVerCode() == codeVer) && (rh != null)){
            if(isCodeValid()){
                System.out.println("Valid code");
                if(rhService.save(rh) != null) {
                    rh = null;
                    return ResponseEntity.ok("Success registration");
                }
            }else{
                ResponseEntity.status(400).body("The code has expired");
            }
//
        }
        return ResponseEntity.status(400).body("Failed creation customer");
    }



//    @GetMapping("/resend-code")
//    public ResponseEntity<String> resendVerCode(){
//        sendMail.sendVerificationCode(rh.getEmail(), "Code verification", "Code: "+codeVer+" .");
//        setTime = LocalTime.now();
//        return ResponseEntity.ok("The code has been sent to you, check your email.");
//    }

//    @GetMapping("info")
//    public ResponseEntity<Customer> getCustomerInfo(HttpServletRequest req){
//        String email = authUserInfo.getEmail(req);
//        System.out.println(email);
//        return ResponseEntity.ok(cstService.getCustomerByEmail(email));
//    }

    public int generateVerifiedCode(){
        setTime = LocalTime.now();
        System.out.println(setTime);
        return (int)Math.floor(Math.random()*(99999-9999+1)+9999);
    }

    public boolean isCodeValid(){
        LocalTime now = LocalTime.now();
        return now.isBefore(setTime.plusMinutes(3));
    }
}
