package rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.activiti.engine.runtime.ProcessInstance;

import service.ActivitiRumtimeService;

@Path("/runtime")
public class RuntimeActiviti {
	
	
	@Inject
	private ActivitiRumtimeService activitiService;
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createInstance(Map<String, String> process) throws URISyntaxException {		
		return Response
				.created(
						new URI(activitiService.startProcess(process.get("process")).getId())
						)
				.build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response fetchInstance(@PathParam("id") String id) {
		return Response.ok(activitiService.fetchInstance(id)).build();
	}
	
	@POST
	@Path("/task/{callbackTask}/subprocess/{subProcess}/processId/{processInstanceId}/signal")
	public Response signal(@PathParam("callbackTask") String callbackTask, @PathParam("subProcess") String subProcess,
			@PathParam("processInstanceId") String processInstanceId, Map<String,Object> processVariables) {
		
		if(processVariables.isEmpty()) {
			activitiService.resumeTaskWait(callbackTask,subProcess,processInstanceId);			
		}else {
			activitiService.resumeTaskWaitWithVariables(callbackTask, subProcess, processInstanceId, processVariables);
		}
		
		return Response.accepted().build();
	}

}
