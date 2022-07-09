package fa.mockproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {
	
	@RequestMapping("/")
	private String baseTemplate() {
		return "baseTemplate";
	}
}
