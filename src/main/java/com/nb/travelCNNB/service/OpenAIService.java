package com.nb.travelCNNB.service;

import com.nb.travelCNNB.dto.ItineraryRequest;
import com.nb.travelCNNB.dto.PromptRequest;

import java.util.List;

public interface OpenAIService {
	String getItinerary(ItineraryRequest request);
}
