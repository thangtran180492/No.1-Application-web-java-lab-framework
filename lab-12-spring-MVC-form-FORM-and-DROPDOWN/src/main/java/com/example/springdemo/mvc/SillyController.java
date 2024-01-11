package com.example.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SillyController {
	
	/* mapping has the same name */
	@RequestMapping("/showForm")
	public String showForm() {
		// go to page jsp helloWorld-form
		return "helloWorld-form";
	}
	
	/* controller go to result of form */
	@RequestMapping("/processForm")
	public String processForm() {
		// go to page jsp helloWorld
		return "helloWorld";
	}
	
	/* controller get request and add data addAtribute */
	@RequestMapping("/precessFormVersionTwo")
	public String letsShooutDude(HttpServletRequest request, Model model) {
		
		// step 1 : get param form request
		String name = request.getParameter("studentName");
		
		// step 2 : cover data
		String resutle = "Yo! " + name.toUpperCase();
		
		
		// step 3 : add data to model
		model.addAttribute("message", resutle);
		
		// step 4 : go to page helloWorld
		return "helloWorld";
	}
	
	/*  
	 * @RequestParam : get param from http 
	 * Model : data and can add*/
	@RequestMapping("/precessFormVersionThree")
	public String precessFormVersionThree(
			@RequestParam("studentName") String theName,
			Model model) {
		// step 1 : cover data
		String result = "Hi, My friend from V3! : " + theName.toUpperCase();
		
		// step 2 : add data to model
		model.addAttribute("message", result);
		
		// step 3 : go to page helloWorld
		return "helloWorld";
	}
}
