package fa.mockproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	// check on profile controller and class management controller
	// LandingPage
	@RequestMapping("/")
	public ModelAndView trainee() {
        var mav = new ModelAndView();
    
        mav.setViewName("LandingPage.html");

      
        return mav;
    }  
	
}
