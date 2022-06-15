package fa.mockproject.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.mockproject.model.TraineeModel;
import fa.mockproject.service.TraineeService;

@Controller
public class TraineeController {
	
	@Autowired
	TraineeService traineeService;
	
	@GetMapping(value = "/showTraineeInfo")
	public String showUpdateTrainee(Model model, @RequestParam("id") long id, HttpSession session) {
		
		TraineeModel traineeModel = traineeService.getTraineeModel(id);
		model.addAttribute("traineeModel", traineeModel);
		session.setAttribute("traineeModel", traineeModel);
		return "traineeInfo";
	}
	
	@GetMapping(value = "/updateTrainee")
	public String updateTrainee(Model model
			, HttpSession session) {
		TraineeModel traineeModel = (TraineeModel) session.getAttribute("traineeModel");
		model.addAttribute("traineeModel", traineeModel);

		return "updateTrainee";
	}
	
	@PostMapping(value = "/updateTrainee")
	public String updateTrainee(@ModelAttribute("traineeModel") TraineeModel traineeModelForm, Model model
			, HttpSession session) {
//		TraineeModel traineeModel = (TraineeModel) session.getAttribute("traineeModel");
//		model.addAttribute("traineeModel", traineeModel);
		
		traineeService.update(traineeModelForm);

		
		return "redirect:/showTraineeList";
	}
	
	@GetMapping(value = "/showTraineeList")
	public String showTraineeList(Model model) {
		List<TraineeModel> traineeModelList = traineeService.getTraineeModelList();
		model.addAttribute("traineeModelList", traineeModelList);
		return "traineeList";
	}
}
