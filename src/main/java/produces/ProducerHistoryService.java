package produces;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;

public class ProducerHistoryService {

	@Inject
	private ProcessEngine processEngine;
	
	@Produces
	public HistoryService createHistory() {
		return processEngine.getHistoryService();
	}
}
