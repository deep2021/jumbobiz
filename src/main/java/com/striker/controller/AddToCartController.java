package com.striker.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddToCartController {

	HttpSession session;
	
	@RequestMapping(value="/addToCart")
	public ModelAndView addToCart(HttpServletRequest request){
		
		if(session.getAttribute("login")==null){
			return new ModelAndView("login");
		}
		else{
			return new ModelAndView("");
		}
		
		
		
		
	}
	
	
}
