package com.project.news.prajathathva.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.project.news.prajathathva.pojo.NewsPublish;
import com.project.news.prajathathva.repo.News;





@Controller
public class NewspubController {
	
	@Autowired
	News news ;
	
	@GetMapping("/newspub")
	public ModelAndView newspub() {
		ModelAndView m = new ModelAndView("newspub");
		List<NewsPublish> ne = news.findAll() ;
		m.addObject("datalist", ne);
		return m;
	}

	@PostMapping("/newsupload")
	public String newsupload(@RequestParam("title") String title,
			@RequestParam("matter") String matter ,@RequestParam("cat") 
	String cat,@RequestParam("author")
	String author,@RequestParam("image") MultipartFile image) {
	try {
		Date date1 = new Date();
		System.out.println(date1);
		byte[] images = image.getBytes();
		NewsPublish ns = new NewsPublish(title, matter, images, author, cat, date1);
		
		news.save(ns);

	} catch (Exception e) {
		System.out.println(e);
	}
	
return "redirect:/newspub" ;
}
}