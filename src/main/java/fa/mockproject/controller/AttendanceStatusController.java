package fa.mockproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fa.mockproject.entity.Milestone;
import fa.mockproject.model.AttendanceStatusModel;
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
		
		MilestonesModel milestonesModel = milestoneService.getMilestonesModel(traineeId);
		List<Milestone> milestones = milestonesModel.getMileStones();
		
		List<AttendanceStatusModel> attendanceStatusModels =  attendaceStatusService.getAttendaceStatusModels(milestones);
		
		model.addAttribute("attendanceStatusModels", attendanceStatusModels);
		
		return "trainingResult";
	}
	
}
