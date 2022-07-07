package fa.mockproject.model;

import java.time.LocalDate;

import fa.mockproject.entity.TrainerProfile;

public class TrainerProfileModel {
	
	private long trainerProfileId;
	private String fullName;
	private LocalDate dateOfBirth;
	private int gender;
	private String unit;
	private String major;
	private String phone;
	private String email;
	private int experience;
	private String remarks;
	
	public TrainerProfileModel() {
		super();
	}
	
	public TrainerProfileModel(long trainerProfileId, String fullName, LocalDate dateOfBirth,
			int gender, String unit, String major, String phone, String email, int experience, String remarks) {
		super();
		this.trainerProfileId = trainerProfileId;
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

	public TrainerProfileModel(TrainerProfile trainerProfile) {
		super();
		this.trainerProfileId = trainerProfile.getTrainerProfileId();
		this.fullName = trainerProfile.getFullName();
		this.dateOfBirth = trainerProfile.getDateOfBirth();
		this.gender = trainerProfile.getGender();
		this.unit = trainerProfile.getUnit();
		this.major = trainerProfile.getMajor();
		this.phone = trainerProfile.getPhone();
		this.email = trainerProfile.getEmail();
		this.experience = trainerProfile.getExperience();
		this.remarks = trainerProfile.getRemarks();
	}

	public long getTrainerProfileId() {
		return trainerProfileId;
	}

	public void setTrainerProfileId(long trainerProfileId) {
		this.trainerProfileId = trainerProfileId;
	}

	public void setTrainerModel(TrainerModel trainerModel) {
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
		return "TrainerProfileModel [trainerProfileId=" + trainerProfileId + ", fullName=" + fullName + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", unit=" + unit + ", major=" + major + ", phone=" + phone
				+ ", email=" + email + ", experience=" + experience + ", remarks=" + remarks + "]";
	}
}