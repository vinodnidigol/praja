package com.project.news.prajathathva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.news.prajathathva.pojo.NewsPublish;
import com.project.news.prajathathva.repo.News;

@Controller
public class Devotionalcontroller {

	@Autowired
	News news;
	
	@GetMapping("/devotional")
	public ModelAndView devotional() {
		ModelAndView model= new ModelAndView("devotional");
		List<NewsPublish> devo = news.selectbycat("ಆರಾಧನೆ/ ಆಚರಣೆ");
		model.addObject("devo", devo);
		List<NewsPublish> latest = news.latest3();
		model.addObject("latest", latest);
		return model;
	}
}
