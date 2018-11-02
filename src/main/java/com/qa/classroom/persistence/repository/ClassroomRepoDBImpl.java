package com.qa.classroom.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.classroom.persistence.domain.Classroom;
import com.qa.classroom.persistence.domain.Trainee;
import com.qa.classroom.utils.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ClassroomRepoDBImpl implements ClassroomRepo {


	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	JSONUtil util;
	
	public String getAllClassrooms() {
		Query query = em.createQuery("SELECT c FROM Classroom c");
		Collection<Classroom> classroom = (Collection<Classroom>) query.getResultList();
		return util.getJSONfromObject(classroom);
	}
	
	@Transactional(REQUIRED)
	public String createClassroom(String classroom) {
		Classroom classroomObj = util.getObjectfromJSON(classroom, Classroom.class);
		em.persist(classroomObj);
		return "{\"message\": \"classroom Created\"}";
	}
	
	@Transactional(REQUIRED)
	public String createTrainee(String trainee, Long id) {
		Trainee traineeObj = util.getObjectfromJSON(trainee, Trainee.class);
		Classroom classroom = em.find(Classroom.class, id);
		em.persist(traineeObj);
		classroom.getTrainees().add(traineeObj);
		return "{\"message\": \"trainee Created\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteClassroom(Long id) {
		Classroom classroom = em.find(Classroom.class, id);
		if (classroom != null) {
			em.remove(classroom);
		}
		return "{\"message\": \"classroom Successfully Deleted\"}";
	}
	
	public String getClassroom(Long id) {
		return util.getJSONfromObject(em.find(Classroom.class, id));
	}
	
	@Transactional(REQUIRED)
	public String updateTrainer(String classroom, Long id) {
		Classroom classroomObj = util.getObjectfromJSON(classroom, Classroom.class);
		Classroom oldClassroom = em.find(Classroom.class, id);
		
		oldClassroom.setTrainerName(classroomObj.getTrainerName());
		
		return "{\"message\": \"classroom sucessfully updated\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateTrainee(String trainee, Long id) {
		Trainee traineeObj = util.getObjectfromJSON(trainee, Trainee.class);
		Trainee oldTrainee = em.find(Trainee.class, id);
		
		oldTrainee.setTraineeName(traineeObj.getTraineeName());
		
		return "{\"message\": \"classroom sucessfully updated\"}";
	}
	
	@Transactional(REQUIRED)
	public String moveTrainee(String classroomID, Long traineeID) {
		Long id = util.getObjectfromJSON(classroomID, Classroom.class).getClassroomID();
		Classroom classroom = em.find(Classroom.class, id);
		Trainee trainee = em.find(Trainee.class, traineeID);
		
		Query query = em.createQuery("SELECT c FROM Classroom c");
		Collection<Classroom> classroomList = (Collection<Classroom>) query.getResultList();
		
		for(Classroom c: classroomList) {
			if(c.getClassroomID() == classroom.getClassroomID()) {
				c.getTrainees().remove(trainee);
			}
		}
		
		classroom.getTrainees().add(trainee);
		
		return "{\"message\": \"trainee sucessfully moved\"}";
	}

	public void setManager(EntityManager manager) {
		this.em = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
		
	}
}