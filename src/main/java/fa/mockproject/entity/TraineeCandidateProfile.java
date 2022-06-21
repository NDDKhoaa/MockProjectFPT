package fa.mockproject.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import fa.mockproject.model.TraineeCandidateProfileModel;

@Entity
@Table(name = "TraineeCandidateProfile")
public class TraineeCandidateProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trainee_candidate_profile_id", nullable = false)
	private long traineeCandidateProfileId;

	// TraineeID
	@OneToOne
	@JoinColumn(name = "trainee_candidate_id", nullable = true, unique = true)
	private Trainee trainee;

	@OneToOne(cascade = CascadeType.MERGE)
	private Candidate candidate;

	@Column(name = "full_name", length = 255, nullable = false)
	private String fullName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date_of_birth", nullable = false)
	private LocalDate dateOfBirth;

	@Column(name = "gender", length = 255, nullable = false)
	private String gender;

	@ManyToOne
	@JoinColumn(name = "university_id", nullable = true)
	private University university;

	@ManyToOne
	@JoinColumn(name = "skill_id", nullable = true)
	private Skill skill;

	@ManyToOne
	@JoinColumn(name = "faculty_id", nullable = true)
	private Faculty faculty;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "graduation_year", nullable = true)
	private LocalDate graduationYear;

	@Column(name = "phone", nullable = false, length = 255, unique = true)
	private String phone;

	@Column(name = "email", nullable = true, length = 255, unique = true)
	private String email;

	@ManyToOne
	@JoinColumn(name = "type", nullable = true)
	private TraineeCandidateProfileType type;

	@Column(name = "foreign_language", length = 255, nullable = true)
	private String foreignLanguage;

	@Column(name = "level", length = 255, nullable = true)
	private String level;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cv_id", nullable = true)
	private CV cv;

	@Column(name = "allocation_status", length = 255, nullable = true)
	private String allocationStatus;

	@Column(name = "remarks", length = 255, nullable = true)
	private String remarks;

	public TraineeCandidateProfile() {
		super();
	}

	public long getTraineeCandidateProfileId() {
		return traineeCandidateProfileId;
	}

	public void setTraineeCandidateProfileId(long traineeCandidateProfileId) {
		this.traineeCandidateProfileId = traineeCandidateProfileId;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(LocalDate graduationYear) {
		this.graduationYear = graduationYear;
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

	public TraineeCandidateProfileType getType() {
		return type;
	}

	public void setType(TraineeCandidateProfileType type) {
		this.type = type;
	}

	public String getForeignLanguage() {
		return foreignLanguage;
	}

	public void setForeignLanguage(String foreignLanguage) {
		this.foreignLanguage = foreignLanguage;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public CV getCv() {
		return cv;
	}

	public void setCv(CV cv) {
		this.cv = cv;
	}

	public String getAllocationStatus() {
		return allocationStatus;
	}

	public void setAllocationStatus(String allocationStatus) {
		this.allocationStatus = allocationStatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public TraineeCandidateProfile(TraineeCandidateProfileModel model) {
		super();
		this.traineeCandidateProfileId = model.getTraineeCandidateProfileId();
		this.trainee = model.getTrainee();
		this.candidate = model.getCandidate();
		this.fullName = model.getFullName();
		this.dateOfBirth = model.getDateOfBirth();
		this.gender = model.getGender();
		String stringGraduationYear = model.getGraduationYear() + "-01";
		LocalDate localDateGraduationYear= LocalDate.parse(stringGraduationYear);
		this.graduationYear = localDateGraduationYear;
		this.phone = model.getPhone();
		this.email = model.getEmail();
		this.foreignLanguage = model.getForeignLanguage();
		this.level = model.getLevel();
		CV cvModel = new CV(model);
		this.cv = cvModel;
		this.allocationStatus = model.getAllocationStatus();
		this.remarks = model.getRemarks();
	}

	public TraineeCandidateProfile(TraineeCandidateProfileModel model,Candidate candidate, University university2,
			Faculty faculty2, Skill skill2, CV cv2, TraineeCandidateProfileType type2) {
		this.traineeCandidateProfileId = model.getTraineeCandidateProfileId();
		this.trainee = model.getTrainee();
		this.candidate = candidate;
		this.fullName = model.getFullName();
		this.dateOfBirth = model.getDateOfBirth();
		this.gender = model.getGender();
		String stringGraduationYear = model.getGraduationYear() + "-01";
		LocalDate localDateGraduationYear = LocalDate.parse(stringGraduationYear);
		this.graduationYear = localDateGraduationYear;
		this.phone = model.getPhone();
		this.email = model.getEmail();
		this.type = type2;
		this.foreignLanguage = model.getForeignLanguage();
		this.level = model.getLevel();
		this.cv = cv2;
		this.allocationStatus = model.getAllocationStatus();
		this.remarks = model.getRemarks();
		this.university = university2;
		this.faculty = faculty2;
		this.skill = skill2;
	}

	public TraineeCandidateProfile(TraineeCandidateProfile traineeCandidateProfile) {

		this.traineeCandidateProfileId = traineeCandidateProfile.getTraineeCandidateProfileId();
		this.fullName = traineeCandidateProfile.getFullName();
		this.dateOfBirth = traineeCandidateProfile.getDateOfBirth();
		this.gender = traineeCandidateProfile.getGender();
		this.graduationYear = traineeCandidateProfile.getGraduationYear();
		this.phone = traineeCandidateProfile.getPhone();
		this.email = traineeCandidateProfile.getEmail();
		this.foreignLanguage = traineeCandidateProfile.getForeignLanguage();
		this.level = traineeCandidateProfile.getLevel();
		this.allocationStatus = traineeCandidateProfile.getAllocationStatus();
		this.remarks = traineeCandidateProfile.getRemarks();
	}

	public TraineeCandidateProfile(TraineeCandidateProfile profile1,Candidate candidate, University university1, Faculty faculty1,
			Skill skill1, CV cv1,TraineeCandidateProfileType type1) {
		this.traineeCandidateProfileId = profile1.getTraineeCandidateProfileId();
		this.trainee = profile1.getTrainee();
		this.candidate = candidate;
		this.fullName = profile1.getFullName();
		this.dateOfBirth = profile1.getDateOfBirth();
		this.gender = profile1.getGender();
		this.graduationYear = profile1.getGraduationYear();
		this.phone = profile1.getPhone();
		this.email = profile1.getEmail();
		this.type = type1;
		this.foreignLanguage = profile1.getForeignLanguage();
		this.level = profile1.getLevel();
		this.cv = cv1;
		this.allocationStatus = profile1.getAllocationStatus();
		this.remarks = profile1.getRemarks();
		this.university = university1;
		this.faculty = faculty1;
		this.skill = skill1;
	}

	@Override
	public String toString() {
		return "TraineeCandidateProfile [traineeCandidateProfileId=" + traineeCandidateProfileId + ", fullName="
				+ fullName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", university=" + university
				+ ", faculty=" + faculty + ", graduationYear=" + graduationYear + ", phone=" + phone + ", email="
				+ email + ", type=" + type + ", skill=" + skill + ", foreignLanguage=" + foreignLanguage + ", level="
				+ level + ", cv=" + cv + ", allocationStatus=" + allocationStatus + ", remarks=" + remarks + "]";
	}

}
