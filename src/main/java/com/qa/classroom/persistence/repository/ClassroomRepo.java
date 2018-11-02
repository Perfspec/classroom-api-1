package com.qa.classroom.persistence.repository;

public interface ClassroomRepo {

	String getAllClassrooms();
	
	String createClassroom(String classroom);
	
	String deleteClassroom(Long id);
	
	String getClassroom(Long id);
	
	String updateClassroom(String classroom, Long id);
}
