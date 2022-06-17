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
	@Column(name = "trainee_candiDate_id")
	private long traineeCandidateID;

	// Foreign key cua table Class Batch
	@ManyToOne
	@JoinColumn(name = "class_id", nullable = false)
	private ClassBatch classBatch;

	@OneToOne(mappedBy = "trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private TraineeCandidateProfile traineeCandidateProfile;

	@OneToMany(mappedBy = "trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AttendantStatus> attendantStatuses;

	@OneToMany(mappedBy = "trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Allowance> allowances;

	@OneToMany(mappedBy = "trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<GPA> gpas;

	@OneToMany(mappedBy = "trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<RewardPenalty> rewardPenalties;

	@OneToMany(mappedBy = "trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LearningPath> learningPaths;

	@OneToMany(mappedBy = "trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Guarantee> guarantees;

	@OneToMany(mappedBy = "trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<InterviewValuation>	interviewValuations;

	@OneToMany(mappedBy = "trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Status> statuses;

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
			List<AttendantStatus> attendantStatuses, List<Allowance> allowances, List<GPA> gPAs,
			List<RewardPenalty> rewardPenalties, List<LearningPath> learningPaths, List<Guarantee> guarantees,
			List<InterviewValuation> interviewValuations, List<Status> statuses, int remarks) {
		super();
		this.traineeCandidateID = traineeCandidateID;
		this.classBatch = classBatch;
		this.traineeCandidateProfile = traineeCandidateProfile;
		this.attendantStatuses = attendantStatuses;
		this.allowances = allowances;
		gpas = gPAs;
		this.rewardPenalties = rewardPenalties;
		this.learningPaths = learningPaths;
		this.guarantees = guarantees;
		this.interviewValuations = interviewValuations;
		this.statuses = statuses;
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

	public TraineeCandidateProfile getTraineeCandidate() {
		return traineeCandidateProfile;
	}

	public void setTraineeCandidate(TraineeCandidateProfile traineeCandidate) {
		this.traineeCandidateProfile = traineeCandidate;
	}

	public ClassBatch getClassBatch() { 
		return classBatch; 
		}

		public void setClassBatch(ClassBatch classBatch) { this.classBatch =
		classBatch; }

	public TraineeCandidateProfile getTraineeCandidateProfile() {
		return traineeCandidateProfile;
	}

	public void setTraineeCandidateProfile(TraineeCandidateProfile traineeCandidateProfile) {
		this.traineeCandidateProfile = traineeCandidateProfile;
	}


	public List<AttendantStatus> getAttendantStatuses() {
		return attendantStatuses;
	}

	public void setAttendantStatuses(List<AttendantStatus> attendantStatuses) {
		this.attendantStatuses = attendantStatuses;
	}

	public List<Allowance> getAllowances() {
		return allowances;
	}

	public void setAllowances(List<Allowance> allowances) {
		this.allowances = allowances;
	}

	public List<GPA> getGPAs() {
		return gpas;
	}

	public void setGPAs(List<GPA> gPAs) {
		gpas = gPAs;
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

	public List<Status> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<Status> statuses) {
		this.statuses = statuses;
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