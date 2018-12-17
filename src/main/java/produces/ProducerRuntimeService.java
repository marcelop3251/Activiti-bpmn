package produces;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;

public class ProducerRuntimeService {
	
	@Inject
	private ProcessEngine processEngine;
	
	@Produces
	public RuntimeService createRuntime() {
		return processEngine.getRuntimeService();
	}
	

}
