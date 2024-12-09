package com.nb.travelCNNB.dto;

import java.util.ArrayList;
import java.util.List;

public class PromptRequest {
	String model;
	
	List<Message> messages;
	
	public PromptRequest(String model, String prompt) {
		this.model = model;
		this.messages = new ArrayList<>();
		this.messages.add(new Message("user", prompt));
	}
	
	public PromptRequest() {
	
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public List<Message> getMessages() {
		return messages;
	}
	
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
}
