package com.project.news.prajathathva.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.news.prajathathva.pojo.NewsPublish;
import com.project.news.prajathathva.repo.News;

@Controller
public class HomeController {

	@Autowired
	News news ;
	
	@GetMapping("/")
	public ModelAndView newspub() {
		ModelAndView m = new ModelAndView("home");
		List<NewsPublish> ne = news.findAll() ;	
		m.addObject("datalist", ne);
		
		List<NewsPublish> latest3 = news.latest3() ;	
		m.addObject("latest3", latest3);
		
		List<NewsPublish> covid195 = news.selectby5("ಕೋವಿಡ್-19",2);	
		m.addObject("covid195", covid195);
		
		List<NewsPublish> state5 = news.selectby5("ರಾಜ್ಯ",2);	
		m.addObject("state5", state5);
		
		List<NewsPublish> national5 = news.selectby5("ರಾಷ್ಟ್ರೀಯ",2);	
		m.addObject("national5", national5);
		
		List<NewsPublish> world5 = news.selectby5("ಜಗತ್ತು",2);	
		m.addObject("world5", world5);
		
		List<NewsPublish> sports5 = news.selectby5("ಕ್ರೀಡೆ",2);	
		m.addObject("sports5", sports5);
		
		List<NewsPublish> devotional5 = news.selectby5("ಆರಾಧನೆ/ ಆಚರಣೆ",2);	
		m.addObject("devotional5", devotional5);
		
		List<NewsPublish> astrology5 = news.selectby5("ಜ್ಯೋತಿಷ್ಯ",2);	
		m.addObject("astrology5", astrology5);
		
		List<NewsPublish> education5 = news.selectby5("ಶಿಕ್ಷಣ/ ಉದ್ಯೋಗ",2);	
		m.addObject("education5", education5);
		return m;
	}

	@GetMapping("/news/{id}")
	public String findbyid(@PathVariable(value="id") int id 
			,Model m ,HttpServletResponse res,NewsPublish np) {
	 np = news.getOne(id);
	try {
		m.addAttribute("title", np.getTitle());
		m.addAttribute("matter" ,np.getMatter());
		m.addAttribute("author", np.getAuthor());
		m.addAttribute("cat", np.getCat());
		m.addAttribute("date", np.getDate());
	} catch (Exception e) {
		// TODO: handle exception
	}
	 return "Findbyid";
	}
	
	@GetMapping("/upload/image/{id}")
	@ResponseBody
	void uploadimage(@PathVariable(value="id")
	int id ,HttpServletRequest req ,
	HttpServletResponse res,Optional<NewsPublish> nOptional)
			throws ServletException,IOException {
		nOptional= news.findById(id);
		System.out.println(nOptional.toString());
		res.setContentType("data/jpeg, data/jpg, data/png, data/gif");
		res.getOutputStream().write(nOptional.get().getImage());
		res.getOutputStream().close();
	}

	
}
