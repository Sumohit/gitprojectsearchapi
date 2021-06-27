package com.learn.searchApi.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.searchApi.Service.SearchService;
import com.learn.searchApi.domain.SearchResponse;
import com.learn.searchApi.exceptionHandler.ResourceNotFoundException;
import com.learn.searchApi.exceptionHandler.RestClientException;
import com.learn.searchApi.exceptionHandler.SearchExceptionHandler;

@RestController
@RequestMapping(
		  value = "/search-api",
		  produces = "application/json"
		)
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@Autowired
	private SearchExceptionHandler exceptionHandler;

	
	@GetMapping("/search-projects/{language}")
	public ResponseEntity<?> searchProjects(@PathVariable String language) {
		
		if(language.trim().isEmpty()) {
			return exceptionHandler.resourceNotFound(new ResourceNotFoundException("Invalid Request: search query is blank"));
		}
		Optional<List<SearchResponse>> response;
		try {
			response = searchService.searchProjects(language);
		} catch (Exception ex) {			
			return exceptionHandler.unprocessableEntity(new RestClientException(ex.getMessage()));
		}
		return response.isPresent()
				? ResponseEntity.ok(response)
						: ResponseEntity.notFound().build();
	}

}
