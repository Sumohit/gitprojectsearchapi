package com.informatica.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.informatica.constants.SearchConstants;
import com.informatica.exceptionHandler.RestClientException;


@Configuration
public class SearchClient {

	public Optional <List<Map<String, Object>>> getGitHubConnection(String codeLanguage) throws ParseException, RestClientException {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set(SearchConstants.ACCEPT, SearchConstants.ACCEPT_VALUE);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String> gitResponse = null;
		try {
			gitResponse = restTemplate.exchange(SearchConstants.SEARCH_URL + codeLanguage, HttpMethod.GET, entity, String.class);
		}catch(Exception ex) {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("errorCode", "422");
			map.put("errormessage", ex.getMessage());
			list.add(map);
			return Optional.of(list);
			//throw new RestClientException(ex.getMessage());
		}
		return filterSearchResponse(gitResponse);
	}

	private Optional <List<Map<String, Object>>> filterSearchResponse (ResponseEntity<String> gitResponse) throws ParseException {
		JSONParser parser = new JSONParser();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String,Object>();

		JSONObject root = (JSONObject) parser.parse(gitResponse.getBody());
		JSONArray itemsArray = (JSONArray) root.get("items");
		if(!itemsArray.isEmpty()) {
			JSONObject items = null;
			for(int i=0; i<itemsArray.size(); i++) {
				items = (JSONObject)itemsArray.get(i);
				map.put("url", items.get("url"));
				map.put("name", items.get("name"));
				map.put("productId", items.get("id"));
				map.put("owner", items.get("owner"));
				list.add(map);
			}
		}
		return Optional.of(list);		
	}
}
