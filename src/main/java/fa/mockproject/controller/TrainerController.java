package fa.mockproject.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fa.mockproject.entity.TrainerProfile;
import fa.mockproject.entity.enumtype.ClassManagementActionEnum;
import fa.mockproject.model.TrainerModel;
import fa.mockproject.service.TrainerService;

@Controller
public class TrainerController {
	@Autowired
	private TrainerService trainerService;
	@Autowired
	ResourceBundleMessageSource messageSource;

	@GetMapping("/showTrainerList")
	public String showTrainerList(Model model, @RequestParam Map<String, String> params) {
		trainerService.getAllTrainers(model, params);
		return "trainerManagement/viewTrainer";
	}

	@GetMapping("/searchTrainer")
	public String searchTrainer(Model model, 
			@Param("keyword") String keyword,
			@RequestParam Map<String, String> params) {
		trainerService.getAllTrainers(model, params,keyword);
		model.addAttribute("keyword", keyword);
		return "trainerManagement/viewTrainer";
	}

	@GetMapping("/showTrainerForm")
	public String newTrainer(Model model) {
		TrainerModel trainerModel = new TrainerModel();
		model.addAttribute("trainerModel", trainerModel);
		return "trainerManagement/createTrainer";
	}

	@PostMapping("/saveTrainer")
	public String saveTrainer(@Valid @ModelAttribute("trainerModel") TrainerModel trainerModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "trainerManagement/createTrainer";
		}
		trainerService.save(trainerModel);
		return "redirect:/showTrainerList";
	}

	@GetMapping("/showTrainerInfo/{id}")
	public String showTrainerInfo(@PathVariable(value = "id") long id, Model model) {
		TrainerProfile trainerProfile = trainerService.findByTrainerId(id);
		model.addAttribute("trainerModel", trainerProfile);
		return "trainerManagement/viewTrainerInfo";
	}
	
	@GetMapping("/showFormForUpdateTrainer/{id}")
	public String showUpdateForm(@PathVariable(value = "id") long id, Model model) {
		TrainerProfile trainerProfile = trainerService.findByTrainerId(id);
		model.addAttribute("trainerModel", trainerProfile);
		return "trainerManagement/updateTrainer";
	}
	@PostMapping("/updateTrainer")
	public String updateTrainer(@Valid @ModelAttribute("trainerModel") TrainerModel trainerModel,
			BindingResult bindingResult,Model model) throws HttpRequestMethodNotSupportedException {
		try {
			if (bindingResult.hasErrors()) {
				return "redirect:/updateTrainer";
			}
		}catch(IllegalArgumentException | NullPointerException e) {
			e.printStackTrace();
			model.addAttribute("message", messageSource.getMessage("msg51", null, null));
			return "modals/errorModal";
		}
		
		trainerService.save(trainerModel);
		return "redirect:/showTrainerList";
	}
	
	@GetMapping("/deleteTrainer/{id}")
	public String deleteTrainer(@PathVariable(value = "id") long id) {
		trainerService.deleteTrainerProfileById(id);
		return "redirect:/showTrainerList";
	}

}
