package com.qa.classroom.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long traineeID;
	
	private String traineeName;
	
	private Long classroomID;
	
	public Trainee() {
		
	}
	
	public Trainee(String traineeName) {
		this.traineeName = traineeName;
	}
	
	public Long getTraineeID() {
		return traineeID;
	}
	public void setTraineeID(Long traineeID) {
		this.traineeID = traineeID;
	}
	
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public Long getClassroomID() {
		return classroomID;
	}

	public void setClassroomID(Long classroomID) {
		this.classroomID = classroomID;
	}
}
