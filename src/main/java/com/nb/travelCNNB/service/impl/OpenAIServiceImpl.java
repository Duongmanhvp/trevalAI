package com.nb.travelCNNB.service.impl;

import com.nb.travelCNNB.dto.ChatResponse;
import com.nb.travelCNNB.dto.ItineraryRequest;
import com.nb.travelCNNB.dto.Message;
import com.nb.travelCNNB.dto.PromptRequest;
import com.nb.travelCNNB.service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class OpenAIServiceImpl implements OpenAIService {
	
	
	@Qualifier("openaiRestTemplate")
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${openai.api.url}")
	private String apiUrl;
	
	@Value("${openai.model}")
	private String model;
	
	
	@Override
	public String getItinerary(ItineraryRequest request) {
		
		PromptRequest promptRequest = new PromptRequest();
		
		promptRequest.setModel(model);
		
		
		StringBuilder prompt = new StringBuilder();
		
		prompt.append("Hãy xây dựng lịch trình cho chuyến đi đến ").append(request.getLocation()).append("trong thời gian ").append(request.getDays()).append(" ngày. ");
		
		prompt.append("Chuyến đi cùng với ").append(request.getWith()).append(". ");
		
		prompt.append("Chuyến đi này sẽ thuộc loại: ").append(request.getTravelType()).append(".");
		
		prompt.append("Ngân sách cho chuyến đi sẽ khoảng ").append(request.getBudget()).append("$.");
		
		prompt.append("Hãy lên lịch trình chi tiết.");
		
		promptRequest.setMessages(List.of(new Message("user",prompt.toString())));
		
		ChatResponse response = restTemplate.postForObject(apiUrl, promptRequest, ChatResponse.class);
		
		assert response != null;
		
		return response.getChoices().getFirst().getMessage().getContent();
	}
}
