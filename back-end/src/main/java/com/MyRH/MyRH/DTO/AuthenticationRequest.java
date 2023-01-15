package com.MyRH.MyRH.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class AuthenticationRequest {

    private String email;
    private String password;

}
