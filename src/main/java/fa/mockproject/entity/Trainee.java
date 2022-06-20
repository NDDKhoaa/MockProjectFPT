package fa.mockproject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fa.mockproject.model.TraineeModel;

@Entity
@Table(name = "Trainee")
public class Trainee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "trainee_candidate_id")
	private long traineeCandidateID;

	@ManyToOne
	@JoinColumn(name = "class_id", nullable = false)
	private ClassBatch classBatch;

	@OneToOne(mappedBy = "trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private TraineeCandidateProfile traineeCandidateProfile;

	@OneToMany(mappedBy = "trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AttendantStatus> attendantStatus;

	@OneToMany(mappedBy = "trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Allowance> allowances;

	@OneToMany(mappedBy = "trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<GPA> Gpa;

	@OneToMany(mappedBy = "trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<RewardPenalty> rewardPenalties;

	@OneToMany(mappedBy = "trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LearningPath> learningPaths;

	@OneToMany(mappedBy = "trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Guarantee> guarantees;

	@OneToMany(mappedBy = "trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<InterviewValuation> interviewValuations;

	@OneToMany(mappedBy = "trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Status> status;

	@Column(name = "remarks", nullable = true)
	private int remarks;

	public Trainee() {
		super();
	}

	public Trainee(long traineeCandidateID, int remarks) {
		super();
		this.traineeCandidateID = traineeCandidateID;
		this.remarks = remarks;
	}

	public Trainee(long traineeCandidateID, ClassBatch classBatch, TraineeCandidateProfile traineeCandidateProfile,
			List<AttendantStatus> attendantStatus, List<Allowance> allowances, List<GPA> gpa,
			List<RewardPenalty> rewardPenalties, List<LearningPath> learningPaths, List<Guarantee> guarantees,
			List<InterviewValuation> interviewValuations, List<Status> status, int remarks) {
		super();
		this.traineeCandidateID = traineeCandidateID;
		this.classBatch = classBatch;
		this.traineeCandidateProfile = traineeCandidateProfile;
		this.attendantStatus = attendantStatus;
		this.allowances = allowances;
		Gpa = gpa;
		this.rewardPenalties = rewardPenalties;
		this.learningPaths = learningPaths;
		this.guarantees = guarantees;
		this.interviewValuations = interviewValuations;
		this.status = status;
		this.remarks = remarks;
	}

	public Trainee(TraineeModel traineeModel, ClassBatch classBatch) {
		super();
		//.......
	}

	public long getTraineeCandidateID() {
		return traineeCandidateID;
	}

	public void setTraineeCandidateID(long traineeCandidateID) {
		this.traineeCandidateID = traineeCandidateID;
	}

	public ClassBatch getClassBatch() {
		return classBatch;
	}

	public void setClassBatch(ClassBatch classBatch) {
		this.classBatch = classBatch;
	}

	public TraineeCandidateProfile getTraineeCandidateProfile() {
		return traineeCandidateProfile;
	}

	public void setTraineeCandidateProfile(TraineeCandidateProfile traineeCandidateProfile) {
		this.traineeCandidateProfile = traineeCandidateProfile;
	}

	public List<AttendantStatus> getAttendantStatus() {
		return attendantStatus;
	}

	public void setAttendantStatus(List<AttendantStatus> attendantStatus) {
		this.attendantStatus = attendantStatus;
	}

	public List<Allowance> getAllowances() {
		return allowances;
	}

	public void setAllowances(List<Allowance> allowances) {
		this.allowances = allowances;
	}

	public List<GPA> getGpa() {
		return Gpa;
	}

	public void setGpa(List<GPA> gpa) {
		Gpa = gpa;
	}

	public List<RewardPenalty> getRewardPenalties() {
		return rewardPenalties;
	}

	public void setRewardPenalties(List<RewardPenalty> rewardPenalties) {
		this.rewardPenalties = rewardPenalties;
	}

	public List<LearningPath> getLearningPaths() {
		return learningPaths;
	}

	public void setLearningPaths(List<LearningPath> learningPaths) {
		this.learningPaths = learningPaths;
	}

	public List<Guarantee> getGuarantees() {
		return guarantees;
	}

	public void setGuarantees(List<Guarantee> guarantees) {
		this.guarantees = guarantees;
	}

	public List<InterviewValuation> getInterviewValuations() {
		return interviewValuations;
	}

	public void setInterviewValuations(List<InterviewValuation> interviewValuations) {
		this.interviewValuations = interviewValuations;
	}

	public List<Status> getStatus() {
		return status;
	}

	public void setStatus(List<Status> status) {
		this.status = status;
	}

	public int getRemarks() {
		return remarks;
	}

	public void setRemarks(int remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Trainee [traineeCandidateID=" + traineeCandidateID + ", remarks=" + remarks + "]";
	}
}