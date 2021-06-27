package com.learn.searchApi.client;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SearchClient {
	
	private final String GITHUB_SEARCH_API_BASE_URL = "https://api.github.com/search/repositories?q=";
	private final String SEARCH_URL = GITHUB_SEARCH_API_BASE_URL + "language:";
	
	public ResponseEntity<String> callGitHubAPI (String query) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/vnd.github.v3+json");
		HttpEntity<String> entity = new HttpEntity<String>(headers);		
		ResponseEntity<String> gitResponse = restTemplate.exchange(SEARCH_URL + query, HttpMethod.GET, entity, String.class);
		return gitResponse;		
	}
	
	

}
