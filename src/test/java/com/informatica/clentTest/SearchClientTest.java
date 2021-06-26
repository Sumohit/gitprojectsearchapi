package com.informatica.clentTest;


import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.informatica.client.SearchClient;
import com.informatica.exceptionHandler.RestClientException;

public class SearchClientTest {
	
	private SearchClient searchClient;

	@Test
	public void givenSearchClientShouldReturnListOfProjects() throws ParseException, RestClientException {
		searchClient = new SearchClient();
		Optional <List<Map<String, Object>>> list = searchClient.getGitHubConnection("java");
		for(Map<String, Object> map: list.get()) {
			Assert.assertTrue(map.containsKey("url"));
		}
	}
	
	@Test
	public void givenSearchClientShouldReturnEmpty() throws ParseException, RestClientException {
		searchClient = new SearchClient();
		Optional <List<Map<String, Object>>> list = searchClient.getGitHubConnection("abc");
		for(Map<String, Object> map: list.get()) {
			Assert.assertTrue(map.containsKey("errorCode"));
		}		
	}

}
