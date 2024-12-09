package com.nb.travelCNNB.service;

import com.nb.travelCNNB.dto.ItineraryRequest;
import com.nb.travelCNNB.dto.UnsplashRequest;

public interface UnsplashService {
	Object getPhotos(UnsplashRequest request);
}
