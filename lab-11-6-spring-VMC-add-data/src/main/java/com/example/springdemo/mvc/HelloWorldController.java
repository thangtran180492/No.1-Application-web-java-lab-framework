package com.example.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	/* controller go to Form */
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
}
