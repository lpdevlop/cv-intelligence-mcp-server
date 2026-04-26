package com.cv.cvintelligencemcpserver.entity;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class EducationEntity {


    private String degree;

    private String institution;

    private String fieldOfStudy;

    private LocalDate startDate;

    private LocalDate endDate;

    private String grade;

    private String description;
}
