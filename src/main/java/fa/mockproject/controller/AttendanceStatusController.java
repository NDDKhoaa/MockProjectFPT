package fa.mockproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.mockproject.entity.AttendantDayCheck;
import fa.mockproject.entity.Milestone;
import fa.mockproject.entity.Trainee;
import fa.mockproject.entity.enumtype.StatusDay;
import fa.mockproject.model.AttendanceStatusModel;
import fa.mockproject.model.FinalAttendanceStatusModel;
import fa.mockproject.model.MilestoneAttendanceStatusModel;
import fa.mockproject.model.MilestonesModel;
import fa.mockproject.service.impl.AttendaceStatusServiceImpl;
import fa.mockproject.service.impl.MilestoneServiceImpl;

@Controller
public class AttendanceStatusController {
	
	@Autowired
	MilestoneServiceImpl milestoneService;
	
	@Autowired
	AttendaceStatusServiceImpl attendaceStatusService;
 	
	@GetMapping("/trainingResult/viewAttendanceStatus/{id}")
	public String viewAttendanceStatus (Model model, @PathVariable("id") String id) {
		
		long traineeId = Long.parseLong(id);
		System.out.println(traineeId);
		MilestonesModel milestonesModel = milestoneService.getMilestonesModel(traineeId);
		List<Milestone> milestones = milestonesModel.getMileStones();
		
		List<AttendanceStatusModel> attendanceStatusModels =  attendaceStatusService.getAttendaceStatusModels(milestones);
		FinalAttendanceStatusModel finalAttendanceStatusModel = attendanceStatusModels.get(0).getFinalAttendanceStatusModel();
		
		model.addAttribute("attendanceStatusModels", attendanceStatusModels);
		model.addAttribute("finalAttendanceStatusModel", finalAttendanceStatusModel);
		
		return "traineeManagement/showAttendanceStatus";
	}
	
	@GetMapping("/trainingResult/viewAttendanceDayStatus")
	public String viewAttendanceDayStatus(Model model, @RequestParam("milestoneid") String id) {
		
		long milestoneid = Long.parseLong(id);

		List<AttendantDayCheck> attendantDayChecks = milestoneService.getAttendanceStatusesByMilestoenId(milestoneid);
		
		model.addAttribute("attendantDayChecks", attendantDayChecks);
		
		return "traineeManagement/showAttendanceDayStatus";
	}
	
	@GetMapping("/trainingResult/updateViewAttendanceDayStatus")
	public String updateViewAttendanceDayStatus(Model model, @RequestParam("milestoneid") String id) {
		long milestoneid = Long.parseLong(id);
		
		List<AttendantDayCheck> attendantDayChecks = milestoneService.getAttendanceStatusesByMilestoenId(milestoneid);
		
		StatusDay[] statuses = StatusDay.values();
		ArrayList<String> status = new ArrayList<String>();
		for(StatusDay statusDay : statuses) {
			status.add(statusDay.name());
		}
		
		MilestoneAttendanceStatusModel attendanceStatusModel = new MilestoneAttendanceStatusModel();
		
		attendanceStatusModel.setAttendantDayChecks(attendantDayChecks);
		
		model.addAttribute("updatedAttendantDayChecks", attendanceStatusModel);
		model.addAttribute("listAttendantDayChecks", attendantDayChecks);
		model.addAttribute("statuses", status);
		
		
		return "traineeManagement/updateAttendanceDayStatus";
	}
	
	@PostMapping("/trainingResult/updateViewAttendanceDayStatus")
	public String updateAttendanceDayStatus(Model model, @RequestParam("milestoneid") String milestoneid,
											@ModelAttribute("updatedAttendantDayChecks") MilestoneAttendanceStatusModel milestoneAttendanceStatusModel) {
		
		String successMessage = attendaceStatusService.updateAll(milestoneAttendanceStatusModel.getAttendantDayChecks());
		
		Trainee trainee = milestoneService.getTraineeByMilestone(Long.parseLong(milestoneid));
		String traineeId = String.valueOf(trainee.getTraineeCandidateId());
		
		return "redirect:/trainingResult/getMilestones?id=" + traineeId;
	}
}
