package com.learn.searchApi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Owner {
	@JsonProperty("login")
	private String  login ;
	@JsonProperty("id")
	private int id ;
	@JsonProperty("node_id")
	private String  node_id ; 
	@JsonProperty("avatar_url")
	private String  avatar_url ; 
	@JsonProperty("gravatar_id")
	private String  gravatar_id ; 
	@JsonProperty("url")
	private String  url ; 
	@JsonProperty("html_url")
	private String  html_url ;
	@JsonProperty("followers_url")
	private String  followers_url ;
	@JsonProperty("following_url")
	private String  following_url ;
	@JsonProperty("gists_url")
	private String  gists_url ; 
	@JsonProperty("starred_url")
	private String  starred_url ; 
	@JsonProperty("namsubscriptions_urle")
	private String  subscriptions_url ;
	@JsonProperty("organizations_url")
	private String  organizations_url ; 
	@JsonProperty("repos_url")
	private String  repos_url ; 
	@JsonProperty("events_url")
	private String  events_url ; 
	@JsonProperty("received_events_url")
	private String  received_events_url ; 
	@JsonProperty("type")
	private String  type ; 
	@JsonProperty("site_admin")
	private String  site_admin ;
	
	@Override
	public String toString() {
		return "{\"login\":\"" + login 
				+ "\", \"id\":\"" + id
				+ ", \"node_id\":\"" + node_id
				+ "\", \"avatar_url\":\"" + avatar_url
				+ "\", \"gravatar_id\":\"" + gravatar_id
				+ "\", \"url\":\"" + url
				+ "\", \"html_url\":\"" + html_url
				+ "\", \"followers_url\":\"" + followers_url
				+ "\", \"following_url\":\"" + following_url
				+ "\", \"gists_url\":\"" + gists_url
				+ "\", \"starred_url\":\"" + starred_url
				+ "\", \"subscriptions_url\":\"" + subscriptions_url
				+ "\", \"organizations_url\":\"" + organizations_url
				+ "\", \"repos_url\":\"" + repos_url
				+ "\", \"events_url\":\"" + events_url
				+ "\", \"received_events_url\":\"" + received_events_url
				+ "\", \"type\":\"" + type
				+ "\", \"site_admin\":\"" + site_admin
				+ "\"}";		
	}

}
