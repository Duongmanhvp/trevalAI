package com.nb.travelCNNB.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UnsplashTemplateConfig {
	
	@Bean
	@Qualifier("unsplashRestTemplate")
	public RestTemplate unsplashRestTemplate() {
		return new RestTemplate();
	}
}
