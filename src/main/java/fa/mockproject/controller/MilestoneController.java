package fa.mockproject.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fa.mockproject.entity.Milestone;
import fa.mockproject.entity.Topic;
import fa.mockproject.entity.enumtype.TopicStatus;
import fa.mockproject.entity.enumtype.WeightedNumberEnum;
import fa.mockproject.model.AllocationModel;
import fa.mockproject.model.AllowanceModel;
import fa.mockproject.model.AttendanceStatusModel;
import fa.mockproject.model.CommitmentViewModel;
import fa.mockproject.model.FinalAttendanceStatusModel;
import fa.mockproject.model.FinalGpaResult;
import fa.mockproject.model.GpaViewModel;
import fa.mockproject.model.MilestoneDTOModel;
import fa.mockproject.model.MilestoneForRewardPenaltyDTOModel;
import fa.mockproject.model.MilestoneIdTopicModel;
import fa.mockproject.model.MilestoneTopicMarkDTOModel;
import fa.mockproject.model.MilestoneTopicMarkModel;
import fa.mockproject.model.MilestonesModel;
import fa.mockproject.model.RewardPenaltyModel;
import fa.mockproject.model.TopicModel;
import fa.mockproject.repository.ClassBatchRepository;
import fa.mockproject.service.ClassBatchService;
import fa.mockproject.service.impl.AllocationServiceImpl;
import fa.mockproject.service.impl.AttendaceStatusServiceImpl;
import fa.mockproject.service.impl.CommitmentServiceImpl;
import fa.mockproject.service.impl.GpaServiceImpl;
import fa.mockproject.service.impl.MilestoneServiceImpl;
import fa.mockproject.service.impl.RewardPenaltyServiceImpl;
import fa.mockproject.service.impl.TopicServiceImpl;

@Controller
public class MilestoneController {

	@Autowired
	MilestoneServiceImpl milestoneService;

	@Autowired
	TopicServiceImpl topicService;

	@Autowired
	AttendaceStatusServiceImpl attendaceStatusService;

	@Autowired
	RewardPenaltyServiceImpl rewardPenaltyService;

	@Autowired
	GpaServiceImpl gpaService;

	@Autowired
	ClassBatchService classBatchService;

	@Autowired
	ClassBatchRepository classBatchRepository;
	
	@Autowired
	AllocationServiceImpl allocationService;
	
	@Autowired
	CommitmentServiceImpl commitmentService;

