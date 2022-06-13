package fa.mockproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.mockproject.model.TraineeModel;
import fa.mockproject.service.TraineeService;

@Controller
public class TraineeController {
	
	@Autowired
	TraineeService traineeService;
	
	@GetMapping(value = "/showTraineeInfo")
	public String showUpdateTrainee(Model model, @RequestParam("id") long id) {
		
		TraineeModel traineeModel = traineeService.getTraineeModel(id);
		model.addAttribute("traineeModel", traineeModel);
		
		return "traineeInfo";
	}
	
//	@PostMapping
//	public String updateTrainee(@ModelAttribute("traineeModel") TraineeModel traineeModel, Model model,
//			@RequestParam("id") int id) {
//		
//		
//		return "redirect:/traineeList";
//	}
	
	@GetMapping(value = "/showTraineeList")
	public String showTraineeList(Model model) {
		List<TraineeModel> traineeModelList = traineeService.getTraineeModelList();
		model.addAttribute("traineeModelList", traineeModelList);
		return "traineeList";
	}
}
