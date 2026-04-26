package com.cv.cvintelligencemcpserver.service;


import com.cv.cvintelligencemcpserver.entity.*;
import com.cv.cvintelligencemcpserver.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;

    @Tool(name = "saveCandidate",description = "Save candidate CV data into the system including name, email, phone, skills, education, and experience.")
    public String saveUserProfileData(
            @ToolParam String name,
            @ToolParam String email,
            @ToolParam String phone,
            @ToolParam String location,
            @ToolParam List<String> skills,
            @ToolParam List<EducationEntity> education,
            @ToolParam List<ExperienceEntity> experience,
            @ToolParam List<RefereesEntity> referees,
            @ToolParam List<TechnicalEntity> technical,
            @ToolParam String github,
            @ToolParam String linkedin
    ){

        CandidateEntity candidate = new CandidateEntity();

        candidate.setName(name);
        candidate.setEmail(email);
        candidate.setPhone(phone);
        candidate.setLocation(location);
        candidate.setSkills(skills);
        candidate.setReferees(referees);
        candidate.setTechnical(technical);
        candidate.setEducation(education);
        candidate.setExperiences(experience);
        candidate.setGithub(github);
        candidate.setLinkedin(linkedin);

        candidateRepository.save(candidate);

        return "Candidate saved successfully: " + name;

    }





}
