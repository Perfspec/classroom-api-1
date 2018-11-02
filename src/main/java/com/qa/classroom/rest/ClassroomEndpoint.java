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
	public String getAllclassrooms() {
		return service.getAllClassrooms();
	}
	
	@Path("/getClassroom/{id}")
	@GET
	@Produces({ "application/json" })
	public String findAnclassroom(@PathParam("id") Long id) {
		return service.getClassroom(id);
	}
	
	@Path("/createClassroom")
	@POST
	@Produces({ "application/json" })
	public String createclassroom(String classroom) {
		return service.createClassroom(classroom);
	}
	
	@Path("/deleteClassroom/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteclassroom(@PathParam("id") Long id) {
		return service.deleteClassroom(id);
	}
	
	@Path("/updateClassroom/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateclassroom(String classroom, @PathParam("id") Long id) {
		return service.updateClassroom(classroom, id);
	}
}