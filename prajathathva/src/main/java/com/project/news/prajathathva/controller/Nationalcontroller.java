package com.project.news.prajathathva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.news.prajathathva.pojo.NewsPublish;
import com.project.news.prajathathva.repo.News;

@Controller
public class Nationalcontroller {

	@Autowired
	News news ;
	
	@GetMapping("/national")
	public ModelAndView national() {
		ModelAndView model  = new ModelAndView("national");
		List<NewsPublish> nat = news.selectbycat("ರಾಷ್ಟ್ರೀಯ");
		model.addObject("nat", nat);
		List<NewsPublish> latest = news.latest3();
		model.addObject("latest", latest);
		return model;
	}
}
