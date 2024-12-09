package com.nb.travelCNNB.controller;

import com.nb.travelCNNB.dto.ItineraryRequest;
import com.nb.travelCNNB.dto.PromptRequest;
import com.nb.travelCNNB.dto.TravelRecommendationRequest;
import com.nb.travelCNNB.dto.TravelRecommendationResponse;
import com.nb.travelCNNB.service.OpenAIService;
import com.nb.travelCNNB.service.TourismService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tourism")
@FieldDefaults(level = AccessLevel.PRIVATE)
//@RequiredArgsConstructor
public class TourismController {
	@Autowired
	private TourismService travelRecommendationService;
	
	@Autowired
	private OpenAIService openAIService;
	
	@PostMapping("/predict")
	public TravelRecommendationResponse predictDestination(@RequestBody TravelRecommendationRequest request) {
		return travelRecommendationService.predictDestination(request);
	}
	
	@PostMapping("/itinerary")
	public String getItinerary(@RequestBody ItineraryRequest request) {
		return openAIService.getItinerary(request);
	}
}
	
	

