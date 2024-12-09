package com.nb.travelCNNB.controller;

import com.nb.travelCNNB.dto.*;
import com.nb.travelCNNB.service.OpenAIService;
import com.nb.travelCNNB.service.TourismService;
import com.nb.travelCNNB.service.UnsplashService;
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
	
	@Autowired
	private UnsplashService unsplashService;
	
	@PostMapping("/predict")
	public TravelRecommendationResponse predictDestination(@RequestBody TravelRecommendationRequest request) {
		return travelRecommendationService.predictDestination(request);
	}
	
	@PostMapping("/itinerary")
	public String getItinerary(@RequestBody ItineraryRequest request) {
		return openAIService.getItinerary(request);
	}
	
	@GetMapping("/photos")
	public Object getPhotos(@RequestParam String location,
	                        @RequestParam(required = false, defaultValue = "1") int perPage) {
		UnsplashRequest request = new UnsplashRequest(location, perPage);
		return unsplashService.getPhotos(request);
	}
}
	
	

