package com.cv.cvintelligencemcpserver.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


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

    @Lob
    private String skillsJson;

    @Lob
    private String experienceJson;

    @Lob
    private String educationJson;

    @Lob
    private String technicalJson;

    @Lob
    private String refereesJson;

    @Lob
    private String rawCvJson;

    private String github;

    private String linkedin;

    private String summary;

}
