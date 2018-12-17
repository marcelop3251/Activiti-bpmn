package produces;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;

public class ProducerManagementService {
	
	@Inject
	private ProcessEngine processEngine;
	
	@Produces
	public ManagementService createHistory() {
		return processEngine.getManagementService();
	}

}
