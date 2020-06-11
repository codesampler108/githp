package in.rk.learn.web.java.rest.interceptor.out;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

public class WriteInterceptor extends AbstractPhaseInterceptor<Message> {

	public WriteInterceptor() {
		super(Phase.WRITE);
		System.out.println(this.getClass().getName() +" created");
	}

	@Override
	public void handleMessage(Message message) throws Fault {
		System.out.println("App Interceptor:" + this.getClass().getName());
	}

}
