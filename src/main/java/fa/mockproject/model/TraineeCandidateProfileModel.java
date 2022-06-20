package fa.mockproject.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

import fa.mockproject.entity.CV;
import fa.mockproject.entity.Candidate;
import fa.mockproject.entity.Channel;
import fa.mockproject.entity.Faculty;
import fa.mockproject.entity.Location;
import fa.mockproject.entity.Skill;
import fa.mockproject.entity.Trainee;
import fa.mockproject.entity.TraineeCandidateProfile;
import fa.mockproject.entity.TraineeCandidateProfileStatus;
import fa.mockproject.entity.TraineeCandidateProfileType;
import fa.mockproject.entity.University;

public class TraineeCandidateProfileModel {
	private long traineeCandidateProfileId;
	private Trainee trainee;
	private String fullName;
	private Date applicationDate = new Date(System.currentTimeMillis());
	private Date dateOfBirth;
	private String gender;
	private String graduationYear;
	private String phone;
	private String email;
	private String foreignLanguage;
	private String level;
	private String allocationStatus;
	private String remarks;

	private Candidate candidate;

	private String statusId = "TP";
	private String statusName;
	private TraineeCandidateProfileStatus status;

	private String typeId = "Candidate";
	private String typeName;
	private TraineeCandidateProfileType type;

	private String channelId;
	private Channel channel;
	private String channelName;
	private Set<Channel> channellist;

	private String universityId;
	private String universityName;
	private University university;

	private String locationId;
	private String locationName;
	private Location location;
	private Set<Location> locationlist;

	private String facultyId;
	private String facultyName;
	private Faculty faculty;

	private String skillId;
	private String skillName;
	private Skill skill;

	private String CVname;
	private long size;
	private byte[] content;
	private CV cv;

	public TraineeCandidateProfileModel() {
		super();
	}

	public TraineeCandidateProfileModel(TraineeCandidateProfile profile, Candidate candidate,
			TraineeCandidateProfileStatus status2, TraineeCandidateProfileType type2, University university2,
			Faculty faculty2, Location location2, Skill skill2, Channel channel2, CV cv2) {
		super();
		this.traineeCandidateProfileId = profile.getTraineeCandidateProfileId();
		this.fullName = profile.getFullName();
		LocalDate localDateApplicationDate = candidate.getApplicationDate();
		Date dateApplicationDate = Date.from(localDateApplicationDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		this.applicationDate = dateApplicationDate;
		LocalDate localDateDateOfBirth = candidate.getApplicationDate();
		Date dateDateOfBirth = Date.from(localDateDateOfBirth.atStartOfDay(ZoneId.systemDefault()).toInstant());
		this.dateOfBirth = dateDateOfBirth;
		this.gender = profile.getGender();
		LocalDate localDateGraduationYear = candidate.getApplicationDate();
		Date dateGraduationYear = Date.from(localDateGraduationYear.atStartOfDay(ZoneId.systemDefault()).toInstant());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		String stringGraduationYear = formatter.format(dateGraduationYear);
		this.graduationYear = stringGraduationYear;
		this.phone = profile.getPhone();
		this.email = profile.getEmail();
		this.foreignLanguage = profile.getForeignLanguage();
		this.level = profile.getLevel();
		this.allocationStatus = profile.getAllocationStatus();
		this.remarks = profile.getRemarks();
		this.candidate = candidate;
		this.status = status2;
		this.statusName=status2.getStatus();
		this.channelName=channel2.getChannelName();
		this.type = type2;
		this.typeName=type2.getType();
		this.channel = channel2;
		this.university = university2;
		this.universityName=university2.getUniversityName();
		this.location = location2;
		this.locationName=location2.getLocationName();
		this.faculty = faculty2;
		this.facultyName=faculty2.getFacultyName();
		this.skill = skill2;
		this.skillName=skill2.getSkillName();
		this.cv = cv2;
		this.CVname=cv2.getName();
		this.content=cv2.getContent();
		this.size=cv2.getSize();
	}

	public TraineeCandidateProfileModel(long traineeCandidateProfileId, Trainee trainee, Candidate candidate,
			String fullName, Date applicationDate, Date dateOfBirth, String gender, String graduationYear, String phone,
			String email, String foreignLanguage, String level, String allocationStatus, String remarks,
			String statusId, TraineeCandidateProfileStatus status, String typeId, TraineeCandidateProfileType type,
			String channelId, Channel channel, Set<Channel> channellist, String universityId, University university,
			String locationId, Location location, Set<Location> locationlist, String facultyId, Faculty faculty,
			String skillId, Skill skill, String cVname, long size, byte[] content, CV cv) {
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
		this.foreignLanguage = foreignLanguage;
		this.level = level;
		this.allocationStatus = allocationStatus;
		this.remarks = remarks;
		this.statusId = statusId;
		this.status = status;
		this.typeId = typeId;
		this.type = type;
		this.channelId = channelId;
		this.channel = channel;
		this.channellist = channellist;
		this.universityId = universityId;
		this.university = university;
		this.locationId = locationId;
		this.location = location;
		this.locationlist = locationlist;
		this.facultyId = facultyId;
		this.faculty = faculty;
		this.skillId = skillId;
		this.skill = skill;
		CVname = cVname;
		this.size = size;
		this.content = content;
		this.cv = cv;
	}
	
	

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public TraineeCandidateProfileStatus getStatus() {
		return status;
	}

	public void setStatus(TraineeCandidateProfileStatus status) {
		this.status = status;
	}

	public TraineeCandidateProfileType getType() {
		return type;
	}

	public void setType(TraineeCandidateProfileType type) {
		this.type = type;
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

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(String graduationYear) {
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

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
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

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public Set<Channel> getChannellist() {
		return channellist;
	}

	public void setChannellist(Set<Channel> channellist) {
		this.channellist = channellist;
	}

	public String getUniversityId() {
		return universityId;
	}

	public void setUniversityId(String universityId) {
		this.universityId = universityId;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Set<Location> getLocationlist() {
		return locationlist;
	}

	public void setLocationlist(Set<Location> locationlist) {
		this.locationlist = locationlist;
	}

	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public String getSkillId() {
		return skillId;
	}

	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
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

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
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
				+ graduationYear + ", phone=" + phone + ", email=" + email + ", typeId=" + typeId + ", statusId="
				+ statusId + ", foreignLanguage=" + foreignLanguage + ", level=" + level + ", allocationStatus="
				+ allocationStatus + ", remarks=" + remarks + ", channelId=" + channelId + ", channel=" + channel
				+ ", channellist=" + channellist + ", universityId=" + universityId + ", university=" + university
				+ ", locationId=" + locationId + ", location=" + location + ", locationlist=" + locationlist
				+ ", facultyId=" + facultyId + ", faculty=" + faculty + ", skillId=" + skillId + ", skill=" + skill
				+ ", CVname=" + CVname + ", size=" + size + ", content=" + Arrays.toString(content) + ", cv=" + cv
				+ "]";
	}

}
