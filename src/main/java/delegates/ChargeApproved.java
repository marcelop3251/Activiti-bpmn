package delegates;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class ChargeApproved implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Cobrança aprovada para execuacao: Id: " + execution.getId());		
	}

}
