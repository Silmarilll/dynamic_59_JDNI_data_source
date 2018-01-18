package com.spring.web.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.web.dao.Offer;
import com.spring.web.service.OffersService;

@Controller
public class OffersController {
	
	private OffersService offersService;
	
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

    @Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHome(Model model) {
		List<Offer> offers = offersService.getCurrent();
		model.addAttribute("offers", offers);
		return "home";
	}
}
