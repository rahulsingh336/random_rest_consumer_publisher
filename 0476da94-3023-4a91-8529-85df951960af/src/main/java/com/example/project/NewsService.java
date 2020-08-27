package com.example.project;


import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class NewsService {

	public Map getTopStories() {
		JSONObject news = new JSONObject();
		String getUrl = "https://api.nytimes.com/svc/topstories/v2/us.json?api-key=oV5QQUuGN7jRD3TCGWcELG1tl9jLBO2i";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<Map> newsList = restTemplate.exchange(getUrl, HttpMethod.GET, entity, Map.class);
		if (newsList.getStatusCode() == HttpStatus.OK) {
			news = new JSONObject(newsList.getBody());
		}
		return newsList.getBody();
	}

	static RestTemplate restTemplate;

	public NewsService(){
		restTemplate = new RestTemplate();
	}
}
