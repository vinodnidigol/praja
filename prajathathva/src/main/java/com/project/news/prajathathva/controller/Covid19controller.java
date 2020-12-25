package com.project.news.prajathathva.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.project.news.prajathathva.pojo.NewsPublish;
import com.project.news.prajathathva.repo.News;

@Controller
public class Covid19controller {

	@Autowired
	News news ;
	
	@GetMapping("/covid19")
	public ModelAndView covid19() {
		ModelAndView m = new ModelAndView("covid19");
		List<NewsPublish> ne =  news.selectbycat("ಕೋವಿಡ್-19") ;
		m.addObject("covid19", ne);
		List<NewsPublish> latest= news.latest3();
		m.addObject("latest", latest);
//		for (int i = 0; i < ne.size(); i++) {
//			System.out.println(ne.get(i));
//			
//		}
		return m;
	}
	
	
	@GetMapping("/selectby/{cat}")
	public String selectbycat(@PathVariable(value="category") String cat,
			Model m,NewsPublish np ) {
//		np = news.selectbycat(cat);
		m.addAttribute("title", np.getTitle());
		
		return "Findbyid" ;
	}

}