	@GetMapping(value = "/trainingResult/viewMilestones")
	public String getMilestoneConfigure(Model model, @RequestParam("id") String id) {
		long traineeId = Long.parseLong(id);

		MilestonesModel milestonesModel = milestoneService.getMilestonesModel(traineeId);
		List<Milestone> milestones = milestonesModel.getMileStones();
		MilestonesModel milestonesModelForAttendanceStatus = milestoneService.getMilestonesModel(traineeId);
		List<Milestone> milestonesForAttendanceStatus = milestonesModelForAttendanceStatus.getMileStones();
		List<AttendanceStatusModel> attendanceStatusModels = attendaceStatusService
				.getAttendaceStatusModels(milestonesForAttendanceStatus);
		FinalAttendanceStatusModel finalAttendanceStatusModel = null;
		if(!(attendanceStatusModels.isEmpty())) {
			finalAttendanceStatusModel = attendanceStatusModels.get(0)
					.getFinalAttendanceStatusModel();
		} else {
			finalAttendanceStatusModel = new FinalAttendanceStatusModel();
			finalAttendanceStatusModel.setFinalAbsentTimes(0);
			finalAttendanceStatusModel.setFinalDisciplinaryPoint(0);
			finalAttendanceStatusModel.setFinalLateEarlyLeave(0);
			finalAttendanceStatusModel.setFinalNoPermissionRate(0);
		}
		
		List<MilestoneTopicMarkModel> milestoneTopicMarkModels = topicService.getTopicMark(traineeId);
		List<RewardPenaltyModel> rewardPenaltyModels = rewardPenaltyService.getRewardAndPenalties(traineeId);
		List<GpaViewModel> gpaViewModels = this.calculateGpaView(milestonesForAttendanceStatus, milestoneTopicMarkModels,
				attendanceStatusModels, rewardPenaltyModels);
		int finalScore  = this.calculateFinalScore(milestoneTopicMarkModels);
		FinalGpaResult finalGpaResult = this.calculateFinalGpaResult(gpaViewModels, finalScore, finalAttendanceStatusModel);
		List<AllowanceModel> allowanceModels = this.calculateAllowance(gpaViewModels);
		CommitmentViewModel commitmentViewModel = this.calculateCommitment(milestones, allowanceModels);
		AllocationModel allocationModel =
				allocationService.getAllocation(traineeId);
		
		
		model.addAttribute("milestone", milestonesModel);
		model.addAttribute("milestones", milestones);
		model.addAttribute("attendanceStatusModels", attendanceStatusModels);
		model.addAttribute("finalAttendanceStatusModel", finalAttendanceStatusModel);
		model.addAttribute("milestoneTopicMarkModels", milestoneTopicMarkModels);
		model.addAttribute("finalTopicMarkScore", finalScore);
		model.addAttribute("rewardPenaltyModels", rewardPenaltyModels);
		model.addAttribute("gpaViewModels", gpaViewModels);
		model.addAttribute("allowanceModels", allowanceModels);
		model.addAttribute("commitmentViewModel", commitmentViewModel);
		model.addAttribute("finalGpaResult", finalGpaResult);
		model.addAttribute("allocationModel", allocationModel);
		
		return "traineeManagement/trainingResult";
	}

