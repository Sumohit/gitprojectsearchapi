package com.learn.searchApi.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.searchApi.client.SearchClient;
import com.learn.searchApi.domain.SearchResponse;

@Service
public class SearchServiceImpl implements SearchService{
	
	@Autowired
	private SearchClient client;
	
	@Override
	public Optional<List<SearchResponse>> searchProjects(String query) throws Exception {
		ResponseEntity<String> response = client.callGitHubAPI(query);
		return Optional.of(transfromResponse(response));
	}
	
	private List<SearchResponse>  transfromResponse(ResponseEntity<String> response) throws JsonMappingException, JsonProcessingException {
		List<SearchResponse> searchList = new ArrayList<SearchResponse>();
			JsonNode productNode = new ObjectMapper().readTree(response.getBody());
			for(JsonNode res : productNode.get("items")) {
				SearchResponse rep = new ObjectMapper().readValue(res.toString(), SearchResponse.class);
				searchList.add(rep);
			}		
		return searchList;
	}

}
