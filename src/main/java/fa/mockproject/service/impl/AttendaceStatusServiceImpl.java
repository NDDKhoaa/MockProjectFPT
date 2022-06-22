package fa.mockproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.AttendantDayCheck;
import fa.mockproject.entity.Milestone;
import fa.mockproject.entity.enumtype.StatusDay;
import fa.mockproject.model.AttendanceStatusModel;
import fa.mockproject.repository.AttendantDayCheckRepository;
import fa.mockproject.service.AttendaceStatusService;

@Service
public class AttendaceStatusServiceImpl implements AttendaceStatusService {

	@Autowired
	AttendantDayCheckRepository attendantDayCheckRepository;

	public List<AttendanceStatusModel> getAttendaceStatusModels(List<Milestone> milestones) {
		List<AttendanceStatusModel> attendanceStatusModels = new ArrayList<AttendanceStatusModel>();
		for (Milestone milestone : milestones) {

			AttendanceStatusModel attendanceStatusModel = new AttendanceStatusModel();
			attendanceStatusModel.setMilestone(milestone);

			List<AttendantDayCheck> attendantDayChecks = milestone.getAttendantDayChecks();
			int absentTimes = 0;
			int lateEarlyLeave = 0;
			int x = 0;
			int y = 0;
			for (AttendantDayCheck attendantDayCheck : attendantDayChecks) {
				if (attendantDayCheck.getAttendantStatus().equals(StatusDay.A)
						|| attendantDayCheck.getAttendantStatus().equals(StatusDay.An)) {
					absentTimes++;
				} else if (attendantDayCheck.getAttendantStatus().equals(StatusDay.L)
						|| attendantDayCheck.getAttendantStatus().equals(StatusDay.Ln)
						|| attendantDayCheck.getAttendantStatus().equals(StatusDay.E)
						|| attendantDayCheck.getAttendantStatus().equals(StatusDay.En)) {
					lateEarlyLeave++;
				}
				if (attendantDayCheck.getAttendantStatus().equals(StatusDay.An)
						|| attendantDayCheck.getAttendantStatus().equals(StatusDay.Ln)
						|| attendantDayCheck.getAttendantStatus().equals(StatusDay.En)) {
					x++;
				}
			}
			int disciplinaryPoint = 0;
			y = absentTimes + lateEarlyLeave;
			int noPermissionRate = x / y * 100;
			int attendanceCheckTimes = attendantDayChecks.size() - (y);
			int notPresentTime = ((lateEarlyLeave / 2) + (absentTimes / attendanceCheckTimes)) * 100;
			int notAttendaceRate = (notPresentTime / attendanceCheckTimes) * 100;
			
			if (notPresentTime < 5) {
				disciplinaryPoint = 100;
			} else if (notAttendaceRate <= 20 && notAttendaceRate > 5) {
				disciplinaryPoint = 80;
			} else if (notAttendaceRate <= 30 && notAttendaceRate > 20) {
				disciplinaryPoint = 60;
			} else if (notAttendaceRate < 50 && notAttendaceRate > 30) {
				disciplinaryPoint = 50;
			} else if (notAttendaceRate > 50 || noPermissionRate < 20) {
				disciplinaryPoint = 0;
			}
			
			attendanceStatusModel.setAbsentTimes(absentTimes);
			attendanceStatusModel.setLateEarlyLeave(lateEarlyLeave);
			attendanceStatusModel.setDisciplinaryPoint(disciplinaryPoint);
			
			attendanceStatusModels.add(attendanceStatusModel);
		}
		return attendanceStatusModels;
	}

}
