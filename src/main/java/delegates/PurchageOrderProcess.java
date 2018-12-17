package delegates;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class PurchageOrderProcess implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println(" Iniciando pedido com execution: Id:" + execution.getId());		
	}

}
