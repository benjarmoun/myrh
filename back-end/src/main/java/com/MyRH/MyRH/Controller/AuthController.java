package com.MyRH.MyRH.Controller;


import com.MyRH.MyRH.Config.JwtUtils;
import com.MyRH.MyRH.DTO.AuthenticationRequest;
import com.MyRH.MyRH.Entities.ResHuman;
import com.MyRH.MyRH.Helpers.LoggedIn;
import com.MyRH.MyRH.Services.AgentService;
import com.MyRH.MyRH.Services.RhService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final AgentService agentService;
    private final RhService rhService;
    private final JwtUtils jwtUtils;
//    private final LoggedIn loggedIn;

    @PostMapping("agent")
    public ResponseEntity<String> agentAuthentication(
            @RequestBody AuthenticationRequest request
    ){

        setAuthenticationManager(request.getEmail(), request.getPassword());
        final UserDetails user = agentService.findByEmail(request.getEmail());
        if(user != null){
            return ResponseEntity.ok(jwtUtils.generateToken(user));
        }
        return ResponseEntity.status(400).body("Some error has occurred");
    }

    @PostMapping("rh")
    public ResponseEntity<Object> rhAuthentication(
            @RequestBody AuthenticationRequest request
    ){
        System.out.println("yess");
        setAuthenticationManager(request.getEmail(), request.getPassword());
        final UserDetails userRh = rhService.findByEmail(request.getEmail());
        if(userRh != null){
            LoggedIn loggedIn = new LoggedIn();
            ResHuman rh = rhService.findRhByEmail(request.getEmail());
            System.out.println("rh"+ rhService.findRhByEmail(request.getEmail()));
            loggedIn.setToken(jwtUtils.generateToken(userRh));
            loggedIn.setRh(rh);
            System.out.println("email "+ request.getEmail());
            System.out.println("rr"+ loggedIn);
            return ResponseEntity.ok(loggedIn);
        }
        return ResponseEntity.status(400).body(null);
    }

    public void setAuthenticationManager(String email, String password){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
    }

}
