package com.learn.searchApi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResponse {
	@JsonProperty("name")
	private String name;
	@JsonProperty("url")
	private String url;
	@JsonProperty("owner")
	private Owner owner;
	@JsonProperty("id")
	private int projectId;
	
	@Override
	public String toString() {
		return "{\"url\":\"" + url 
				+ "\", \"owner\":" + owner
				+ "\", \"name\":\"" + name
				+ "\", \"projectId\":" + projectId
				+ "}";		
	}

}
