package com.qa.classroom.service;

import javax.inject.Inject;

import com.qa.classroom.persistence.repository.ClassroomRepo;

public class ClassroomServiceImpl implements ClassroomService {
	
	@Inject
	ClassroomRepo repo;

	public String getAllClassrooms() {
		return repo.getAllClassrooms();
	}

	public String createClassroom(String classroom) {
		return repo.createClassroom(classroom);
	}

	public String deleteClassroom(Long id) {
		return repo.deleteClassroom(id);
	}

	public String getClassroom(Long id) {
		return repo.getClassroom(id);
	}

	public String updateClassroom(String classroom, Long id) {
		return repo.updateClassroom(classroom, id);
	}
	
	public String createTrainee(String trainee, Long id) {
		return repo.createTrainee(trainee, id);
	}

}
