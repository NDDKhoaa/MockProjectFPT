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
    @Column(name = "trainee_candidate_profile_id", nullable = false)
    private int traineeCandidateProfileId;
	
	//TraineeID
	@OneToOne
	@JoinColumn(name = "trainee_candidate_id", nullable = false, unique=true)
	private Trainee trainee;
	
	@OneToOne(mappedBy="traineeCandidateProfile", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Candidate candidate;
	
	@Column(name = "full_name", nullable = false)
	private String fullName;
	
	@Column(name = "date_of_birth", nullable = false)
	private LocalDate dateOfBirth;
	
	@Column(name = "gender", nullable = false)
	private int gender;
	
	@Column(name = "university_id", nullable = false)
	private int universityId;
	
	@Column(name = "faculty_id", nullable = false)
	private int facultyId;
	
	@Column(name = "graduation_year", nullable = false)
	private LocalDate graduationYear;
	
	@Column(name = "phone", nullable = false, unique=true)
	private long phone;
	
	@Column(name = "email", nullable = false, unique=true)
	private String email;
	
	@Column(name = "type", nullable = false)
	private int type;
	
	@Column(name = "skill", nullable = false)
	private int skill;
	
	@Column(name = "foreign_language", nullable = false)
	private int foreignLanguage;
	
	@Column(name = "level", nullable = false)
	private int level;
	
	@Column(name = "CV", nullable = false)
	private int CV;
	
	@Column(name = "allocation_status", nullable = true)
	private int allocationStatus;
	
	@Column(name = "remarks", nullable = true)
	private int remarks;

	public TraineeCandidateProfile() {
		super();
	}

	public TraineeCandidateProfile(int traineeCandidateProfileId, int fullName, LocalDate dateOfBirth, int gender,
			int universityId, int facultyId, LocalDate graduationYear, long phone, int email, int type, int skill,
			int foreignLanguage, int level, int cV, int allocationStatus, int remarks) {
		super();
		this.traineeCandidateProfileId = traineeCandidateProfileId;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.universityId = universityId;
		this.facultyId = facultyId;
		this.graduationYear = graduationYear;
		this.phone = phone;
		this.email = email;
		this.type = type;
		this.skill = skill;
		this.foreignLanguage = foreignLanguage;
		this.level = level;
		CV = cV;
		this.allocationStatus = allocationStatus;
		this.remarks = remarks;
	}

	public TraineeCandidateProfile(int traineeCandidateProfileId, Trainee trainee, int fullName, LocalDate dateOfBirth,
			int gender, int universityId, int facultyId, LocalDate graduationYear, long phone, int email, int type,
			int skill, int foreignLanguage, int level, int cV, int allocationStatus, int remarks) {
		super();
		this.traineeCandidateProfileId = traineeCandidateProfileId;
		this.trainee = trainee;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.universityId = universityId;
		this.facultyId = facultyId;
		this.graduationYear = graduationYear;
		this.phone = phone;
		this.email = email;
		this.type = type;
		this.skill = skill;
		this.foreignLanguage = foreignLanguage;
		this.level = level;
		CV = cV;
		this.allocationStatus = allocationStatus;
		this.remarks = remarks;
	}

	public int getTraineeCandidateProfileId() {
		return traineeCandidateProfileId;
	}

	public void setTraineeCandidateProfileId(int traineeCandidateProfileId) {
		this.traineeCandidateProfileId = traineeCandidateProfileId;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	public int getFullName() {
		return fullName;
	}

	public void setFullName(int fullName) {
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

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public LocalDate getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(LocalDate graduationYear) {
		this.graduationYear = graduationYear;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public int getEmail() {
		return email;
	}

	public void setEmail(int email) {
		this.email = email;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSkill() {
		return skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}

	public int getForeignLanguage() {
		return foreignLanguage;
	}

	public void setForeignLanguage(int foreignLanguage) {
		this.foreignLanguage = foreignLanguage;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getCV() {
		return CV;
	}

	public void setCV(int cV) {
		CV = cV;
	}

	public int getAllocationStatus() {
		return allocationStatus;
	}

	public void setAllocationStatus(int allocationStatus) {
		this.allocationStatus = allocationStatus;
	}

	public int getRemarks() {
		return remarks;
	}

	public void setRemarks(int remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "TraineeCandidateProfile [traineeCandidateProfileId=" + traineeCandidateProfileId + ", fullName="
				+ fullName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", universityId=" + universityId
				+ ", facultyId=" + facultyId + ", graduationYear=" + graduationYear + ", phone=" + phone + ", email="
				+ email + ", type=" + type + ", skill=" + skill + ", foreignLanguage=" + foreignLanguage + ", level="
				+ level + ", CV=" + CV + ", allocationStatus=" + allocationStatus + ", remarks=" + remarks + "]";
	}

}
