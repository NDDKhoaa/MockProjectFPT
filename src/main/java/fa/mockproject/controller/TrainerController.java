package fa.mockproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fa.mockproject.service.TrainerService;

@Controller
public class TrainerController {
	@Autowired
	private TrainerService trainerService;
	
	@GetMapping("/showTrainerList")
	public String showTrainerList(Model model) {
		model.addAttribute("trainerList", trainerService.getAllProfile());
		return "trainerList";
	}
}
