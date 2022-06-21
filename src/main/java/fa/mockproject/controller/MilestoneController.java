package fa.mockproject.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fa.mockproject.entity.Milestone;
import fa.mockproject.model.MilestonesModel;
import fa.mockproject.repository.AttendantDayCheckRepository;
import fa.mockproject.repository.MilestoneRepository;
import fa.mockproject.service.impl.MilestoneServiceImpl;

@Controller
public class MilestoneController {
	
	@Autowired
	MilestoneServiceImpl milestoneService;
	
	@Autowired
	MilestoneRepository milestoneRepository;
	
	@Autowired
	AttendantDayCheckRepository attendantDayCheckRepository;
	
	@GetMapping(value = "/trainingResult/viewMilestones")
	public String getMilestoneConfigure(Model model, @RequestParam("id") String id) {
		long traineeId = Long.parseLong(id);
		MilestonesModel milestonesModel = milestoneService.getMilestonesModel(traineeId);
		
		List<Milestone> milestones = milestonesModel.getMileStones();
		
 		model.addAttribute("milestone", milestonesModel);
		model.addAttribute("milestones", milestones);
		
		return "trainingResult";
	}
	
	@GetMapping(value = "/trainingResult/getMilestone")
	public String getMilestone(Model model, @RequestParam("id") String id) {
		long traineeId = Long.parseLong(id);
		
		MilestonesModel milestonesModel = milestoneService.getMilestonesModel(traineeId);
		
		model.addAttribute("milestone", milestonesModel);
		model.addAttribute("newMilestoneModel", new Milestone());
		model.addAttribute("milestonesModel", milestonesModel.getMileStones());
		model.addAttribute("milestones",  new MilestonesModel());
		
		return "configureMilestone";
	}
	
	@PostMapping(value = "/trainingResult/createMilestone")
	public ModelAndView createMilestone(@ModelAttribute("newMilestoneModel") Milestone newMilestone
								, ModelAndView modelAndView
								, @RequestParam("id") String id) {
		
		long traineeId = Long.parseLong(id);
		System.out.println(newMilestone.getSalaryPaid());
		String messageSuccess = milestoneService.createMilestone(traineeId, newMilestone);
		
		modelAndView.addObject("messageSuccess", messageSuccess);
		modelAndView.setViewName("redirect:/trainingResult/getMilestone?id="+id);
		
		return modelAndView;
	}
	
	@PostMapping(value = "/trainingResult/updateMilestone")
	public ModelAndView updateMilestone(@ModelAttribute("milestones") List<Milestone> milestones
								, ModelAndView modelAndView
								, @RequestParam(value="action", required=true) String action) {
//								, @RequestParam("id") String id
		System.out.println(milestones.get(0).getMilestoneName());
//		System.out.println(milestones.size());
//		long traineeId = Long.parseLong(id);
		
		if(action.equals("updateTrainee")) {
//			milestoneService.updateMilestones();
		}
		
		return modelAndView;
	}

	@GetMapping(value = "/trainingResult/deleteMilestone/{id}/{traineeid}")
	public ModelAndView deleteMilestone(@PathVariable("id") String id
										, @PathVariable("traineeid") String traineeId
										, ModelAndView modelAndView) {
		
		long milestoneId = Long.parseLong(id);
		System.out.println(milestoneId);
		System.out.println(traineeId);
		String messageSuccess = milestoneService.deleteMilestone(milestoneId);
		
		modelAndView.addObject("messageSuccess", messageSuccess);
		modelAndView.setViewName("redirect:/trainingResult/getMilestone?id="+traineeId);
		
		return modelAndView;
	}
}
