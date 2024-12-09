package com.nb.travelCNNB.service;

import com.nb.travelCNNB.dto.TravelRecommendationRequest;
import com.nb.travelCNNB.dto.TravelRecommendationResponse;
import weka.core.Instance;
import weka.core.Instances;

import java.io.IOException;

public interface TourismService {
	
	public TravelRecommendationResponse predictDestination(TravelRecommendationRequest request);
}
