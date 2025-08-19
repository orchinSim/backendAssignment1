package com.example.assessment_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assessment_service.feign.NotificationClient;
import com.example.assessment_service.model.Assessment;
import com.example.assessment_service.repository.AssessmentRepository;

@Service
public class AssessmentService {
	

    @Autowired
     AssessmentRepository assessmentRepository;

    @Autowired
    NotificationClient notificationClient;
    
    
    public Assessment submitAssessment(Assessment assessment) {
    	Assessment saved = assessmentRepository.save(assessment);
    	
    	String notificationMessage = "Assessment Submitted:" + assessment.getTitle() +","+assessment.getDescription();
    	notificationClient.sendNotification(notificationMessage);
    	
    	return saved;
    }

}
