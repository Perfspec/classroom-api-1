package com.qa.classroom.service;

public interface ClassroomService {

	String getAllClassrooms();
	
	String createClassroom(String classroom);
	
	String deleteClassroom(Long id);
	
	String getClassroom(Long id);
	
	String updateTrainer(String trainer, Long id);
	
	String updateTrainee(String trainee, Long id);

	String createTrainee(String trainee, Long id);

	String moveTrainee(String classRoomID, Long traineeID);
}
