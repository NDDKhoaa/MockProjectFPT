package fa.mockproject.model;

import java.sql.Blob;
import java.time.LocalDate;

import fa.mockproject.entity.CV;
import fa.mockproject.entity.Candidate;
import fa.mockproject.entity.Channel;
import fa.mockproject.entity.Faculty;
import fa.mockproject.entity.Location;
import fa.mockproject.entity.Skill;
import fa.mockproject.entity.Trainee;
import fa.mockproject.entity.University;

public class TraineeCandidateProfileModel {
	private int traineeCandidateProfileId;
	private Trainee trainee;
	private Candidate candidate;
	private String fullName;
	private LocalDate applicationDate;
	private LocalDate dateOfBirth;
	private String gender;
	private LocalDate graduationYear;
	private String phone;
	private String email;
	private String type;
	private String status;
	private String foreignLanguage;
	private String level;
	private String allocationStatus;
	private String remarks;
	private String CVname;
	private long size;
	private Blob content;
	private Channel channel;
	private University university;
	private Location location;
	private Faculty faculty;
	private Skill skill;
	private CV cv;

	public TraineeCandidateProfileModel() {
		super();
	}

	public TraineeCandidateProfileModel(int traineeCandidateProfileId, Trainee trainee, Candidate candidate,
			String fullName, LocalDate applicationDate, LocalDate dateOfBirth, String gender, LocalDate graduationYear,
			String phone, String email, String type, String status, String foreignLanguage, String level,
			String allocationStatus, String remarks, String cVname, long size, Blob content, Channel channel,
			University university, Location location, Faculty faculty, Skill skill, CV cv) {
		super();
		this.traineeCandidateProfileId = traineeCandidateProfileId;
		this.trainee = trainee;
		this.candidate = candidate;
		this.fullName = fullName;
		this.applicationDate = applicationDate;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.graduationYear = graduationYear;
		this.phone = phone;
		this.email = email;
		this.type = type;
		this.status = status;
		this.foreignLanguage = foreignLanguage;
		this.level = level;
		this.allocationStatus = allocationStatus;
		this.remarks = remarks;
		CVname = cVname;
		this.size = size;
		this.content = content;
		this.channel = channel;
		this.university = university;
		this.location = location;
		this.faculty = faculty;
		this.skill = skill;
		this.cv = cv;
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

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getCVname() {
		return CVname;
	}

	public void setCVname(String cVname) {
		CVname = cVname;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Blob getContent() {
		return content;
	}

	public void setContent(Blob content) {
		this.content = content;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public CV getCv() {
		return cv;
	}

	public void setCv(CV cv) {
		this.cv = cv;
	}

	@Override
	public String toString() {
		return "TraineeCandidateProfileModel [traineeCandidateProfileId=" + traineeCandidateProfileId + ", trainee="
				+ trainee + ", candidate=" + candidate + ", fullName=" + fullName + ", applicationDate="
				+ applicationDate + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", graduationYear="
				+ graduationYear + ", phone=" + phone + ", email=" + email + ", type=" + type + ", status=" + status
				+ ", foreignLanguage=" + foreignLanguage + ", level=" + level + ", allocationStatus=" + allocationStatus
				+ ", remarks=" + remarks + ", CVname=" + CVname + ", size=" + size + ", content=" + content
				+ ", channel=" + channel + ", university=" + university + ", location=" + location + ", faculty="
				+ faculty + ", skill=" + skill + ", cv=" + cv + "]";
	}

}
