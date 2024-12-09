package com.nb.travelCNNB.dto;

import java.util.List;

public class ItineraryRequest {
	
	private  int days;
	
	private long budget;
	
	private String location;
	
	private String with;
	
	private List<String> travelType;
	
	public ItineraryRequest() {
	}
	
	public ItineraryRequest(int days, long budget, String location, String with, List<String> travelType) {
		this.days = days;
		this.budget = budget;
		this.location = location;
		this.with = with;
		this.travelType = travelType;
	}
	
	public int getDays() {
		return days;
	}
	
	public void setDays(int days) {
		this.days = days;
	}
	
	public long getBudget() {
		return budget;
	}
	
	public void setBudget(long budget) {
		this.budget = budget;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getWith() {
		return with;
	}
	
	public void setWith(String with) {
		this.with = with;
	}
	
	public List<String> getTravelType() {
		return travelType;
	}
	
	public void setTravelType(List<String> travelType) {
		this.travelType = travelType;
	}
}
