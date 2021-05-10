package com.iu.ss1.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


//
// jsp 
//

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		
		model.addAttribute("message","JSP Project");
		return "index";
	}
	
}
