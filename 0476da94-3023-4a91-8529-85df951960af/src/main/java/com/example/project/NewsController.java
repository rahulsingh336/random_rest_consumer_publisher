package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/news/topstories")
public class NewsController {

	@Autowired
	private NewsService newsService;

	@RequestMapping(method = RequestMethod.GET)
	public Map getNews() throws Exception {
		return newsService.getTopStories();
	}

}
