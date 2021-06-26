package com.informatica.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.json.simple.parser.ParseException;

import com.informatica.exceptionHandler.RestClientException;

public interface SearchService {

	public Optional <List<Map<String, Object>>> searchProjects(String codeLangauage) throws ParseException, RestClientException;

}
