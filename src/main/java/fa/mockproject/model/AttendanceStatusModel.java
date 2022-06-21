package fa.mockproject.model;

import java.util.List;

import fa.mockproject.entity.AttendantDayCheck;
import fa.mockproject.entity.Milestone;

public class AttendanceStatusModel {
	
	private int absentTimes;
	private int LateEarlyLeave;
	private int noPermissionRate;
	private int disciplinaryPoint;
	private Milestone milestone;
	private List<AttendantDayCheck> attendantDayChecks;

	public AttendanceStatusModel() {
		super();
	}

	public AttendanceStatusModel(int absentTimes, int lateEarlyLeave, int noPermissionRate, int disciplinaryPoint,
			Milestone milestone, List<AttendantDayCheck> attendantDayChecks) {
		super();
		this.absentTimes = absentTimes;
		LateEarlyLeave = lateEarlyLeave;
		this.noPermissionRate = noPermissionRate;
		this.disciplinaryPoint = disciplinaryPoint;
		this.milestone = milestone;
		this.attendantDayChecks = attendantDayChecks;
	}

	public int getAbsentTimes() {
		return absentTimes;
	}

	public void setAbsentTimes(int absentTimes) {
		this.absentTimes = absentTimes;
	}

	public int getLateEarlyLeave() {
		return LateEarlyLeave;
	}

	public void setLateEarlyLeave(int lateEarlyLeave) {
		LateEarlyLeave = lateEarlyLeave;
	}

	public int getNoPermissionRate() {
		return noPermissionRate;
	}

	public void setNoPermissionRate(int noPermissionRate) {
		this.noPermissionRate = noPermissionRate;
	}

	public int getDisciplinaryPoint() {
		return disciplinaryPoint;
	}

	public void setDisciplinaryPoint(int disciplinaryPoint) {
		this.disciplinaryPoint = disciplinaryPoint;
	}

	public Milestone getMilestone() {
		return milestone;
	}

	public void setMilestone(Milestone milestone) {
		this.milestone = milestone;
	}

	public List<AttendantDayCheck> getAttendantDayChecks() {
		return attendantDayChecks;
	}

	public void setAttendantDayChecks(List<AttendantDayCheck> attendantDayChecks) {
		this.attendantDayChecks = attendantDayChecks;
	}

	@Override
	public String toString() {
		return "AttendaceStatus [absentTimes=" + absentTimes + ", LateEarlyLeave=" + LateEarlyLeave
				+ ", noPermissionRate=" + noPermissionRate + ", disciplinaryPoint=" + disciplinaryPoint + "]";
	}

}
