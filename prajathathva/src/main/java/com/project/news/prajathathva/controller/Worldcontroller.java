package com.project.news.prajathathva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.news.prajathathva.pojo.NewsPublish;
import com.project.news.prajathathva.repo.News;

@Controller
public class Worldcontroller {
	
	@Autowired
	News news;
	
	@GetMapping("/world")
	public ModelAndView world() {
		ModelAndView model = new ModelAndView("world");
		List<NewsPublish> world = news.selectbycat("");
		model.addObject("world", world);
		List<NewsPublish> latest = news.latest3();
		model.addObject("latest", latest);
		return model;
	}

}
