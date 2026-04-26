package com.cv.cvintelligencemcpserver;

import com.cv.cvintelligencemcpserver.service.CandidateService;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CvIntelligenceMcpServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CvIntelligenceMcpServerApplication.class, args);
    }

    @Bean
    public List<ToolCallback> shoppingCartToolCallback(CandidateService candidateService){
        return List.of(ToolCallbacks.from(candidateService));
    }}
