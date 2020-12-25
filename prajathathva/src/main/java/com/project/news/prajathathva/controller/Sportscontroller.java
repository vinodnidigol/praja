package com.project.news.prajathathva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.news.prajathathva.pojo.NewsPublish;
import com.project.news.prajathathva.repo.News;

@Controller
public class Sportscontroller {

	@Autowired
	News news ;
	
	@GetMapping("/sports")
	public ModelAndView sports() {
		ModelAndView model = new ModelAndView("sports");
		List<NewsPublish> sport = news.selectbycat("ಕ್ರೀಡೆ");
		 model.addObject("sport", sport);
		 List<NewsPublish> latest = news.latest3();
		 model.addObject("latest", latest);
		return model;
	}
}
