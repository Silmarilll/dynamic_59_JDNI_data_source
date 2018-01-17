package com.spring.web.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OffersController {
	
/*	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHome(HttpSession session) {
		session.setAttribute("name", "Boris");
		return "home";
	}*/
	
/*	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showHome() {
		ModelAndView mv = new ModelAndView("home");
		Map<String, Object> model = mv.getModel();
		model.put("name", "<b>River</b>");
		return mv;
	}*/
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHome(Model model) {
		model.addAttribute("name", "<b>Tiffany</b>");
		return "home";
	}
}
