package service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

public class ActivitiTaskService {

	@Inject
	private TaskService taskService;
	
	public void resumeTaskWithVariables(String processInstanceId, String taskDefinitionKey, Map<String,Object> variables) {
		Task task = getTask(processInstanceId, taskDefinitionKey);
		taskService.complete(task.getId(),variables);
	}
	
	public void resumeTaskIdAndProcessInstance(String processInstanceId, String taskDefinitionKey) {
		Task task = getTask(processInstanceId, taskDefinitionKey);
		taskService.complete(task.getId());
		
	}

	private Task getTask(String processInstanceId, String taskDefinitionKey) {
		return taskService.createTaskQuery().processInstanceId(processInstanceId).taskDefinitionKey(taskDefinitionKey).singleResult();
	}

	public void resumeTask(String userTaskId) {
		taskService.complete(userTaskId);
	}
}
