package service;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Event;

public class ActivitiRumtimeService {
	
	@Inject
	private RuntimeService runtimeService;
	
	public ProcessInstance startProcess(String myProcess) {
		
		return runtimeService.startProcessInstanceByKey(myProcess);		
	}

	public List<Event> fetchInstance(String id) {
		return runtimeService.getProcessInstanceEvents(id);
	}

	public void resumeTaskWait(String callbackTask, String subProcess, String processInstanceId) {
		Execution execution = getExecution(callbackTask, subProcess, processInstanceId);
		runtimeService.signal(execution.getId());
	}
	
	public void resumeTaskWaitWithVariables(String callbackTask, String subProcess, String processInstanceId, Map<String, Object> processVariables) {
		Execution execution = getExecution(callbackTask, subProcess, processInstanceId);
		runtimeService.signal(execution.getId(), processVariables);
	}

	private Execution getExecution(String callbackTask, String subProcess, String processInstanceId) {
		return runtimeService
				.createExecutionQuery()
				.processDefinitionKey(subProcess)
				.processInstanceId(processInstanceId)
				.activityId(callbackTask)
				.singleResult();
	}
}