	@GetMapping(value = "/trainingResult/getMilestones")
	public String getMilestone(Model model, 
								@RequestParam("id") String id) {
		long traineeId = Long.parseLong(id);

		MilestonesModel milestonesModel = milestoneService.getMilestonesModel(traineeId);
		MilestoneDTOModel milestoneDTOModel = new MilestoneDTOModel(milestonesModel.getMileStones());
		MilestonesModel milestonesModel1 = milestoneService.getMilestonesModel(traineeId);
		List<Milestone> milestones1 = milestonesModel1.getMileStones();
		List<Milestone> milestonesForAttendanceStatus = milestonesModel1.getMileStones();
		List<AttendanceStatusModel> attendanceStatusModels = attendaceStatusService
				.getAttendaceStatusModels(milestones1);
		List<MilestoneTopicMarkModel> milestoneTopicMarkModels = topicService.getTopicMark(traineeId);
		FinalAttendanceStatusModel finalAttendanceStatusModel = new FinalAttendanceStatusModel();
		if(!(attendanceStatusModels.isEmpty())) {
			finalAttendanceStatusModel = attendanceStatusModels.get(0)
					.getFinalAttendanceStatusModel();
		} else {
			finalAttendanceStatusModel = new FinalAttendanceStatusModel();
			finalAttendanceStatusModel.setFinalAbsentTimes(0);
			finalAttendanceStatusModel.setFinalDisciplinaryPoint(0);
			finalAttendanceStatusModel.setFinalLateEarlyLeave(0);
			finalAttendanceStatusModel.setFinalNoPermissionRate(0);
		}
		MilestoneTopicMarkDTOModel milestoneTopicMarkDTOModel = new MilestoneTopicMarkDTOModel(
				milestoneTopicMarkModels);
		TopicStatus[] topicStatusesEnum = TopicStatus.values();
		ArrayList<String> topicStatuses = new ArrayList<String>();
		for(TopicStatus status : topicStatusesEnum) {
			topicStatuses.add(status.name());
		}
		MilestonesModel milestonesModelForReward = milestoneService.getMilestonesModel(traineeId);
		List<RewardPenaltyModel> rewardPenaltyModels = rewardPenaltyService.getRewardAndPenalties(traineeId);
		MilestoneForRewardPenaltyDTOModel milestoneForRewardPenaltyDTOModel = new MilestoneForRewardPenaltyDTOModel(
				rewardPenaltyModels);
		
		if (attendanceStatusModels.size() != 0) {
			finalAttendanceStatusModel = attendanceStatusModels.get(0).getFinalAttendanceStatusModel();
		}
		
		List<GpaViewModel> gpaViewModels = this.calculateGpaView(milestonesForAttendanceStatus, milestoneTopicMarkModels,
				attendanceStatusModels, rewardPenaltyModels);
		int finalScore  = this.calculateFinalScore(milestoneTopicMarkModels);
		FinalGpaResult finalGpaResult = this.calculateFinalGpaResult(gpaViewModels, finalScore, finalAttendanceStatusModel);
		List<AllowanceModel> allowanceModels = this.calculateAllowance(gpaViewModels);
		
		CommitmentViewModel commitmentViewModel = null;
		if(commitmentService.getCommitment(traineeId) != null) {
			commitmentViewModel = commitmentService.getCommitment(traineeId);
		} else {
			commitmentViewModel = this.calculateCommitment(milestones1, allowanceModels);
		}
		AllocationModel allocationModel =
				allocationService.getAllocation(traineeId);

		model.addAttribute("milestone", milestonesModel);
		model.addAttribute("updatedMilestones", milestoneDTOModel);
		model.addAttribute("listMilestones", milestonesModel.getMileStones());
		model.addAttribute("newMilestoneModel", new Milestone());
		model.addAttribute("newTopic", new TopicModel());
		model.addAttribute("attendanceStatusModels", attendanceStatusModels);
		model.addAttribute("finalAttendanceStatusModel", finalAttendanceStatusModel);
		model.addAttribute("milestonesForReward", milestonesModelForReward.getMileStones());
		model.addAttribute("updatedMilestoneTopicMarkModels", milestoneTopicMarkDTOModel);
		model.addAttribute("listMilestoneTopicMarkModels", milestoneTopicMarkDTOModel.getMilestoneTopicMarkModels());
		model.addAttribute("topicStatuses", topicStatuses);
		model.addAttribute("listRewardAndPenalties", milestoneForRewardPenaltyDTOModel);
		model.addAttribute("gpaViewModels", gpaViewModels);
		model.addAttribute("allowanceModels", allowanceModels);
		model.addAttribute("commitmentViewModel", commitmentViewModel);
		model.addAttribute("finalGpaResult", finalGpaResult);
		model.addAttribute("allocationModel", allocationModel);
		
		return "traineeManagement/configureMilestone";
	}

	@PostMapping(value = "/trainingResult/createMilestone")
	public String createMilestone(@ModelAttribute("newMilestoneModel") Milestone newMilestone,
										 @RequestParam("id") String id,
										 Model model,
										 RedirectAttributes redirectAttributes) {

		long traineeId = Long.parseLong(id);
		String messageSuccess = milestoneService.createMilestone(traineeId, newMilestone);
		
		redirectAttributes.addFlashAttribute("errorMessage", messageSuccess);

		return "redirect:/trainingResult/getMilestones?id=" + id;
	}

	@PostMapping(value = "/trainingResult/updateMilestone")
	public ModelAndView updateMilestone(@ModelAttribute("updatedMilestones") MilestoneDTOModel MilestoneDTOModel,
										@ModelAttribute("newTopic") TopicModel topicModel,									
										@RequestParam("action") String action,
										@RequestParam("milestoneId") String milestoneId, 
										@RequestParam("traineeid") String traineeId,
										ModelAndView modelAndView) {
		long traineeid = Long.parseLong(traineeId);
		
		
		if (action.equals("Add")) {
			MilestoneIdTopicModel milestoneIdTopic = this.getTopic(topicModel, milestoneId);
			
			String successMessage = topicService.createTopic(topicModel, milestoneIdTopic.getTopic(),
						milestoneIdTopic.getMilestoneId());

		} else {
			List<Milestone> milestones = MilestoneDTOModel.getMilestones();
			String successMesage = milestoneService.updateMilestone(milestones, traineeid);
			
		}

		modelAndView.setViewName("redirect:/trainingResult/getMilestones?id=" + traineeId);

		return modelAndView;
	}

