package com.MyRH.MyRH.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RegisterRequest {

    private String userName;
    private String email;
    private String password;
    private String address;
    private String companyName;
    private String phoneNum;
    private String imageUrl;
    private int verCode;

}
