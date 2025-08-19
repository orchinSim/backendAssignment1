package com.example.course_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.course_service.config.UserServiceClient;
import com.example.course_service.dto.CourseWithTeacher;
import com.example.course_service.dto.UserDTO;
import com.example.course_service.model.Course;
import com.example.course_service.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;
	
	 @Autowired
	    private UserServiceClient userServiceClient;
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	
	private final String CLASS_CREATED_TOPIC = "class-created";
	
	public List<Course> getAllCourses(){
		return  courseRepository.findAll();
	}
	
	 public Optional<Course> getCourseById(Long id) { 
		 return courseRepository.findById(id);
	}
	 
	 public Course createCourse(Course course) {
		 Course saved = courseRepository.save(course);
		 kafkaTemplate.send(CLASS_CREATED_TOPIC,
	                "Class Created: " + saved.getId() + "," + saved.getName() + "," + saved.getTeacherId());
		 return saved;
		 
	 }
	 
	 public CourseWithTeacher getCourseWithTeacher(Long courseId) {
	        Course course = courseRepository.findById(courseId).orElseThrow();
	        UserDTO teacher = userServiceClient.getUserById(course.getTeacherId());

	        CourseWithTeacher result = new CourseWithTeacher();
	        result.setId(course.getId());
	        result.setName(course.getName());
	        result.setDescription(course.getDescription());
	        result.setTeacher(teacher);
	        return result;
	    }
	 
	
}