	@GetMapping(value = "/trainingResult/deleteMilestone/{id}/{traineeid}")
	public ModelAndView deleteMilestone(@PathVariable("id") String id, 
										@PathVariable("traineeid") String traineeId,
										ModelAndView modelAndView) {

		long milestoneId = Long.parseLong(id);

		String messageSuccess = milestoneService.deleteMilestone(milestoneId);
		
		modelAndView.addObject("messageSuccess", messageSuccess);
		modelAndView.setViewName("redirect:/trainingResult/getMilestones?id=" + traineeId);

		return modelAndView;
	}
	
	@GetMapping(value = "/trainingResult/deleteRewardAndPenalty/{id}/{traineeid}")
	public ModelAndView deleteRewardPenalty(@PathVariable("id") String id, 
										@PathVariable("traineeid") String traineeId,
										ModelAndView modelAndView) {
		String messageSuccess = null;
		System.out.println(id);
		if(!(id.isEmpty())) {
			long rewardPenaltyId = Long.parseLong(id);
			messageSuccess = rewardPenaltyService.deleteRewardPenalty(rewardPenaltyId);
		}
		
		
		modelAndView.addObject("messageSuccess", messageSuccess);
		modelAndView.setViewName("redirect:/trainingResult/getMilestones?id=" + traineeId);

		return modelAndView;
	}

	private MilestoneIdTopicModel getTopic(TopicModel topicModel, String milestoneId) {
		String milestoneid = null;
		List<String> topicNames = Arrays.asList(topicModel.getTopicName().split(","));
		List<String> milestoneIds = Arrays.asList(milestoneId.split(","));

		for (String name : topicNames) {
			if (!(name.equals(""))) {
				topicModel.setTopicName(name);
				milestoneid = milestoneIds.get(topicNames.indexOf(name));
			}
		}
		MilestoneIdTopicModel milestoneIdTopicModel = new MilestoneIdTopicModel();
		Topic topic = new Topic();
		topic.setTopicName(topicModel.getTopicName());
		topic.setMaxScore(topicModel.getMaxScore());
		topic.setPassingScore(topicModel.getPassingScore());
		topic.setWeightedNumber(topicModel.getWeightedNumber());
		topic.setTopicName(topicModel.getTopicName());
		topic.setTopicName(topicModel.getTopicName());
		milestoneIdTopicModel.setMilestoneId(milestoneid);
		milestoneIdTopicModel.setTopic(topic);
		return milestoneIdTopicModel;
	}

