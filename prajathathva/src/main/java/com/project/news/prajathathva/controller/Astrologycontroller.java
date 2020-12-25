package com.project.news.prajathathva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.news.prajathathva.pojo.NewsPublish;
import com.project.news.prajathathva.repo.News;

@Controller
public class Astrologycontroller {

	@Autowired
	News news ;
	
	@GetMapping("/astrology")
	public ModelAndView astrology() {
		ModelAndView model = new ModelAndView("astrology");
		List<NewsPublish> astro = news.selectbycat("ಜ್ಯೋತಿಷ್ಯ");
	model.addObject("astro", astro);
	List<NewsPublish> latest = news.latest3();
	model.addObject("latest", latest);
		return model;
	}
}
