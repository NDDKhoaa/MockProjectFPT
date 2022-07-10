package fa.mockproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fa.mockproject.entity.Topic;
import fa.mockproject.model.AllocationModel;
import fa.mockproject.model.CommitmentViewModel;
import fa.mockproject.model.MilestoneForRewardPenaltyDTOModel;
import fa.mockproject.model.MilestoneTopicMarkDTOModel;
import fa.mockproject.model.MilestoneTopicMarkModel;
import fa.mockproject.model.RewardPenaltyModel;
import fa.mockproject.service.impl.AllocationServiceImpl;
import fa.mockproject.service.impl.CommitmentServiceImpl;
import fa.mockproject.service.impl.RewardPenaltyServiceImpl;
import fa.mockproject.service.impl.TopicServiceImpl;

@Controller
public class TopicController {
	
	@Autowired
	TopicServiceImpl topicService;
	
	@Autowired
	RewardPenaltyServiceImpl rewardPenaltyService;
	
	@Autowired
	AllocationServiceImpl allocationService;
	
	@Autowired
	CommitmentServiceImpl commitmentService;

	
	@GetMapping(value = "/trainingResult/deleteTopic/{id}/{traineeid}")
	public ModelAndView deleteMilestone(@PathVariable("id") String id, 
										@PathVariable("traineeid") String traineeId,
										ModelAndView modelAndView) {
		long topicId = Long.parseLong(id);

		String messageSuccess = topicService.deleteTopic(topicId);
		
		modelAndView.addObject("messageSuccess", messageSuccess);
		modelAndView.setViewName("redirect:/trainingResult/getMilestones?id=" + traineeId);

		return modelAndView;
	}
	
	@GetMapping(value="/trainingResult/viewTopicMark")
	public String viewTopicMark(Model model, 
								@RequestParam("traineeId") String traineeIdStr) {
		long traineeId = Long.parseLong(traineeIdStr);
		
		List<MilestoneTopicMarkModel> milestoneTopicMarkModels = topicService.getTopicMark(traineeId);
		
		model.addAttribute("milestoneTopicMarkModels", milestoneTopicMarkModels);
		return "traineeManagement/topicMark";
	}
	
	@GetMapping(value="/trainingResult/getTopicMark")
	public String getTopicMark(Model model, @RequestParam("traineeId") String traineeIdStr) {
		long traineeId = Long.parseLong(traineeIdStr);
		
		List<MilestoneTopicMarkModel> milestoneTopicMarkModels = topicService.getTopicMark(traineeId);
		
		MilestoneTopicMarkDTOModel milestoneTopicMarkDTOModel = new MilestoneTopicMarkDTOModel(milestoneTopicMarkModels);
		
		System.out.println(milestoneTopicMarkDTOModel.getMilestoneTopicMarkModels().get(0).getMilestoneName());
		
		model.addAttribute("updatedMilestoneTopicMarkModels", milestoneTopicMarkDTOModel);
		model.addAttribute("listMilestoneTopicMarkModels", milestoneTopicMarkDTOModel.getMilestoneTopicMarkModels());
		
		return "traineeManagement/updateTopicMark";
	}
	
	@PostMapping(value = "/trainingResult/updateTopicMark")
	public String updateTopicMark(@ModelAttribute("listMilestoneTopicMarkModels") MilestoneTopicMarkDTOModel milestoneTopicMarkDTOModel,
								@ModelAttribute("listRewardAndPenalties") MilestoneForRewardPenaltyDTOModel milestoneForRewardPenaltyDTOModel,
								@ModelAttribute("allocationModel") AllocationModel allocationModel,
								@ModelAttribute("commitmentViewModel") CommitmentViewModel commitmentViewModel,	
								@RequestParam("id") String traineeId) {
		String message = topicService.updateTopics(milestoneTopicMarkDTOModel.getMilestoneTopicMarkModels());
		String messageAllocation = allocationService.createAllocation(allocationModel, traineeId);

		if(milestoneForRewardPenaltyDTOModel.rewardPenaltyModels.get(0).getMilestoneId() != 1) {
			String successMassage = rewardPenaltyService.createNewRewardAndPenalty(milestoneForRewardPenaltyDTOModel.rewardPenaltyModels);
		}
		commitmentService.createAndUpdate(commitmentViewModel, Long.parseLong(traineeId));

		return "redirect:/trainingResult/getMilestones?id=" + traineeId;
	}
}
