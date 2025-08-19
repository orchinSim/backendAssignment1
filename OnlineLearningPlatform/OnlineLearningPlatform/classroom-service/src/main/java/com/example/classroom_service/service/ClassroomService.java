package com.example.classroom_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.classroom_service.model.Classroom;
import com.example.classroom_service.repository.ClassroomRepository;

@Service
public class ClassroomService {
	
	
	 @Autowired
	    private ClassroomRepository classroomRepository;
	 
	 public List<Classroom> getAllClassrooms() {
	        return classroomRepository.findAll();
	    }

	    public Optional<Classroom> getClassroomById(Long id) {
	        return classroomRepository.findById(id);
	    }

	    public Classroom saveClassroom(Classroom classroom) {
	        return classroomRepository.save(classroom);
	    }


}
