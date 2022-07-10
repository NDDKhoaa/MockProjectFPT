package fa.mockproject.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import fa.mockproject.entity.Trainee;

public class TraineeModel {
	private long id;
	private String account;
	private String fullName;
	private String status;
	private String allocationStatus;
	private String gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dayOfBirth;
	private String universityName;
	private String falcutyName;
	private String phone;
	private String email;
	private String salaryPaid;
	private String allowanceGroup;
	private String history;
	private String tpbAccount;
	private String commitment;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate endDate; 
//	private Trainer trainer;

	public TraineeModel() {
		super();
	}

	public TraineeModel(long id, String account, String fullName, String status, String allocationStatus, String gender,
			LocalDate dayOfBirth, String universityName, String falcutyName, String phone, String email,
			String salaryPaid, String allowanceGroup, String history, String tPBAccount,
			String commitment/*
								 * , Trainer trainer
								 */) {
		super();
		this.id = id;
		this.account = account;
		this.fullName = fullName;
		this.status = status;
		this.allocationStatus = allocationStatus;
		this.gender = gender;
		this.dayOfBirth = dayOfBirth;
		this.universityName = universityName;
		this.falcutyName = falcutyName;
		this.phone = phone;
		this.email = email;
		this.salaryPaid = salaryPaid;
		this.allowanceGroup = allowanceGroup;
		this.history = history;
		this.tpbAccount = tPBAccount;
		this.commitment = commitment;
//		this.trainer = trainer;
	}



	public TraineeModel(Trainee trainee) {
		super();
		this.id = trainee.getTraineeCandidateId();
		this.gender = trainee.getTraineeCandidateProfile().getGender();
		this.fullName = trainee.getTraineeCandidateProfile().getFullName();
		this.dayOfBirth = trainee.getTraineeCandidateProfile().getDateOfBirth();
		this.account = trainee.getTraineeCandidateProfile().getAccount().getAccount();
		this.universityName = trainee.getTraineeCandidateProfile().getUniversity().getUniversityName();
		this.falcutyName = trainee.getTraineeCandidateProfile().getFaculty().getFacultyName();
		this.phone = trainee.getTraineeCandidateProfile().getPhone();
		this.email = trainee.getTraineeCandidateProfile().getEmail();
		this.salaryPaid = trainee.getMilestones().get(0).getSalaryPaid();
		this.tpbAccount = trainee.getTpbankAccount();
		this.commitment = trainee.getCommitment().getCommittedWorkingDuration().toString();
		this.endDate = trainee.getCommitment().getCommittedWorkingEndDate();
		this.allocationStatus = trainee.getAllocation().getAllocationStatus();
		this.allowanceGroup = trainee.getAllowanceGroup() == null ? "" : trainee.getAllowanceGroup().getAllowanceGroupName();
	}
	
//	public Trainer getTrainer() {
//		return trainer;
//	}
//
//
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

	public LocalDate getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(LocalDate localDate) {
		this.dayOfBirth = localDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalaryPaid() {
		return salaryPaid;
	}

	public void setSalaryPaid(String salaryPaid) {
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

	public String getTpbAccount() {
		return tpbAccount;
	}

	public void setTpbAccount(String tpbAccount) {
		this.tpbAccount = tpbAccount;
	}

	public String getCommitment() {
		return commitment;
	}

	public void setCommitment(String commitment) {
		this.commitment = commitment;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "TraineeModel [id=" + id + ", account=" + account + ", fullName=" + fullName + ", status=" + status
				+ ", allocationStatus=" + allocationStatus + ", gender=" + gender + ", universityName=" + universityName
				+ ", falcutyName=" + falcutyName + ", phone=" + phone + ", email=" + email + ", salaryPaid="
				+ salaryPaid + ", allowanceGroup=" + allowanceGroup + ", history=" + history + ", TPBAccount="
				+ tpbAccount + ", commitment=" + commitment + "]";
	}
}
