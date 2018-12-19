package rest;

import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import service.ActivitiTaskService;

@Path("/task")
public class TaskActiviti {
	
	@Inject
	private ActivitiTaskService service;
	
	@POST
	@Path("/{userTaskId}/{processInstanceId}")
	public Response userTaskProcess(@PathParam("userTaskId") String taskDefinitionKey,
			@PathParam("processInstanceId") String processInstanceId,
			Map<String,Object> variables) {
		
		if(variables.isEmpty()) {
			service.resumeTaskWithVariables(processInstanceId, taskDefinitionKey, variables);			
		}else {
			service.resumeTaskIdAndProcessInstance(processInstanceId, taskDefinitionKey);
		}
		return Response.ok().build();
		
	}
	
	@POST
	@Path("/{userTaskId}")
	public Response userTaskProcessId(@PathParam("userTaskId") String userTaskId) {
		service.resumeTask(userTaskId);
		return Response.ok().build();
		
	}
	
	
}