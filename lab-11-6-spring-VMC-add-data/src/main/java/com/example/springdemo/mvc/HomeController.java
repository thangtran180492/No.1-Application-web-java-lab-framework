package com.example.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	/* RequestMapping sử lý tất cả các yêu cầu HTTP
	 * để nhận và đăng đối vơi dấu......... "/" 
	 * Lưu ý: lỗi 404 thường nằm ở url-pattern kiểm tra với RequestMapping*/
	@RequestMapping("/")
	public String goPage() {
		// trả về tên của view được tạo ra
		return "main-menu";
	}
}
