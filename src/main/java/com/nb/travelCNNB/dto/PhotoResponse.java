package com.nb.travelCNNB.dto;

import java.util.List;

public class PhotoResponse {
	private List<Result> results;
	
	public PhotoResponse(List<Result> results) {
		this.results = results;
	}
	
	public PhotoResponse() {
	}
	
	public List<Result> getResults() {
		return results;
	}
	
	public void setResults(List<Result> results) {
		this.results = results;
	}
	
	public static class Result {
		private Object urls;
		
		public Result(Object urls) {
			this.urls = urls;
		}
		
		public Result() {
		}
		
		public Object getUrls() {
			return urls;
		}
		
		public void setUrls(Object urls) {
			this.urls = urls;
		}
	}
}
