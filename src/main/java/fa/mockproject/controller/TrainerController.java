package fa.mockproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fa.mockproject.entity.TrainerProfile;
import fa.mockproject.entity.enumtype.TrainerTypeEnum;
import fa.mockproject.model.TrainerModel;
import fa.mockproject.service.TrainerService;

@Controller
public class TrainerController {
	@Autowired
	private TrainerService trainerService;

	@GetMapping("/showTrainerList")
	public String showTrainerList(Model model,@Param("keyword") String keyword) {
		List<TrainerProfile> trainerList = trainerService.getAllTrainers(keyword);
		model.addAttribute("trainerList", trainerList);
		model.addAttribute("keyword", keyword);
		return "viewTrainer";
	}

	@GetMapping("/showTrainerForm")
	public String newTrainer(Model model) {
		TrainerModel trainerModel = new TrainerModel();
		model.addAttribute("trainerModel", trainerModel);
		
		model.addAttribute("trainerTypes", TrainerTypeEnum.values());
		return "createTrainer";
	}

	@PostMapping("/saveTrainer")
	public String saveTrainer(@Valid @ModelAttribute("trainerModel") TrainerModel trainerModel,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "createTrainer";
		}else {
			trainerService.save(trainerModel);
			return "redirect:/showTrainerList";
		}
	}

	@GetMapping("/showFormForUpdateTrainer/{id}")
	public String showUpdateForm(@PathVariable(value = "id") long id, Model model) {
		TrainerProfile trainerProfile = trainerService.findByTrainerId(id);
		model.addAttribute("trainerModel", trainerProfile);
		return "updateTrainer";
	}
	
	@GetMapping("/deleteTrainer/{id}")
	public String deleteTrainer(@PathVariable(value="id")long id) {
		trainerService.deleteTrainerProfileById(id);
		return "redirect:/showTrainerList";
	}
//	@InitBinder     
//	public void initBinder(WebDataBinder binder){
//	     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//	     binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat, false));   
//	}
}
