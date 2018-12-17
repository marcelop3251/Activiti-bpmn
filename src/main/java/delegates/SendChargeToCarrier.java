package delegates;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class SendChargeToCarrier implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Processando pedido com execution: Id: " + execution.getId());	
	}

}
