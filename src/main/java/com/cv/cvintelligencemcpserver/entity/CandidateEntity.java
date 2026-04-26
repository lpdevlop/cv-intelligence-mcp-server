package com.cv.cvintelligencemcpserver.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "candidate")
@Getter
@Setter
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String location;

    private String country;


    @ElementCollection
    @CollectionTable(name = "candidate_skills", joinColumns = @JoinColumn(name = "candidate_id"))
    private List<String> skills;

    @ElementCollection
    @CollectionTable(name = "candidate_education", joinColumns = @JoinColumn(name = "candidate_id"))
    private List<EducationEntity> education;

    @ElementCollection
    @CollectionTable(name = "candidate_experience", joinColumns = @JoinColumn(name = "candidate_id"))
    private List<ExperienceEntity> experiences;

    @ElementCollection
    @CollectionTable(name = "candidate_referees", joinColumns = @JoinColumn(name = "candidate_id"))
    private List<RefereesEntity> referees;

    @ElementCollection
    @CollectionTable(name = "candidate_technical", joinColumns = @JoinColumn(name = "candidate_id"))
    private List<TechnicalEntity> technical;


    private String github;

    private String linkedin;

    private String summary;


}
