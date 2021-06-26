package com.informatica.controllerTest;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.informatica.controller.SearchController;
import com.informatica.exceptionHandler.RestClientException;
import com.informatica.service.impl.SearchServiceImpl;

@ExtendWith(MockitoExtension.class)
public class SearchControllerTest {
	
	@Mock
	private SearchServiceImpl mockSearchService;
	
	@BeforeEach
    public void initMocks(){
		mockSearchService =  Mockito.mock(SearchServiceImpl.class);
    }
	

	@Test
	public void givenInvalidSearchRequestShouldReturnError() throws ParseException, RestClientException {
		SearchController searchControllerObj = new SearchController();
		Mockito.when(mockSearchService.searchProjects(Mockito.anyString())).thenReturn(Optional.of(new ArrayList<>()));
		ResponseEntity<List<Map<String, Object>>> response = searchControllerObj.searchProjectsFromGitHub(Optional.of(Mockito.anyString()));
		
		

	}
}
