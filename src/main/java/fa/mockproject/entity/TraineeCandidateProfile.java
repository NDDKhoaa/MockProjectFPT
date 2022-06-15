package fa.mockproject.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TraineeCandidateProfile")
public class TraineeCandidateProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "trainee_candidate_profile_id")
	private long traineeCandidateProfileId;

	// TraineeID
	@OneToOne
	@JoinColumn(name = "trainee_candidate_id", nullable = false, unique = true)
	private Trainee trainee;

	@OneToOne(mappedBy = "traineeCandidateProfile", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Candidate candidate;


	@Column(name = "full_name", length = 255, nullable = false)
	private String fullName;

	@Column(name = "date_of_birth", nullable = false)
	private LocalDate dateOfBirth;

	@Column(name = "gender", nullable = false)
	private String gender;

	@OneToOne
	@JoinColumn(name = "university_id", nullable = false)
	private University university;

	@OneToOne
	@JoinColumn(name = "faculty_id", nullable = false)
	private Faculty faculty;

	@Column(name = "graduation_year", nullable = false)
	private LocalDate graduationYear;

	@Column(name = "phone", nullable = false,length = 255, unique = true)
	private String phone;

	@Column(name = "email", nullable = false, length = 255, unique = true)
	private String email;

	@Column(name = "type", length = 255, nullable = false)
	private String type;

	@Column(name = "skill", length = 255, nullable = false)
	private String skill;

	@Column(name = "foreign_language", length = 255, nullable = false)
	private String foreignLanguage;

	@Column(name = "level", length = 255, nullable = false)
	private String level;

	@OneToOne
	@JoinColumn(name = "cv_id", nullable = false)
	private CV cv;

	@Column(name = "allocation_status", length = 255, nullable = true)
	private String allocationStatus;

	@Column(name = "remarks", length = 255, nullable = true)
	private String remarks;

	public TraineeCandidateProfile() {
		super();
	}

	
	public TraineeCandidateProfile(long traineeCandidateProfileId, Trainee trainee,
			Candidate candidate, String fullName,
			LocalDate dateOfBirth, String gender,
			University university, Faculty faculty, LocalDate graduationYear,
			String phone, String email, String type, String skill, String foreignLanguage,
			String level, CV cv,
			String allocationStatus, String remarks) {
		super();
		this.traineeCandidateProfileId = traineeCandidateProfileId;
		this.trainee = trainee;
		this.candidate = candidate;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.university = university;
		this.faculty = faculty;
		this.graduationYear = graduationYear;
		this.phone = phone;
		this.email = email;
		this.type = type;
		this.skill = skill;
		this.foreignLanguage = foreignLanguage;
		this.level = level;
		this.cv = cv;
		this.allocationStatus = allocationStatus;
		this.remarks = remarks;
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

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
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

	@Override
	public String toString() {
		return "TraineeCandidateProfile [traineeCandidateProfileId=" + traineeCandidateProfileId + ", fullName="
				+ fullName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", university=" + university
				+ ", faculty=" + faculty + ", graduationYear=" + graduationYear + ", phone=" + phone + ", email="
				+ email + ", type=" + type + ", skill=" + skill + ", foreignLanguage=" + foreignLanguage + ", level="
				+ level + ", cv=" + cv + ", allocationStatus=" + allocationStatus + ", remarks=" + remarks + "]";
	}

}
