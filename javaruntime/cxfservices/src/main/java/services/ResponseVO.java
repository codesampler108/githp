package services;

import java.util.List;

public class ResponseVO {
    private List<String> messages;
    private String output;

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

    
}
