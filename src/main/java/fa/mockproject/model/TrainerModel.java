package fa.mockproject.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import fa.mockproject.entity.Trainer;
import fa.mockproject.entity.TrainerProfile;
import fa.mockproject.entity.enumtype.TrainerTypeEnum;

public class TrainerModel {

	private long trainerId;
	private long trainerProfileId;
	private TrainerTypeEnum type;
	private String account;
	private String fullName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
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

	public TrainerModel(long trainerId, long trainerProfileId, TrainerTypeEnum type, String account, String fullName,
			LocalDate dateOfBirth, int gender, String unit, String major, String phone, String email, int experience,
			String remarks) {
		super();
		this.trainerId = trainerId;
		this.trainerProfileId = trainerProfileId;
		this.type = type;
		this.account = account;
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
	
	public TrainerModel(TrainerProfile trainerProfile) {
		super();
		this.trainerProfileId = trainerProfile.getTrainerProfileId();
		this.account = trainerProfile.getAccount();
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

	public TrainerModel(Trainer trainer) {
		super();
		this.trainerId = trainer.getTrainerId();
		this.type = trainer.getType();
		this.remarks = trainer.getRemarks();
		this.trainerProfileId = trainer.getTrainerProfile().getTrainerProfileId();
		this.account = trainer.getTrainerProfile().getAccount();
		this.fullName = trainer.getTrainerProfile().getFullName();
		this.dateOfBirth = trainer.getTrainerProfile().getDateOfBirth();
		this.gender = trainer.getTrainerProfile().getGender();
		this.unit = trainer.getTrainerProfile().getUnit();
		this.major = trainer.getTrainerProfile().getMajor();
		this.phone = trainer.getTrainerProfile().getPhone();
		this.email = trainer.getTrainerProfile().getEmail();
		this.experience = trainer.getTrainerProfile().getExperience();
		this.remarks = trainer.getTrainerProfile().getRemarks();
	}

	public long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(long trainerId) {
		this.trainerId = trainerId;
	}

	public long getTrainerProfileId() {
		return trainerProfileId;
	}

	public void setTrainerProfileId(long trainerProfileId) {
		this.trainerProfileId = trainerProfileId;
	}

	public TrainerTypeEnum getType() {
		return type;
	}

	public void setType(TrainerTypeEnum type) {
		this.type = type;
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
		return "TrainerModel [trainerId=" + trainerId + ", trainerProfileId=" + trainerProfileId + ", type=" + type
				+ ", account=" + account + ", fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + ", gender="
				+ gender + ", unit=" + unit + ", major=" + major + ", phone=" + phone + ", email=" + email
				+ ", experience=" + experience + ", remarks=" + remarks + "]";
	}



}
