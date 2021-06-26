package com.informatica.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.informatica.exceptionHandler.RestClientException;
import com.informatica.service.SearchService;

@RestController
@RequestMapping("/search-api")
public class SearchController {

	@Autowired
	private SearchService searchService;

	@GetMapping("/search-projects/{codingLanguage}")
	public ResponseEntity<List<Map<String, Object>>> searchProjectsFromGitHub(@PathVariable Optional<String> codingLanguage) throws ParseException, RestClientException {
		if(!codingLanguage.isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		Optional <List<Map<String, Object>>> response = searchService.searchProjects(codingLanguage.get());
		
		return response.isPresent()
				? ResponseEntity.ok(response.get())
						: ResponseEntity.notFound().build();
	}
}
