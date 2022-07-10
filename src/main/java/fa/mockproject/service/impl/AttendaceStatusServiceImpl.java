package fa.mockproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.AttendantDayCheck;
import fa.mockproject.entity.Milestone;
import fa.mockproject.entity.enumtype.StatusDay;
import fa.mockproject.model.AttendanceStatusModel;
import fa.mockproject.model.FinalAttendanceStatusModel;
import fa.mockproject.model.MilestoneAttendanceStatusModel;
import fa.mockproject.repository.AttendantDayCheckRepository;
import fa.mockproject.service.AttendaceStatusService;

@Service
public class AttendaceStatusServiceImpl implements AttendaceStatusService {

	@Autowired
	AttendantDayCheckRepository attendantDayCheckRepository;

	public List<AttendanceStatusModel> getAttendaceStatusModels(List<Milestone> milestones) {
		List<AttendanceStatusModel> attendanceStatusModels = new ArrayList<AttendanceStatusModel>();
		FinalAttendanceStatusModel finalAttendanceStatusModel = new FinalAttendanceStatusModel();
		
		int finalAbsentTimes = 0;
		int finalLateEarlyLeave = 0;
		int finalNoPermissionRate = 0;
		int finalDisciplinaryPoint = 0;
		
		for (Milestone milestone : milestones) {

			AttendanceStatusModel attendanceStatusModel = new AttendanceStatusModel();
			attendanceStatusModel.setMilestone(milestone);

			List<AttendantDayCheck> attendantDayChecks = milestone.getAttendantDayChecks();
			double absentTimes = 0;
			double lateEarlyLeave = 0;
			double x = 0;
			double y = 0;
			for (AttendantDayCheck attendantDayCheck : attendantDayChecks) {
				if (attendantDayCheck.getAttendantStatus().equals(StatusDay.A.name())
						|| attendantDayCheck.getAttendantStatus().equals(StatusDay.An.name())) {
					absentTimes++;
				} else if (attendantDayCheck.getAttendantStatus().equals(StatusDay.L.name())
						|| attendantDayCheck.getAttendantStatus().equals(StatusDay.Ln.name())
						|| attendantDayCheck.getAttendantStatus().equals(StatusDay.E.name())
						|| attendantDayCheck.getAttendantStatus().equals(StatusDay.En.name())) {
					lateEarlyLeave++;
				}
				if (attendantDayCheck.getAttendantStatus().equals(StatusDay.An.name())
						|| attendantDayCheck.getAttendantStatus().equals(StatusDay.Ln.name())
						|| attendantDayCheck.getAttendantStatus().equals(StatusDay.En.name())) {
					x++;
				}
			}
			
			double disciplinaryPoint = 0;
			double noPermissionRate = 0;
			if(x == 0 && absentTimes == 0 && lateEarlyLeave == 0 ) {
				disciplinaryPoint = 100;
			} else {
				y = absentTimes + lateEarlyLeave;
				noPermissionRate = (x / y * 100);
				
				double notPresentTime = (((lateEarlyLeave / 2) + (absentTimes / y)) * 100);
				double notAttendaceRate =  (notPresentTime / y);

				
				if (notPresentTime < 5) {
					disciplinaryPoint = 100;
				} else if (notAttendaceRate <= 20 && notAttendaceRate > 5) {
					disciplinaryPoint = 80;
				} else if (notAttendaceRate <= 30 && notAttendaceRate > 20) {
					disciplinaryPoint = 60;
				} else if (notAttendaceRate < 50 && notAttendaceRate > 30) {
					disciplinaryPoint = 50;
				} else if (notAttendaceRate > 50 || noPermissionRate < 20) {
					disciplinaryPoint = 20;
				} else {
					disciplinaryPoint = 0;
				}
			}
			
			finalAbsentTimes += absentTimes;
			finalLateEarlyLeave += lateEarlyLeave;
			finalNoPermissionRate += noPermissionRate;
			finalDisciplinaryPoint += disciplinaryPoint;

			attendanceStatusModel.setAbsentTimes((int) absentTimes);
			attendanceStatusModel.setLateEarlyLeave( (int)lateEarlyLeave);
			attendanceStatusModel.setNoPermissionRate( (int)noPermissionRate);
			attendanceStatusModel.setDisciplinaryPoint( (int) disciplinaryPoint);
			
			attendanceStatusModels.add(attendanceStatusModel);
		}
		
		finalAttendanceStatusModel.setFinalAbsentTimes(finalAbsentTimes);
		finalAttendanceStatusModel.setFinalLateEarlyLeave(finalLateEarlyLeave);
		finalAttendanceStatusModel.setFinalNoPermissionRate((int) (finalNoPermissionRate/(double) attendanceStatusModels.size()));
		finalAttendanceStatusModel.setFinalDisciplinaryPoint((int) (finalDisciplinaryPoint/(double)attendanceStatusModels.size()));
		if(attendanceStatusModels.size() == 0) {
			return attendanceStatusModels;
		} else {
			attendanceStatusModels.get(0).setFinalAttendanceStatusModel(finalAttendanceStatusModel);
			
			return attendanceStatusModels;
		}
		
	}

	public String updateAll(List<AttendantDayCheck> list) {
		
		for(AttendantDayCheck attendantDayCheck : list) {
			AttendantDayCheck attendantDayCheck2 = attendantDayCheckRepository.getOne(attendantDayCheck.getId());
			attendantDayCheck2.setDayCheck(attendantDayCheck.getDayCheck());
			attendantDayCheck2.setAttendantStatus(attendantDayCheck.getAttendantStatus());
			attendantDayCheckRepository.save(attendantDayCheck2);
		}
		
		return "Update successfully!!";
	}

}
