package com.striker.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.striker.DAOI.ProductDAOI;
import com.striker.DTO.ProductDTO;

@Controller
public class HomeController {

	@Autowired
	private ProductDAOI dao4;
	
	@RequestMapping(value="/")
	public ModelAndView homePage(HttpServletRequest request,HttpServletResponse response){
	//	System.out.println("inside home page controller");
		 response.setContentType("image/jpeg");
		
		List<ProductDTO> list=dao4.viewProduct();
      // System.out.println("list ==="+list);	
    	return new ModelAndView("Home","product",list);
		
	}	
}