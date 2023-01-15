package com.MyRH.MyRH.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
//@Getter
//@Setter
@Entity
public class ResHuman {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable=false)
    private String userName;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false)
    private String address;

    @Column(nullable=false)
    private String companyName;

    @Column(nullable=false)
    private String phoneNum;

    @Column
    private String imageUrl;

    @OneToMany(mappedBy="rh")
    private List<JobOffer> jobOffers;

    public ResHuman() {
    }

    public ResHuman(String userName, String email, String password, String address, String companyName, String phoneNum, String imageUrl) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.companyName = companyName;
        this.phoneNum = phoneNum;
        this.imageUrl = imageUrl;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
