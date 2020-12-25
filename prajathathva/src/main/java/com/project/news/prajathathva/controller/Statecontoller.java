package com.project.news.prajathathva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.news.prajathathva.pojo.NewsPublish;
import com.project.news.prajathathva.repo.News;




@Controller
public class Statecontoller {

	@Autowired
	News news ;
	
	@GetMapping("/state")
	public ModelAndView state() {
		ModelAndView model = new ModelAndView("state");
		List<NewsPublish> state = news.selectbycat("ರಾಜ್ಯ");
		model.addObject("state", state);
		List<NewsPublish> latest = news.latest3();
		model.addObject("latest", latest);
		return model;
	}
}
