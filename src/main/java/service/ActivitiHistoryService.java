package service;

import javax.inject.Inject;
import javax.ws.rs.GET;

import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.activiti.engine.history.HistoricProcessInstanceQuery;

public class ActivitiHistoryService {
	
	
	@Inject
	private HistoryService activitService;
	

	public HistoricProcessInstanceQuery fetchHistory(String activityInstanceId) {
		return activitService.createHistoricProcessInstanceQuery().deploymentId(activityInstanceId);	
	}
	

}
