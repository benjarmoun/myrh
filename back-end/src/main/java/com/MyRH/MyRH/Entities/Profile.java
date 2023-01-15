package com.MyRH.MyRH.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
//@Getter
//@Setter
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable=false)
    private String name;

    @OneToMany(mappedBy="profileId")
    private List<JobOffer> jobOffers;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
