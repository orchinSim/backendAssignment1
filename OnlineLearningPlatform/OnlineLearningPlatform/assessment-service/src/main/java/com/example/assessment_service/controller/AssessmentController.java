package com.example.assessment_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assessment_service.model.Assessment;
import com.example.assessment_service.service.AssessmentService;

@RestController
@RequestMapping("/api/assessments")
public class AssessmentController {
	
	@Autowired
	AssessmentService assessmentService;
	
	@PostMapping
	 public Assessment submitAssignment(@RequestBody Assessment assignment) {
	 return assessmentService.submitAssessment(assignment);
	 }
}
