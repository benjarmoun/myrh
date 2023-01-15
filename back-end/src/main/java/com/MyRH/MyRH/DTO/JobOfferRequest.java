package com.MyRH.MyRH.DTO;

import com.MyRH.MyRH.Entities.Profile;
import lombok.Data;
@Data
public class JobOfferRequest {
    private String title;
    private String description;
    private int profileId;
    private String city;
    private String degree;
    private Double salary;
    private boolean status;

}
