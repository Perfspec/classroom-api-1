package com.qa.classroom.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.classroom.service.ClassroomService;

@Path("/classroom")
public class ClassroomEndpoint {
	
	@Inject
	private ClassroomService service;

	@Path("/getAllClassrooms")
	@GET
	@Produces({ "application/json" })
	public String getAllClassrooms() {
		return service.getAllClassrooms();
	}
	
	@Path("/getClassroom/{id}")
	@GET
	@Produces({ "application/json" })
	public String getClassroom(@PathParam("id") Long id) {
		return service.getClassroom(id);
	}
	
	@Path("/createClassroom")
	@POST
	@Produces({ "application/json" })
	public String createClassroom(String classroom) {
		return service.createClassroom(classroom);
	}
	
	@Path("/deleteClassroom/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteClassroom(@PathParam("id") Long id) {
		return service.deleteClassroom(id);
	}
	
	@Path("/updateTrainer/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateTrainer(String trainer, @PathParam("id") Long id) {
		return service.updateTrainer(trainer, id);
	}
	
	@Path("/updateTrainee/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateTrainee(String trainee, @PathParam("id") Long id) {
		return service.updateTrainee(trainee, id);
	}
	
	@Path("/createTrainee/{id}")
	@POST
	@Produces({ "application/json" })
	public String createTrainee(String trainee, @PathParam("id") Long id) {
		return service.createTrainee(trainee, id);
	}
}