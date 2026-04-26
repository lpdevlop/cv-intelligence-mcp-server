package com.cv.cvintelligencemcpserver.service;


import com.cv.cvintelligencemcpserver.entity.*;
import com.cv.cvintelligencemcpserver.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Tool(
            name = "saveCandidate",
            description = "Save candidate CV data into the system as JSON format"
    )
    public String saveUserProfileData(
            @ToolParam String name,
            @ToolParam String email,
            @ToolParam String phone,
            @ToolParam String location,
            @ToolParam List<String> skills,
            @ToolParam Object experience,
            @ToolParam Object education,
            @ToolParam Object referees,
            @ToolParam Object technical,
            @ToolParam String github,
            @ToolParam String linkedin
    ) {
        try {

            CandidateEntity candidate = new CandidateEntity();

            candidate.setName(name);
            candidate.setEmail(email);
            candidate.setPhone(phone);
            candidate.setLocation(location);
            candidate.setGithub(github);
            candidate.setLinkedin(linkedin);

            candidate.setSkillsJson(objectMapper.writeValueAsString(skills));
            candidate.setExperienceJson(objectMapper.writeValueAsString(experience));
            candidate.setEducationJson(objectMapper.writeValueAsString(education));
            candidate.setTechnicalJson(objectMapper.writeValueAsString(technical));
            candidate.setRefereesJson(objectMapper.writeValueAsString(referees));

            Map<String, Object> raw = new HashMap<>();
            raw.put("name", name);
            raw.put("email", email);
            raw.put("phone", phone);
            raw.put("location", location);
            raw.put("skills", skills);
            raw.put("experience", experience);
            raw.put("education", education);
            raw.put("technical", technical);
            raw.put("referees", referees);
            raw.put("github", github);
            raw.put("linkedin", linkedin);

            candidate.setRawCvJson(objectMapper.writeValueAsString(raw));

            candidateRepository.save(candidate);

            return "Candidate saved successfully: " + name;

        } catch (Exception e) {
            return "Error saving candidate: " + e.getMessage();
        }
    }

    @Tool(
            name = "searchCandidate",
            description = "Search candidate profiles using different filters like name,email,phone,skills, location,education, experience,referees,technical,github,linkedin"
    )
    public List<CandidateEntity> getCandidateData(
            @ToolParam CandidateEntity candidateEntity
    ) {
        Example<CandidateEntity> candidateEntityExample=Example.of(candidateEntity);
        return candidateRepository.findAll(candidateEntityExample);
    }

}
