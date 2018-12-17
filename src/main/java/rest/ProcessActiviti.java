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

	
	//private static void startProcesss(){
		//ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//		BpmnModel bpmnModel = repositoryService.getBpmnModel("myProcess:2:10004");
//		ObjectMapper object = new ObjectMapper();
//		System.out.println(object.writeValueAsString(bpmnModel));
		
		
//		  IdentityService identityService = processEngine.getIdentityService();
//		  User bbpm = identityService.newUser("bbpm");
//		  identityService.saveUser(bbpm);
//		  
//		  Group group = identityService.newGroup("RegistroDeBoleto");
//		  group.setName("Boleto");
//		  identityService.saveGroup(group);
//		 
//		 for(HistoricProcessInstance l : list) {
//			 System.out.println(l.getEndActivityId());
//		 }
//		TaskService taskService = processEngine.getTaskService();
//		List<Task> tasks = taskService.createTaskQuery().taskDefinitionKey(processInstance.getProcessDefinitionKey()).list();
//		
//		Task task = taskService.createTaskQuery().singleResult();
//		
//		taskService.complete(task.getId());
		
//		for(Task task : tasks) {
//			System.out.println("Task available " + task.getName());
//			taskService.complete(task.getId());
//		}
		
		
		
//	}
	


}
