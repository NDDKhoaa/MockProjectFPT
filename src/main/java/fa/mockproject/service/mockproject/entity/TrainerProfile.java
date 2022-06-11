package fa.mockproject.service.mockproject.entity;

import fa.mockproject.entity.Trainer;

import java.time.LocalDate;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TrainerProfile")
@Cacheable
public class TrainerProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int trainerprofile_id;
	
	@OneToOne
	@JoinColumn(name = "trainer_id", nullable = false)
	private Trainer trainer_id;
	
	@Column(name= "fullname")
	private String fullname;
	
	@Column(name="date_of_birth")
	private LocalDate date_of_birth;
	
	@Column(name= "gender")
	private int gender;
	
	@Column(name= "unit")
	private int unit;
	
	@Column(name= "major")
	private int major;
	
	@Column(name= "phone")
	private int phone;
	
	@Column(name= "email")
	private String email;
	

	@Column(name= "experience")
	private int experience;
	
	@Column(name= "remarks")
	private int remarks;

	public int getTrainerprofile_id() {
		return trainerprofile_id;
	}

	public void setTrainerprofile_id(int trainerprofile_id) {
		this.trainerprofile_id = trainerprofile_id;
	}

	public Trainer getTrainer_id() {
		return trainer_id;
	}

	public void setTrainer_id(Trainer trainer_id) {
		this.trainer_id = trainer_id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public LocalDate getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(LocalDate date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public int getMajor() {
		return major;
	}

	public void setMajor(int major) {
		this.major = major;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
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

	public int getRemarks() {
		return remarks;
	}

	public void setRemarks(int remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "TrainerProfile [trainerprofile_id=" + trainerprofile_id + ", trainer_id=" + trainer_id + ", fullname="
				+ fullname + ", gender=" + gender + ", unit=" + unit + ", major=" + major + ", phone=" + phone
				+ ", email=" + email + ", experience=" + experience + ", remarks=" + remarks + "]";
	}

	public TrainerProfile(int trainerprofile_id, Trainer trainer_id, String fullname, LocalDate date_of_birth,
			int gender, int unit, int major, int phone, String email, int experience, int remarks) {
		super();
		this.trainerprofile_id = trainerprofile_id;
		this.trainer_id = trainer_id;
		this.fullname = fullname;
		this.date_of_birth = date_of_birth;
		this.gender = gender;
		this.unit = unit;
		this.major = major;
		this.phone = phone;
		this.email = email;
		this.experience = experience;
		this.remarks = remarks;
	}
	
	
	
}
