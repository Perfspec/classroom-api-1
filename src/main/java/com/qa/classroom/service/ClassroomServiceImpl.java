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

	public String updateTrainer(String trainer, Long id) {
		return repo.updateTrainer(trainer, id);
	}
	
	public String moveTrainee(String classroomID, Long traineeID) {
		return repo.moveTrainee(classroomID, traineeID);
	}
	
	public String updateTrainee(String trainee, Long id) {
		return repo.updateTrainee(trainee, id);
	}
	
	public String createTrainee(String trainee, Long id) {
		return repo.createTrainee(trainee, id);
	}

}
