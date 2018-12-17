package produces;

import javax.enterprise.inject.Produces;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;

public class ProducerProcessEngine {
	
	@Produces
	public ProcessEngine createProcess() {
		return ProcessEngines.getDefaultProcessEngine();
	}

}
