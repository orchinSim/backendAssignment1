package com.example.classroom_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.classroom_service.model.Classroom;
import com.example.classroom_service.service.ClassroomService;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {
	
	 @Autowired
	    private ClassroomService classroomService;

	  @GetMapping
	    public List<Classroom> getAllClassrooms() {
	        return classroomService.getAllClassrooms();
	    }

	    @GetMapping("/{id}")
	    public Optional<Classroom> getClassroomById(@PathVariable Long id) {
	        return classroomService.getClassroomById(id);
	    }
	    
	    @PostMapping
	    public Classroom createClassroom(@RequestBody Classroom classroom) {
	        return classroomService.saveClassroom(classroom);
	    }

}
