package in.rk.learn.web.java.rest.interceptor.out;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.Context;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.jaxrs.ext.MessageContext;
import org.apache.cxf.jaxrs.utils.JAXRSUtils;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.springframework.stereotype.Component;

@Component
public class SetupInterceptor extends AbstractPhaseInterceptor<Message> {
	
	public SetupInterceptor() {
		super(Phase.SETUP);
		System.out.println(this.getClass().getName() + " created");
	}

	@Override
	public void handleMessage(Message message) throws Fault {
		System.out.println("App Interceptor:" + this.getClass().getName());
		System.out.println("In this interceptor, alter the header for outgoing message\n");

		addNewGenericHeader(message);
		listHeaders(message);
		accessObjectsOfInterest(message);
	}

	private void accessObjectsOfInterest(Message message) {
		System.out.println("Content Formats:");
		Set<Class<?>> contentFormats = message.getContentFormats();
		contentFormats.forEach(x -> System.out.println(x));
		
		Message currentMessage = PhaseInterceptorChain.getCurrentMessage();
		System.out.println("outgoing message:"+currentMessage);
		
		MessageContext jaxrsContext = JAXRSUtils.createContextValue(JAXRSUtils.getCurrentMessage(), null, MessageContext.class);
		System.out.println("jaxrsContext hash:"+jaxrsContext.hashCode());
		Object object = jaxrsContext.get("RandomKeyForLaterUse");
		System.out.println(object);
	}

	private void addNewGenericHeader(Message message) {
		String apidescription = "This API is unsupported";
		Map<String, List<String>> protocolHeaders = (Map<String, List<String>>) message.get(Message.PROTOCOL_HEADERS);
		if (null == protocolHeaders) {
			protocolHeaders = new HashMap<>();
			message.put(Message.PROTOCOL_HEADERS, protocolHeaders);
		}
		protocolHeaders.put("apiUsage", Arrays.asList(apidescription));
	}

	private void listHeaders(Message message) {

		Map<String, List<String>> protocolHeaders = (Map<String, List<String>>) message.get(Message.PROTOCOL_HEADERS);
		for (String header : protocolHeaders.keySet()) {
			System.out.println("header:" + header + ":" + Arrays.toString(protocolHeaders.get(header).toArray()));
		}

	}

}
