package com.informatica.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.informatica.client.SearchClient;
import com.informatica.exceptionHandler.RestClientException;
import com.informatica.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService{

	@Autowired
	SearchClient searchClient;

	@Override
	public Optional <List<Map<String, Object>>> searchProjects(String codeLanguage) throws ParseException, RestClientException {
		return searchClient.getGitHubConnection(codeLanguage);
	}

}
