package fa.mockproject.model;

import java.util.ArrayList;
import java.util.List;

import fa.mockproject.entity.AttendantDayCheck;
import fa.mockproject.entity.Milestone;

public class MilestoneAttendanceStatusModel {
	private List<AttendantDayCheck> attendantDayChecks = new ArrayList<AttendantDayCheck>();
	
	
	
	public void addAttendantDayCheck (AttendantDayCheck attendantDayCheck) {
		this.attendantDayChecks.add(attendantDayCheck);
	}

	public List<AttendantDayCheck> getAttendantDayChecks() {
		return attendantDayChecks;
	}

	public void setAttendantDayChecks(List<AttendantDayCheck> attendantDayChecks) {
		this.attendantDayChecks = attendantDayChecks;
	}
	
	
}
