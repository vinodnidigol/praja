package com.project.news.prajathathva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.news.prajathathva.pojo.NewsPublish;
import com.project.news.prajathathva.repo.News;

@Controller
public class Educationcontroller {
	
	@Autowired
	News news;
	
	@GetMapping("/education")
	public ModelAndView education() {
		ModelAndView model = new ModelAndView("education");
		List<NewsPublish> edu = news.selectbycat("ಶಿಕ್ಷಣ/ ಉದ್ಯೋಗ");
		model.addObject("edu", edu);
		List<NewsPublish> latest = news.latest3();
		model.addObject("latest", latest);
		return model;
	}

}
