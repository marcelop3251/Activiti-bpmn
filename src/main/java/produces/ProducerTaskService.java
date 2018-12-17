package produces;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;

public class ProducerTaskService {
	
	@Inject
	private ProcessEngine processEngine;

	@Produces
	public TaskService taskService() {
		return processEngine.getTaskService();
	}
}
