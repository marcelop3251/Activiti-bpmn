package rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.ManagementActivitiService;

@Path("/boundaryTime")
public class BoundaryTimerRest {
	
	@Inject
	private ManagementActivitiService activitiService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{jobId}")
	public Response fetchHistory(@PathParam("jobId") String jobId) {
		activitiService.resumeJob(jobId);
		return Response.ok().build();
	}

}