	private List<GpaViewModel> calculateGpaView(List<Milestone> milestones,
			List<MilestoneTopicMarkModel> milestoneTopicMarkModels, List<AttendanceStatusModel> attendanceStatusModels,
			List<RewardPenaltyModel> rewardPenaltyModels) {
		List<GpaViewModel> gpaViewModels = new ArrayList<GpaViewModel>();
		int i = 0;
		int indexOfTopicMark = 0;
		int indexOfRewardPenalty = 0;
		int indexOfAttendanceStatus = 0;
		int gpaResult = 0;
		int topicMark = 0;
		int disciplinaryPoint = 0;
		int bonusPoint = 0;
		int penaltyPoint = 0;
		String weightedNumberDemo = "70-30-10-10";
		Map<WeightedNumberEnum, Integer> weightedNumber = classBatchService.convertWeightedNumber(weightedNumberDemo);
		weightedNumber.get(WeightedNumberEnum.AcademicMark);
		for (Milestone milestone : milestones) {
			gpaResult = 0;
			GpaViewModel gpaViewModel = new GpaViewModel();

			gpaViewModel.setMilestoneName(milestone.getMilestoneName());

			if (indexOfTopicMark < milestoneTopicMarkModels.size()
					&& milestoneTopicMarkModels.get(indexOfTopicMark) != null) {
				topicMark = milestoneTopicMarkModels.get(indexOfTopicMark).getTotal();
				gpaViewModel.setAcademicMark(topicMark);
				indexOfTopicMark++;
			}

			if (indexOfAttendanceStatus < attendanceStatusModels.size()
					&& attendanceStatusModels.get(indexOfAttendanceStatus) != null) {
				disciplinaryPoint = attendanceStatusModels.get(indexOfAttendanceStatus).getDisciplinaryPoint();
				gpaViewModel.setDisciplinaryPoint(disciplinaryPoint);
				indexOfAttendanceStatus++;
			}

			if (indexOfRewardPenalty < rewardPenaltyModels.size()
					&& rewardPenaltyModels.get(indexOfRewardPenalty) != null) {
				if(rewardPenaltyModels.get(indexOfRewardPenalty).getBonusPoint() != null) {
					bonusPoint = Integer.parseInt(rewardPenaltyModels.get(indexOfRewardPenalty).getBonusPoint()) * 10;
					penaltyPoint = Integer.parseInt(rewardPenaltyModels.get(indexOfRewardPenalty).getPenaltyPoint()) * 10;
				}
				gpaViewModel.setBonus(bonusPoint);
				gpaViewModel.setPelnaty(penaltyPoint);
				indexOfRewardPenalty++;
			}

			weightedNumber.get(WeightedNumberEnum.AcademicMark);

			if (penaltyPoint == 0) {
				gpaResult = (topicMark * weightedNumber.get(WeightedNumberEnum.AcademicMark)
						+ disciplinaryPoint * weightedNumber.get(WeightedNumberEnum.DisciplinaryPoint)
						+ bonusPoint * weightedNumber.get(WeightedNumberEnum.BonusPoint)) / 100;
			} else {
				gpaResult = (topicMark * weightedNumber.get(WeightedNumberEnum.AcademicMark)
						+ disciplinaryPoint * weightedNumber.get(WeightedNumberEnum.DisciplinaryPoint)
						+ bonusPoint * weightedNumber.get(WeightedNumberEnum.BonusPoint)
						- penaltyPoint * weightedNumber.get(WeightedNumberEnum.Penaltypoint)) / 100;
			}
			gpaViewModel.setMilestoneId(milestone.getMilestoneId());
			gpaViewModel.setGpaResult(gpaResult);
			gpaViewModels.add(gpaViewModel);
			i++;
		}
		return gpaViewModels;
	}
	
	private List<AllowanceModel> calculateAllowance (List<GpaViewModel> gpaViewModels) {
		List<AllowanceModel> allowanceModels = new ArrayList<AllowanceModel>();
		for(GpaViewModel gpaViewModel : gpaViewModels) {
			AllowanceModel allowanceModel = new AllowanceModel();
			long milestoneId = gpaViewModel.getMilestoneId();
			String milestoneName = gpaViewModel.getMilestoneName();
			int gpaResult = gpaViewModel.getGpaResult();
			String salaryPaid = milestoneService.getMilestone(milestoneId).getSalaryPaid();
			String level = null;
			long allowanceStandard = 5000000;
			if(gpaViewModel.getGpaResult() >= 93) {
				level = "A+";
				allowanceStandard *= 1.2;
			} else if (gpaViewModel.getGpaResult() >= 86 && gpaViewModel.getGpaResult() < 93) {
				level = "A";
				allowanceStandard *= 1.2;
			} else if (gpaViewModel.getGpaResult() >= 72 && gpaViewModel.getGpaResult() < 86) {
				level = "B";
			} else if (gpaViewModel.getGpaResult() >= 60 && gpaViewModel.getGpaResult() < 72) {
				level = "C";
				allowanceStandard *= 0.6;
			} else if (gpaViewModel.getGpaResult() < 60) {
				level = "D";
				allowanceStandard = 0;
			}
			allowanceModel.setAllowanceStandard(allowanceStandard);
			allowanceModel.setGpa(gpaResult);
			allowanceModel.setLevel(level);
			allowanceModel.setMilestoneId(milestoneId);
			allowanceModel.setMilestoneName(milestoneName);
			allowanceModel.setSalaryPaid(salaryPaid);
			allowanceModels.add(allowanceModel);
		}
		return allowanceModels;
	}
	
