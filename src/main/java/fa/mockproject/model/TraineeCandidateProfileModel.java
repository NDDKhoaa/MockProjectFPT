package fa.mockproject.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import fa.mockproject.entity.Account;
import fa.mockproject.entity.CV;
import fa.mockproject.entity.Candidate;
import fa.mockproject.entity.Channel;
import fa.mockproject.entity.EntryTest;
import fa.mockproject.entity.Faculty;
import fa.mockproject.entity.Interview;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate applicationDate = LocalDate.now();
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private String gender;
    private String graduationYear;
    private String phone;
    private String email;
    private String foreignLanguage;
    private String level;
    private String allocationStatus;
    private String remarks;

    private Candidate candidate;

    private String statusId = "New";
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

    private long cvId;
    private String CVname;
    private long size;
    private byte[] content;
    private CV cv;

    private long interviewId;
    private BigDecimal interviewTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate interviewDate;
    private String interviewer;
    private String interviewComments;
    private String interviewResult;
    private String interviewRemarks;
    private List<Interview> interviews;

    private long testId;
    private BigDecimal testTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate testDate;
    private String testLanguageValuator;
    private String testLanguageResult;
    private String testTechnicalValuator;
    private String testTechnicalResult;
    private String testResult;
    private String testRemarks;
    private List<EntryTest> entryTests;

    private long accountId;
    private String account;
    private String password;

    public TraineeCandidateProfileModel() {
        super();
    }

    public TraineeCandidateProfileModel(TraineeCandidateProfile profile, Candidate candidate,
                                        TraineeCandidateProfileStatus status2, TraineeCandidateProfileType type2, University university2,
                                        Faculty faculty2, Location location2, Skill skill2, Channel channel2, CV cv2, Account account2) {
        super();
        this.traineeCandidateProfileId = profile.getTraineeCandidateProfileId();
        this.fullName = profile.getFullName();
        LocalDateTime localDateTimeApplicationDate = candidate.getApplicationDate();
        LocalDate localDateApplicationDate = localDateTimeApplicationDate.toLocalDate();
        this.applicationDate = localDateApplicationDate;
        this.dateOfBirth = profile.getDateOfBirth();
        this.gender = profile.getGender();
        LocalDate localDateGraduationYear = profile.getGraduationYear();
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
        this.statusName = status2.getStatus();
        this.channelName = channel2.getChannelName();
        this.type = type2;
        this.typeName = type2.getType();
        this.channel = channel2;
        this.university = university2;
        this.universityName = university2.getUniversityName();
        this.location = location2;
        this.locationName = location2.getLocationName();
        this.faculty = faculty2;
        this.facultyName = faculty2.getFacultyName();
        this.skill = skill2;
        this.skillName = skill2.getSkillName();
        this.cv = cv2;
        this.cvId = cv2.getCvId();
        this.CVname = cv2.getName();
        this.content = cv2.getContent();
        this.size = cv2.getSize();
        this.account = account2.getAccount();
        this.accountId = account2.getAccountId();
        this.password = account2.getPassword();
    }

    public TraineeCandidateProfileModel(long traineeCandidateProfileId, Trainee trainee, String fullName,
                                        LocalDate applicationDate, LocalDate dateOfBirth, String gender, String graduationYear, String phone,
                                        String email, String foreignLanguage, String level, String allocationStatus, String remarks,
                                        Candidate candidate, String statusId, String statusName, TraineeCandidateProfileStatus status,
                                        String typeId, String typeName, TraineeCandidateProfileType type, String channelId, Channel channel,
                                        String channelName, Set<Channel> channellist, String universityId, String universityName,
                                        University university, String locationId, String locationName, Location location,
                                        Set<Location> locationlist, String facultyId, String facultyName, Faculty faculty, String skillId,
                                        String skillName, Skill skill, String cVname, long cvId, long size, byte[] content, CV cv) {
        super();
        this.traineeCandidateProfileId = traineeCandidateProfileId;
        this.trainee = trainee;
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
        this.candidate = candidate;
        this.statusId = statusId;
        this.statusName = statusName;
        this.status = status;
        this.typeId = typeId;
        this.typeName = typeName;
        this.type = type;
        this.channelId = channelId;
        this.channel = channel;
        this.channelName = channelName;
        this.channellist = channellist;
        this.universityId = universityId;
        this.universityName = universityName;
        this.university = university;
        this.locationId = locationId;
        this.locationName = locationName;
        this.location = location;
        this.locationlist = locationlist;
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.faculty = faculty;
        this.skillId = skillId;
        this.skillName = skillName;
        this.skill = skill;
        CVname = cVname;
        this.cvId = cvId;
        this.size = size;
        this.content = content;
        this.cv = cv;
    }

    public TraineeCandidateProfileModel(TraineeCandidateProfile profile, TraineeCandidateProfileStatus status2) {
        this.traineeCandidateProfileId = profile.getTraineeCandidateProfileId();
        this.fullName = profile.getFullName();
        this.status = status2;
        this.statusName = status2.getStatus();
    }

    public List<Interview> getInterviews() {
        return interviews;
    }

    public void setInterviews(List<Interview> interviews) {
        this.interviews = interviews;
    }

    public List<EntryTest> getEntryTests() {
        return entryTests;
    }

    public void setEntryTests(List<EntryTest> entryTests) {
        this.entryTests = entryTests;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getCvId() {
        return cvId;
    }

    public void setCvId(long cvId) {
        this.cvId = cvId;
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

    public TraineeCandidateProfileModel(Interview interview) {
        this.interviewId = interview.getInterviewId();
        this.interviewTime = interview.getTime();
        this.interviewDate = interview.getDate();
        this.interviewer = interview.getInterviewer();
        this.interviewComments = interview.getComments();
        this.interviewResult = interview.getResult();
        this.interviewRemarks = interview.getRemarks();
    }

    public TraineeCandidateProfileModel(EntryTest test) {
        this.testId = test.getTestId();
        this.testTime = test.getTime();
        this.testDate = test.getDate();
        this.testLanguageValuator = test.getLanguageValuator();
        this.testLanguageResult = test.getLanguageResult();
        this.testTechnicalValuator = test.getTechnicalValuator();
        this.testTechnicalResult = test.getTechnicalResult();
        this.testResult = test.getResult();
        this.testRemarks = test.getRemarks();
    }

    public TraineeCandidateProfileModel(TraineeCandidateProfile profile, Candidate candidate2) {
        this.traineeCandidateProfileId = profile.getTraineeCandidateProfileId();
        this.candidate = candidate2;
    }

    public long getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(long interviewId) {
        this.interviewId = interviewId;
    }

    public BigDecimal getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(BigDecimal interviewTime) {
        this.interviewTime = interviewTime;
    }

    public LocalDate getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(LocalDate interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    public String getInterviewComments() {
        return interviewComments;
    }

    public void setInterviewComments(String interviewComments) {
        this.interviewComments = interviewComments;
    }

    public String getInterviewResult() {
        return interviewResult;
    }

    public void setInterviewResult(String inteviewResult) {
        this.interviewResult = inteviewResult;
    }

    public String getInterviewRemarks() {
        return interviewRemarks;
    }

    public void setInterviewRemarks(String interviewRemarks) {
        this.interviewRemarks = interviewRemarks;
    }

    public long getTestId() {
        return testId;
    }

    public void setTestId(long testId) {
        this.testId = testId;
    }

    public BigDecimal getTestTime() {
        return testTime;
    }

    public void setTestTime(BigDecimal testTime) {
        this.testTime = testTime;
    }

    public LocalDate getTestDate() {
        return testDate;
    }

    public void setTestDate(LocalDate testDate) {
        this.testDate = testDate;
    }

    public String getTestLanguageValuator() {
        return testLanguageValuator;
    }

    public void setTestLanguageValuator(String testLanguageValuator) {
        this.testLanguageValuator = testLanguageValuator;
    }

    public String getTestLanguageResult() {
        return testLanguageResult;
    }

    public void setTestLanguageResult(String testLanguageResult) {
        this.testLanguageResult = testLanguageResult;
    }

    public String getTestTechnicalValuator() {
        return testTechnicalValuator;
    }

    public void setTestTechnicalValuator(String testTechnicalValuator) {
        this.testTechnicalValuator = testTechnicalValuator;
    }

    public String getTestTechnicalResult() {
        return testTechnicalResult;
    }

    public void setTestTechnicalResult(String testTechnicalResult) {
        this.testTechnicalResult = testTechnicalResult;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getTestRemarks() {
        return testRemarks;
    }

    public void setTestRemarks(String testRemarks) {
        this.testRemarks = testRemarks;
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
