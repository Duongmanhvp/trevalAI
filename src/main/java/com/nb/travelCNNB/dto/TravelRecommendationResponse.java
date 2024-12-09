package com.nb.travelCNNB.dto;

public class TravelRecommendationResponse {
	private String predictedDestination;
	
	public TravelRecommendationResponse(String predictedDestination) {
		this.predictedDestination = predictedDestination;
	}
	
	public String getPredictedDestination() {
		return predictedDestination;
	}
	
	public void setPredictedDestination(String predictedDestination) {
		this.predictedDestination = predictedDestination;
	}
	
}