	public CommitmentViewModel calculateCommitment(List<Milestone> milestones, List<AllowanceModel> allowanceModels) {
		long total = 0;
		LocalDate maxDate = null;
		LocalDate minDate = null;
		
		if(milestones.size() != 0) {
			minDate = milestones.get(0).getStartDate();
		}
		if(milestones != null && milestones.size() > 0 && milestones.get(0).getEndDate() != null) {
			for (Milestone milestone : milestones) {
				if(minDate.compareTo(milestone.getEndDate()) < 0) {
					maxDate = milestone.getEndDate();
				}
			}
		}
		
		CommitmentViewModel commitmentViewModel = new CommitmentViewModel();
		if(maxDate != null && minDate != null) {
			commitmentViewModel.setCommittedWorkingStartDate(maxDate.plusDays(30));
			long elapsedDays = ChronoUnit.DAYS.between(minDate, maxDate);
			if(elapsedDays <= 30) {
				commitmentViewModel.setCommittedWorkingDuration(4);
				commitmentViewModel.setCommittedWorkingEndDate(maxDate.plusMonths(4));
			} else if (elapsedDays > 30 && elapsedDays <= 60) {
				commitmentViewModel.setCommittedWorkingDuration(6);
				commitmentViewModel.setCommittedWorkingEndDate(maxDate.plusMonths(6));
			} else if (elapsedDays > 60) {
				commitmentViewModel.setCommittedWorkingDuration(12);
				commitmentViewModel.setCommittedWorkingEndDate(maxDate.plusMonths(12));
			}
			for(AllowanceModel allowanceModel : allowanceModels) {
				
				total += allowanceModel.getAllowanceStandard();
				
			}
			commitmentViewModel.setCommittedValue(total);
		}
		
		return commitmentViewModel;
	}
	
	public int calculateFinalScore (List<MilestoneTopicMarkModel> milestoneTopicMarkModels) {
		int totalFinalScore = 0;
		for (MilestoneTopicMarkModel milestoneTopicMarkModel : milestoneTopicMarkModels) {
			totalFinalScore += milestoneTopicMarkModel.getTotal();
		}
		int finalScore = (int) (totalFinalScore / (double) milestoneTopicMarkModels.size());
		return finalScore;
	}
	
	public FinalGpaResult calculateFinalGpaResult(List<GpaViewModel> gpaViewModels, int finalScore, FinalAttendanceStatusModel finalAttendanceStatusModel)  {
		FinalGpaResult finalGpaResult = new FinalGpaResult();
		finalGpaResult.setFinalAcademicMark(finalScore);
		finalGpaResult.setFinalDisciplinaryPoint(finalAttendanceStatusModel.getFinalDisciplinaryPoint());
		
		int totalBonus = 0;
		int totalPenalty = 0;
		int totalGpaResult = 0;
		for(GpaViewModel gpaViewModel : gpaViewModels) {
			totalBonus += gpaViewModel.getBonus();
			totalPenalty += gpaViewModel.getPelnaty();
			totalGpaResult += gpaViewModel.getGpaResult();
		}
		int finalBonus = (int) (totalBonus/ (double) gpaViewModels.size());
		int finalPenalty = (int) (totalPenalty/ (double) gpaViewModels.size());
		int finalGpaMark = (int) (totalGpaResult/ (double) gpaViewModels.size());
		
		finalGpaResult.setFinalBonus(finalBonus);
		finalGpaResult.setFinalPelnaty(finalPenalty);
		finalGpaResult.setFinalGpaResult(finalGpaMark);
		return finalGpaResult;
	}
}
