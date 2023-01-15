package com.MyRH.MyRH.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class JobOffer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable=false)
    private String title;

    @Column(nullable=false)
    private String description;

    @ManyToOne
    @JoinColumn(name="profile_id")
    private Profile profileId;

    @Column(nullable=false)
    private String city;

    @Column(nullable=false)
    private String degree;

    @Column
    private Double salary;

    @Column(nullable=false)
    private boolean status;

    @ManyToOne
    @JoinColumn(name="rh_id")
    private ResHuman rh;

    public JobOffer() {
    }

    public JobOffer(String title, String description, Profile profileId, String city, String degree, Double salary, boolean status) {
        this.title = title;
        this.description = description;
        this.profileId = profileId;
        this.city = city;
        this.degree = degree;
        this.salary = salary;
        this.status = status;
    }

    public JobOffer(String title, String description, Profile profileId, String city, String degree, Double salary, boolean status, ResHuman rh) {
        this.title = title;
        this.description = description;
        this.profileId = profileId;
        this.city = city;
        this.degree = degree;
        this.salary = salary;
        this.status = status;
        this.rh = rh;
    }
    // Getters and setters for each attribute
    // Constructor(s)
    // Other methods, if desired
}
