package service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;

@Named
public class ActivitiRepositoryService {


	@Inject
	private RepositoryService repositoryService;
	
	
	public Deployment deploymentProcess(String fluxoBpmn) {		
		Deployment deploy = repositoryService.createDeployment().addClasspathResource("diagrams/".concat(fluxoBpmn)).deploy();
		return deploy;	
		
	}

	public void deleteDeploymentProcess() {
		List<Deployment> list = repositoryService.createDeploymentQuery().list();		
		list.forEach(e -> {
			repositoryService.deleteDeployment(e.getId(), true);
		});
		
	}


	
}
