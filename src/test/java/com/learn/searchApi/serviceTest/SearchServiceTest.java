package com.learn.searchApi.serviceTest;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.learn.searchApi.Service.SearchService;
import com.learn.searchApi.Service.SearchServiceImpl;
import com.learn.searchApi.client.SearchClient;

//@RunWith(MockitoJUnitRunner.class)
//@PrepareForTest({SearchService.class, SearchServiceImpl.class})
public class SearchServiceTest {
	
	@InjectMocks
	private SearchService  searchService = new SearchServiceImpl();
	
	@Mock
	SearchClient mockSearchClient;
	
	@Test
	public void searchProjectsTest() throws Exception {
		Mockito.when(mockSearchClient.callGitHubAPI(Mockito.anyString())).thenReturn(new ResponseEntity<String>(HttpStatus.OK));
		searchService.searchProjects(Mockito.anyString());
	}

}
