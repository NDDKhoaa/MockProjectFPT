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
	private long traineeCandidateId;

	// Foreign key cua table Class Batch
	@ManyToOne
	@JoinColumn(name = "class_id", nullable = true)
	private ClassBatch classBatch;

	@OneToOne(mappedBy = "trainee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
	private List<InterviewValuation> interviewValuations;

	@OneToMany(mappedBy = "trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Status> statuses;

	@OneToMany(mappedBy = "trainee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Milestone> milestones;
	
	@OneToOne(mappedBy = "trainee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Allocation allocation;
	
	@OneToOne(mappedBy = "trainee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private AllowanceGroup allowanceGroup;
	
	@OneToOne(mappedBy = "trainee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Commitment commitment;

	@Column(name = "tpbank_account")
	private String tpbankAccount;
	
	@Column(name = "remarks", nullable = true)
	private String remarks;

	public Trainee() {
		super();
	}

	public Trainee(long traineeCandidateID, String remarks) {
		super();
		this.traineeCandidateId = traineeCandidateID;
		this.remarks = remarks;
	}

	public Trainee(long traineeCandidateId, ClassBatch classBatch, TraineeCandidateProfile traineeCandidateProfile,
			List<AttendantStatus> attendantStatuses, List<Allowance> allowances, List<GPA> gpas,
			List<RewardPenalty> rewardPenalties, List<LearningPath> learningPaths, List<Guarantee> guarantees,
			List<InterviewValuation> interviewValuations, List<Status> statuses, List<Milestone> milestones,
			Allocation allocation, Commitment commitment, String tpbankAccount, String remarks) {
		super();
		this.traineeCandidateId = traineeCandidateId;
		this.classBatch = classBatch;
		this.traineeCandidateProfile = traineeCandidateProfile;
		this.attendantStatuses = attendantStatuses;
		this.allowances = allowances;
		this.gpas = gpas;
		this.rewardPenalties = rewardPenalties;
		this.learningPaths = learningPaths;
		this.guarantees = guarantees;
		this.interviewValuations = interviewValuations;
		this.statuses = statuses;
		this.milestones = milestones;
		this.allocation = allocation;
		this.commitment = commitment;
		this.tpbankAccount = tpbankAccount;
		this.remarks = remarks;
	}

	public Trainee(TraineeModel traineeModel, ClassBatch classBatch) {
		super();
		// .......
	}

	

	public Trainee(TraineeCandidateProfile profile) {
		this.traineeCandidateProfile=profile;
	}

	public long getTraineeCandidateId() {
		return traineeCandidateId;
	}

	public void setTraineeCandidateId(long traineeCandidateId) {
		this.traineeCandidateId = traineeCandidateId;
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

	public List<GPA> getGpas() {
		return gpas;
	}

	public void setGpas(List<GPA> gpas) {
		this.gpas = gpas;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<Milestone> getMilestones() {
		return milestones;
	}

	public void setMilestones(List<Milestone> milestones) {
		this.milestones = milestones;
	}

	public Allocation getAllocation() {
		return allocation;
	}

	public void setAllocation(Allocation allocation) {
		this.allocation = allocation;
	}

	public String getTpbankAccount() {
		return tpbankAccount;
	}

	public void setTpbankAccount(String tpbankAccount) {
		this.tpbankAccount = tpbankAccount;
	}

	public Commitment getCommitment() {
		return commitment;
	}

	public void setCommitment(Commitment commitment) {
		this.commitment = commitment;
	}
	
	public AllowanceGroup getAllowanceGroup() {
		return allowanceGroup;
	}

	public void setAllowanceGroup(AllowanceGroup allowanceGroup) {
		this.allowanceGroup = allowanceGroup;
	}

	@Override
	public String toString() {
		return "Trainee [traineeCandidateID=" + traineeCandidateId + ", remarks=" + remarks + "]";
	}
}