package com.qa.classroom.persistence.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Classroom {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long classroomID;
	private String trainerName;
	
	@OneToMany
	@JoinColumn(name = "classroomID")
	private List<Trainee> trainees;

	public Classroom() {
	
	}
	
	public Classroom(String trainerName, List<Trainee> trainees) {
		this.trainerName = trainerName;
		this.trainees = trainees;
	}
	
	public Long getClassroomID() {
		return classroomID;
	}

	public void setClassroomID(Long classroomID) {
		this.classroomID = classroomID;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public List<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}
}
