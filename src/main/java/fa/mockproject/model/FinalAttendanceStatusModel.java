package fa.mockproject.model;

public class FinalAttendanceStatusModel {
	
	private int finalAbsentTimes;
	private int finalLateEarlyLeave;
	private int finalNoPermissionRate;
	private int finalDisciplinaryPoint;

	public FinalAttendanceStatusModel() {
		super();
	}

	public FinalAttendanceStatusModel(int finalAbsentTimes, int finalLateEarlyLeave, int finalNoPermissionRate,
			int finalDisciplinaryPoint) {
		super();
		this.finalAbsentTimes = finalAbsentTimes;
		this.finalLateEarlyLeave = finalLateEarlyLeave;
		this.finalNoPermissionRate = finalNoPermissionRate;
		this.finalDisciplinaryPoint = finalDisciplinaryPoint;
	}

	public int getFinalAbsentTimes() {
		return finalAbsentTimes;
	}

	public void setFinalAbsentTimes(int finalAbsentTimes) {
		this.finalAbsentTimes = finalAbsentTimes;
	}

	public int getFinalLateEarlyLeave() {
		return finalLateEarlyLeave;
	}

	public void setFinalLateEarlyLeave(int finalLateEarlyLeave) {
		this.finalLateEarlyLeave = finalLateEarlyLeave;
	}

	public int getFinalNoPermissionRate() {
		return finalNoPermissionRate;
	}

	public void setFinalNoPermissionRate(int finalNoPermissionRate) {
		this.finalNoPermissionRate = finalNoPermissionRate;
	}

	public int getFinalDisciplinaryPoint() {
		return finalDisciplinaryPoint;
	}

	public void setFinalDisciplinaryPoint(int finalDisciplinaryPoint) {
		this.finalDisciplinaryPoint = finalDisciplinaryPoint;
	}

}
