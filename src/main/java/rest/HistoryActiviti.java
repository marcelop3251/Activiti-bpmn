package rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import service.ActivitiHistoryService;

@Path("/history")
public class HistoryActiviti {

	@Inject
	private ActivitiHistoryService activitiService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response fetchHistory(@PathParam("id") String activityInstanceId) {
		return Response.ok(activitiService.fetchHistory(activityInstanceId)).build();
	}
}
