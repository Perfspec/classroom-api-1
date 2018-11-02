package com.qa.classroom.persistence.repository;

public interface ClassroomRepo {

	String getAllClassrooms();
	
	String createClassroom(String classroom);
	
	String deleteClassroom(Long id);
	
	String getClassroom(Long id);
	
	String updateTrainer(String classroom, Long id);
	
	String updateTrainee(String trainee, Long id);

	String createTrainee(String trainee, Long id);
	
	String moveTrainee(String classroomID, Long traineeID);
}
