package com.learn.searchApi.Service;

import java.util.List;
import java.util.Optional;

import com.learn.searchApi.domain.SearchResponse;

public interface SearchService {
	
	public Optional<List<SearchResponse>> searchProjects (String query) throws Exception;

}
