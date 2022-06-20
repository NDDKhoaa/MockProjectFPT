package fa.mockproject.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fa.mockproject.model.TrainerModel;

@Entity
@Table(name = "TrainerProfile")
@Cacheable
public class TrainerProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "trainer_profile_id")
	private long trainerProfileId;
	
	@OneToMany(mappedBy = "trainerProfile", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Trainer> trainers;
	
	@Column(name = "account", length = 255, nullable = false)
	private String account;
	
	@Column(name = "full_name", length = 255, nullable = false)
	private String fullName;

	@Column(name = "date_of_birth", nullable = false)
	private LocalDate dateOfBirth;

	@Column(name = "gender", nullable = false)
	private int gender;

	@Column(name = "unit", length = 255, nullable = false)
	private String unit;

	@Column(name = "major", length = 255, nullable = false)
	private String major;

	@Column(name = "phone", length = 255, nullable = false)
	private String phone;

	@Column(name = "email", length = 255, nullable = false)
	private String email;

	@Column(name = "experience", nullable = false)
	private int experience;

	@Column(name = "remarks", length = 255, nullable = false)
	private String remarks;

	public TrainerProfile() {
		super();
	}

	public TrainerProfile(long trainerProfileId, List<Trainer> trainers, String account, String fullName,
			LocalDate dateOfBirth, int gender, String unit, String major, String phone, String email, int experience,
			String remarks) {
		super();
		this.trainerProfileId = trainerProfileId;
		this.trainers = trainers;
		this.account = account;
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

	public TrainerProfile(TrainerModel trainerModel) {
		super();
		this.trainerProfileId = trainerModel.getTrainerProfileId();
		this.account = trainerModel.getAccount();
		this.fullName = trainerModel.getFullName();
		this.dateOfBirth = trainerModel.getDateOfBirth();
		this.gender = trainerModel.getGender();
		this.unit = trainerModel.getUnit();
		this.major = trainerModel.getMajor();
		this.phone = trainerModel.getPhone();
		this.email = trainerModel.getEmail();
		this.experience = trainerModel.getExperience();
		this.remarks = trainerModel.getRemarks();
	}

	public long getTrainerProfileId() {
		return trainerProfileId;
	}

	public void setTrainerProfileId(long trainerProfileId) {
		this.trainerProfileId = trainerProfileId;
	}

	public List<Trainer> getTrainers() {
		return trainers;
	}

	public void setTrainers(List<Trainer> trainers) {
		this.trainers = trainers;
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
		return "TrainerProfile [trainerProfileId=" + trainerProfileId + ", fullName=" + fullName + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", unit=" + unit + ", major=" + major + ", phone=" + phone
				+ ", email=" + email + ", experience=" + experience + ", remarks=" + remarks + "]";
	}

}
