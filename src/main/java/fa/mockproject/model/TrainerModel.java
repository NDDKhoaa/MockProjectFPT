package fa.mockproject.model;

import java.time.LocalDate;

public class TrainerModel {
	
	private long trainerId;
	private String type;
	private String fullName;
	private LocalDate dateOfBirth;
	private int gender;
	private String unit;
	private String major;
	private String phone;
	private String email;
	private int experience;
	private String remarks;
	
	public TrainerModel() {
		super();
	}

	public TrainerModel(long trainerId, String type, String fullName, LocalDate dateOfBirth, int gender, String unit,
			String major, String phone, String email, int experience, String remarks) {
		super();
		this.trainerId = trainerId;
		this.type = type;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.unit = unit;
		this.major = major;
		this.phone = phone;
		this.email = email;
		this.experience = experience;
		this.remarks = remarks;
	}

	public long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(long trainerId) {
		this.trainerId = trainerId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
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

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "TrainerModel [trainerId=" + trainerId + ", type=" + type + ", fullName=" + fullName + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", unit=" + unit + ", major=" + major + ", phone=" + phone
				+ ", email=" + email + ", experience=" + experience + ", remarks=" + remarks + "]";
	}
	
}
