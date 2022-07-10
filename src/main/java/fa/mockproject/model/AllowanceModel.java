package fa.mockproject.model;

public class AllowanceModel {
	private long milestoneId;
	private String milestoneName;
	private int gpa;
	private String level;
	private String salaryPaid;
	private long allowanceStandard;
	private String remark;

	public AllowanceModel() {
		super();
	}

	public AllowanceModel(long milestoneId, String milestoneName, int gpa, String level, String salaryPaid,
			long allowanceStandard, String remark) {
		super();
		this.milestoneId = milestoneId;
		this.milestoneName = milestoneName;
		this.gpa = gpa;
		this.level = level;
		this.salaryPaid = salaryPaid;
		this.allowanceStandard = allowanceStandard;
		this.remark = remark;
	}

	public int getGpa() {
		return gpa;
	}

	public void setGpa(int gpa) {
		this.gpa = gpa;
	}

	public long getMilestoneId() {
		return milestoneId;
	}

	public void setMilestoneId(long milestoneId) {
		this.milestoneId = milestoneId;
	}

	public String getMilestoneName() {
		return milestoneName;
	}

	public void setMilestoneName(String milestoneName) {
		this.milestoneName = milestoneName;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getSalaryPaid() {
		return salaryPaid;
	}

	public void setSalaryPaid(String salaryPaid) {
		this.salaryPaid = salaryPaid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public long getAllowanceStandard() {
		return allowanceStandard;
	}

	public void setAllowanceStandard(long allowanceStandard) {
		this.allowanceStandard = allowanceStandard;
	}

	@Override
	public String toString() {
		return "AllowanceModel [milestoneId=" + milestoneId + ", milestoneName=" + milestoneName + ", level=" + level
				+ ", salaryPaid=" + salaryPaid + ", remark=" + remark + "]";
	}

}
