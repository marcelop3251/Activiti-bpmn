package rest
;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.ActivitiRepositoryService;
import service.ActivitiRumtimeService;

@Path("/process")
public class ProcessActiviti {
	
	@Inject
	private ActivitiRepositoryService activitService;

	private static Logger log = LoggerFactory.getLogger(ProcessActiviti.class);

	
	@POST
	@Path("/{fluxoBpmn}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deployment(@PathParam("fluxoBpmn") String fluxoBpmn){		
		return Response.ok(activitService.deploymentProcess(fluxoBpmn)).build();
		
	}
	
	@DELETE
	public Response deleteDeploymentsAndData() {
		activitService.deleteDeploymentProcess();
		return Response.ok().build();
	}

}
