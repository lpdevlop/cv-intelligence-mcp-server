package com.cv.cvintelligencemcpserver.entity;


import jakarta.persistence.*;

@Embeddable
public class ExperienceEntity {


    private String company;
    private String role;
    private int years;

    private String startDate;
    private String endDate;

    private String techStack;

    private String workLocation;

    private String additionalInformation;


}
