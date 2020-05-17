package controller.model;

import java.util.List;

public class BusinessObjectResponse {
    private List<String> msgs;
    private String serviceMessage;
	public List<String> getMsgs() {
		return msgs;
	}
	public void setMsgs(List<String> msgs) {
		this.msgs = msgs;
	}
	public String getServiceMessage() {
		return serviceMessage;
	}
	public void setServiceMessage(String serviceMessage) {
		this.serviceMessage = serviceMessage;
	}
}
