package config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.jackson.JacksonFeature;

import rest.BoundaryTimerRest;
import rest.HistoryActiviti;
import rest.ProcessActiviti;
import rest.RuntimeActiviti;
import rest.TaskActiviti;

@ApplicationPath("/")
public class PathApplication extends Application {

	
	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> clazz = new HashSet<Class<?>>();
		clazz.add(ProcessActiviti.class);
		clazz.add(HistoryActiviti.class);
		clazz.add(RuntimeActiviti.class);
		clazz.add(TaskActiviti.class);
		clazz.add(JacksonFeature.class);
		clazz.add(BoundaryTimerRest.class);
		return clazz;
	}
	
	
}
