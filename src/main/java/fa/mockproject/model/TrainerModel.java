package fa.mockproject.model;

import java.time.LocalDate;

import fa.mockproject.entity.Trainer;
import fa.mockproject.entity.enumtype.TrainerType;

public class TrainerModel {

	private long trainerId;
	private TrainerType trainerType;
	private long trainerProfileId;
	private String fullName;
	private LocalDate dateOfBirth;
	private int gender;
	private String unit;
	private String major;
	private String phone;
	private String email;
	private int experience;
	private String account;
	private String remarks;

	public TrainerModel() {
		super();
	}

	public TrainerModel(long trainerId, TrainerType trainerType, long trainerProfileId, String fullName,
			LocalDate dateOfBirth, int gender, String unit, String major, String phone, String email, int experience,
			String account, String remarks) {
		super();
		this.trainerId = trainerId;
		this.trainerType = trainerType;
		this.trainerProfileId = trainerProfileId;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.unit = unit;
		this.major = major;
		this.phone = phone;
		this.email = email;
		this.experience = experience;
		this.account = account;
		this.remarks = remarks;
	}

	public TrainerModel(Trainer trainer) {
		super();
		this.trainerId = trainer.getTrainerId();
		this.trainerType = trainer.getTrainerType();
		this.trainerProfileId = trainer.getTrainerProfile().getTrainerProfileId();
		this.fullName = trainer.getTrainerProfile().getFullName();
		this.dateOfBirth = trainer.getTrainerProfile().getDateOfBirth();
		this.gender = trainer.getTrainerProfile().getGender();
		this.unit = trainer.getTrainerProfile().getUnit();
		this.major = trainer.getTrainerProfile().getMajor();
		this.phone = trainer.getTrainerProfile().getPhone();
		this.email = trainer.getTrainerProfile().getEmail();
		this.experience = trainer.getTrainerProfile().getExperience();
		this.account = trainer.getTrainerProfile().getAccount();
		this.remarks = trainer.getRemarks();
	}

	public long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(long trainerId) {
		this.trainerId = trainerId;
	}

	public TrainerType getTrainerType() {
		return trainerType;
	}

	public void setTrainerType(TrainerType trainerType) {
		this.trainerType = trainerType;
	}

	public long getTrainerProfileId() {
		return trainerProfileId;
	}

	public void setTrainerProfileId(long trainerProfileId) {
		this.trainerProfileId = trainerProfileId;
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "TrainerModel [trainerId=" + trainerId + ", trainerType=" + trainerType + ", trainerProfileId="
				+ trainerProfileId + ", fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", unit=" + unit + ", major=" + major + ", phone=" + phone + ", email=" + email + ", experience="
				+ experience + ", account=" + account + ", remarks=" + remarks + "]";
	}



}
