package com.nb.travelCNNB.dto;

public class TravelRecommendationRequest {
	
	private int age;
	private String with;
	private String budget;
	private String interest;
	private String model;
	
	// Getters and setters
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getWith() {
		return with;
	}
	
	public void setWith(String with) {
		this.with = with;
	}
	
	public String getBudget() {
		return budget;
	}
	
	public void setBudget(String budget) {
		this.budget = budget;
	}
	
	public String getInterest() {
		return interest;
	}
	
	public void setInterest(String interest) {
		this.interest = interest;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
}
