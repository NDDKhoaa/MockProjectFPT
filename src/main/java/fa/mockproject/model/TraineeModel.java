package fa.mockproject.model;


public class TraineeModel {
	private long id;
	private String account;
	private String fullName;
	private String status;
	private String allocationStatus;
	private String gender;
	private String universityName;
	private String falcutyName;
	private String phone;
	private String email;
	private boolean salaryPaid;
	private String allowanceGroup;
	private String history;
	private String TPBAccount;
	private String commitment;
//	private Trainer trainer;
	
	public TraineeModel() {
		super();
	}
	
	public TraineeModel(long id, String account, String fullName, String status, String allocationStatus, String gender,
			String universityName, String falcutyName, String phone, String email, boolean salaryPaid,
			String allowanceGroup, String history, String tPBAccount, String commitment/* , Trainer trainer */) {
		super();
		this.id = id;
		this.account = account;
		this.fullName = fullName;
		this.status = status;
		this.allocationStatus = allocationStatus;
		this.gender = gender;
		this.universityName = universityName;
		this.falcutyName = falcutyName;
		this.phone = phone;
		this.email = email;
		this.salaryPaid = salaryPaid;
		this.allowanceGroup = allowanceGroup;
		this.history = history;
		TPBAccount = tPBAccount;
		this.commitment = commitment;
//		this.trainer = trainer;
	}

//	public Trainer getTrainer() {
//		return trainer;
//	}
//
//	public void setTrainer(Trainer trainer) {
//		this.trainer = trainer;
//	}

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getAccount() {
		return account;
	}



	public void setAccount(String account) {
		this.account = account;
	}



	public String getFullName() {
		return fullName;
	}



	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getAllocationStatus() {
		return allocationStatus;
	}



	public void setAllocationStatus(String allocationStatus) {
		this.allocationStatus = allocationStatus;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getUniversityName() {
		return universityName;
	}



	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}



	public String getFalcutyName() {
		return falcutyName;
	}



	public void setFalcutyName(String falcutyName) {
		this.falcutyName = falcutyName;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String string) {
		this.phone = string;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public boolean isSalaryPaid() {
		return salaryPaid;
	}



	public void setSalaryPaid(boolean salaryPaid) {
		this.salaryPaid = salaryPaid;
	}



	public String getAllowanceGroup() {
		return allowanceGroup;
	}



	public void setAllowanceGroup(String allowanceGroup) {
		this.allowanceGroup = allowanceGroup;
	}



	public String getHistory() {
		return history;
	}



	public void setHistory(String history) {
		this.history = history;
	}



	public String getTPBAccount() {
		return TPBAccount;
	}



	public void setTPBAccount(String tPBAccount) {
		TPBAccount = tPBAccount;
	}



	public String getCommitment() {
		return commitment;
	}



	public void setCommitment(String commitment) {
		this.commitment = commitment;
	}



	@Override
	public String toString() {
		return "TraineeModel [id=" + id + ", account=" + account + ", fullName=" + fullName + ", status=" + status
				+ ", allocationStatus=" + allocationStatus + ", gender=" + gender + ", universityName=" + universityName
				+ ", falcutyName=" + falcutyName + ", phone=" + phone + ", email=" + email + ", salaryPaid="
				+ salaryPaid + ", allowanceGroup=" + allowanceGroup + ", history=" + history + ", TPBAccount="
				+ TPBAccount + ", commitment=" + commitment + "]";
	}
	
	
	
}
