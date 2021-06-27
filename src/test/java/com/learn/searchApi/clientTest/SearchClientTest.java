package com.learn.searchApi.clientTest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.learn.searchApi.client.SearchClient;


public class SearchClientTest {

	private SearchClient searchclient = new SearchClient();

	@Test
	public void givenSearchQueryReturn_200() throws Exception {
		ResponseEntity<String> gitResponse = searchclient.callGitHubAPI("java");
		Assert.assertEquals(HttpStatus.OK, gitResponse.getStatusCode());
	}

	@Test
	public void givenSearchQueryReturn_throwsException(){
		try {
			ResponseEntity<String> gitResponse = searchclient.callGitHubAPI("jskdhfs");
		} catch (Exception ex) {
			Assert.assertSame(Exception.class, ex);
		}

	}

}

