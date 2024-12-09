package com.nb.travelCNNB.dto;

public class UnsplashRequest {
	
	private String location;
	
	private int perPage;
	
	public UnsplashRequest() {
	}
	
	public UnsplashRequest(String location, int perPage) {
		this.location = location;
		this.perPage = perPage;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public int getPerPage() {
		return perPage;
	}
	
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
}
