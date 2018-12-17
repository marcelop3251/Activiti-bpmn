package service;

import javax.inject.Inject;

import org.activiti.engine.ManagementService;

public class ManagementActivitiService {
	
	
	@Inject
	private ManagementService managementeService;
	
	
	public void resumeJob(String jobId) {
		managementeService.executeJob(jobId);
	}

}
