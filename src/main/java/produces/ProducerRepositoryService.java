package produces;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;


public class ProducerRepositoryService {
	
	@Inject
	private ProcessEngine processEngine;
	
	@Produces
	public RepositoryService createRepository() {
		return processEngine.getRepositoryService();
	}

}
