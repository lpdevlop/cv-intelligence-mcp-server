package com.cv.cvintelligencemcpserver.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class TechnicalEntity {

    private String primarySkill;

    private String secondarySkill;

    private String otherSkills;

    private Integer experienceYears;

    private String tools;

}
