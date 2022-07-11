package fa.mockproject.model;

public class FinalAttendanceStatusModel {
	
	private Integer finalAbsentTimes;
	private Integer finalLateEarlyLeave;
	private Integer finalNoPermissionRate;
	private Integer finalDisciplinaryPoint;

	public FinalAttendanceStatusModel() {
		super();
	}

	public FinalAttendanceStatusModel(Integer finalAbsentTimes, Integer finalLateEarlyLeave, Integer finalNoPermissionRate,
			Integer finalDisciplinaryPoint) {
		super();
		this.finalAbsentTimes = finalAbsentTimes;
		this.finalLateEarlyLeave = finalLateEarlyLeave;
		this.finalNoPermissionRate = finalNoPermissionRate;
		this.finalDisciplinaryPoint = finalDisciplinaryPoint;
	}

	public Integer getFinalAbsentTimes() {
		return finalAbsentTimes;
	}

	public void setFinalAbsentTimes(Integer finalAbsentTimes) {
		this.finalAbsentTimes = finalAbsentTimes;
	}

	public Integer getFinalLateEarlyLeave() {
		return finalLateEarlyLeave;
	}

	public void setFinalLateEarlyLeave(Integer finalLateEarlyLeave) {
		this.finalLateEarlyLeave = finalLateEarlyLeave;
	}

	public int getFinalNoPermissionRate() {
		return finalNoPermissionRate;
	}

	public void setFinalNoPermissionRate(Integer finalNoPermissionRate) {
		this.finalNoPermissionRate = finalNoPermissionRate;
	}

	public int getFinalDisciplinaryPoint() {
		return finalDisciplinaryPoint;
	}

	public void setFinalDisciplinaryPoint(Integer finalDisciplinaryPoint) {
		this.finalDisciplinaryPoint = finalDisciplinaryPoint;
	}

	@Override
	public String toString() {
		return "FinalAttendanceStatusModel [finalAbsentTimes=" + finalAbsentTimes + ", finalLateEarlyLeave="
				+ finalLateEarlyLeave + ", finalNoPermissionRate=" + finalNoPermissionRate + ", finalDisciplinaryPoint="
				+ finalDisciplinaryPoint + "]";
	}
	
	
}
