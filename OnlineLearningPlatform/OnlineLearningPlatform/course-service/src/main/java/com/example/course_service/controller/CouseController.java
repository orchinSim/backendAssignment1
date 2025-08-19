package com.example.course_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course_service.dto.CourseWithTeacher;
import com.example.course_service.model.Course;
import com.example.course_service.service.CourseService;	
	

@RestController
@RequestMapping("/api/courses")
	public class CouseController {
	@Autowired
	CourseService courseService;


	@GetMapping
	public List<Course> getAllCourses() {
		return courseService.getAllCourses(); 
		}

	@GetMapping("/{id}")
	public Optional<Course> getCourseById(@PathVariable Long id) {
		return courseService.getCourseById(id); 
		}

	@PostMapping
	public Course createCourse(@RequestBody Course course) { 
		return courseService.createCourse(course); 
		}
	
	@GetMapping("/{id}/withteacher")
    public CourseWithTeacher getCourseWithTeacher(@PathVariable Long id) {
        return courseService.getCourseWithTeacher(id);
    }

	}

