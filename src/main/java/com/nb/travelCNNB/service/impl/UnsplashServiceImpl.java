package com.nb.travelCNNB.service.impl;

import com.nb.travelCNNB.dto.*;
import com.nb.travelCNNB.service.OpenAIService;
import com.nb.travelCNNB.service.UnsplashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class UnsplashServiceImpl implements UnsplashService {
	
	
	@Qualifier("unsplashRestTemplate")
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${unsplash.api.url}")
	private String apiUrl;
	
	@Value("${unsplash.api.key}")
	private String apiKey;
	
	
	@Override
	public Object getPhotos(UnsplashRequest request) {
		String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
				.queryParam("query", request.getLocation())
				.queryParam("client_id", apiKey)
				.queryParam("per_page", request.getPerPage())
				.toUriString();
		
//		return restTemplate.getForObject(url, Object.class);
		
		PhotoResponse response = restTemplate.getForObject(url, PhotoResponse.class);

		assert response != null;

		return response.getResults().getFirst().getUrls();
	}
}
