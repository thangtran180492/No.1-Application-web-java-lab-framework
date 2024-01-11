package com.example.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	/* Model lưu trữ dữ liệu trong suốt phiên người dùng */
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		Student theStudent = new Student();
		
		model.addAttribute("student", theStudent);
		
		return "student-form";
	}
	
	/* @ModelAttribute sẽ lấy student khởi tạo từ model */
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		
		// console ra ngay khi ánh xạ đến
		System.out.println("the sdutent : " + student.getFirstName() + " " + student.getLastName());
		for(String str : student.getOprerationSystems()) {
			System.out.println(str);
		}
		
		return "student-confirmation";
	}
}
