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

@Entity
@Table(name = "Trainee")
public class Trainee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "trainee_candiDate_id")
    private int traineeCandidateID;
	
	// Foreign key cua table Class Batch
	@ManyToOne
	@JoinColumn(name="class_id", nullable=false)
	private ClassBatch classBatch;
	
	@OneToOne(mappedBy="trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private TraineeCandidateProfile traineeCandidateProfile;
	
	@OneToMany(mappedBy="trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AttendantStatus> listAttendantStatus;
	
	@OneToMany(mappedBy="trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Allowance> listAllowances;
	
	@OneToMany(mappedBy="trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<GPA> listGPA;
	
	@OneToMany(mappedBy="trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<RewardPenalty> listRewardPenalties;
	
	@OneToMany(mappedBy="trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LearningPath> listLearningPaths;
	
	@OneToMany(mappedBy="trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Guarantee> listGuarantees;
	
	@OneToMany(mappedBy="trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<InterviewValuation> listinterviewValuations;
	
	@OneToMany(mappedBy="trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Status> listStatus;
	
	@Column(name = "remarks", nullable = true)
	private int remarks;

	public Trainee() {
		super();
	}
	
	public Trainee(int traineeCandidateID, int remarks) {
		super();
		this.traineeCandidateID = traineeCandidateID;
		this.remarks = remarks;
	}



	public Trainee(TraineeCandidateProfile traineeCandidate, ClassBatch classBatch,
			TraineeCandidateProfile traineeCandidateProfile, List<AttendantStatus> listAttendantStatus,
			List<Allowance> listAllowances, List<GPA> listGPA, List<RewardPenalty> listRewardPenalties,
			List<LearningPath> listLearningPaths, List<Guarantee> listGuarantees,
			List<InterviewValuation> listinterviewValuations, List<Status> listStatus, int remarks) {
		super();
		this.traineeCandidateProfile = traineeCandidate;
		this.classBatch = classBatch;
		this.traineeCandidateProfile = traineeCandidateProfile;
		this.listAttendantStatus = listAttendantStatus;
		this.listAllowances = listAllowances;
		this.listGPA = listGPA;
		this.listRewardPenalties = listRewardPenalties;
		this.listLearningPaths = listLearningPaths;
		this.listGuarantees = listGuarantees;
		this.listinterviewValuations = listinterviewValuations;
		this.listStatus = listStatus;
		this.remarks = remarks;
	}

	public Trainee(int traineeCandidateID, TraineeCandidateProfile traineeCandidate, ClassBatch classBatch,
			TraineeCandidateProfile traineeCandidateProfile, List<AttendantStatus> listAttendantStatus,
			List<Allowance> listAllowances, List<GPA> listGPA, List<RewardPenalty> listRewardPenalties,
			List<LearningPath> listLearningPaths, List<Guarantee> listGuarantees,
			List<InterviewValuation> listinterviewValuations, List<Status> listStatus, int remarks) {
		super();
		this.traineeCandidateID = traineeCandidateID;
		this.traineeCandidateProfile = traineeCandidate;
		this.classBatch = classBatch;
		this.traineeCandidateProfile = traineeCandidateProfile;
		this.listAttendantStatus = listAttendantStatus;
		this.listAllowances = listAllowances;
		this.listGPA = listGPA;
		this.listRewardPenalties = listRewardPenalties;
		this.listLearningPaths = listLearningPaths;
		this.listGuarantees = listGuarantees;
		this.listinterviewValuations = listinterviewValuations;
		this.listStatus = listStatus;
		this.remarks = remarks;
	}

	public int getTraineeCandidateID() {
		return traineeCandidateID;
	}

	public void setTraineeCandidateID(int traineeCandidateID) {
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

	public void setClassBatch(ClassBatch classBatch) {
		this.classBatch = classBatch;
	}

	public TraineeCandidateProfile getTraineeCandidateProfile() {
		return traineeCandidateProfile;
	}

	public void setTraineeCandidateProfile(TraineeCandidateProfile traineeCandidateProfile) {
		this.traineeCandidateProfile = traineeCandidateProfile;
	}

	public List<AttendantStatus> getListAttendantStatus() {
		return listAttendantStatus;
	}

	public void setListAttendantStatus(List<AttendantStatus> listAttendantStatus) {
		this.listAttendantStatus = listAttendantStatus;
	}

	public List<Allowance> getListAllowances() {
		return listAllowances;
	}

	public void setListAllowances(List<Allowance> listAllowances) {
		this.listAllowances = listAllowances;
	}

	public List<GPA> getListGPA() {
		return listGPA;
	}

	public void setListGPA(List<GPA> listGPA) {
		this.listGPA = listGPA;
	}

	public List<RewardPenalty> getListRewardPenalties() {
		return listRewardPenalties;
	}

	public void setListRewardPenalties(List<RewardPenalty> listRewardPenalties) {
		this.listRewardPenalties = listRewardPenalties;
	}

	public List<LearningPath> getListLearningPaths() {
		return listLearningPaths;
	}

	public void setListLearningPaths(List<LearningPath> listLearningPaths) {
		this.listLearningPaths = listLearningPaths;
	}

	public List<Guarantee> getListGuarantees() {
		return listGuarantees;
	}

	public void setListGuarantees(List<Guarantee> listGuarantees) {
		this.listGuarantees = listGuarantees;
	}

	public List<InterviewValuation> getListinterviewValuations() {
		return listinterviewValuations;
	}

	public void setListinterviewValuations(List<InterviewValuation> listinterviewValuations) {
		this.listinterviewValuations = listinterviewValuations;
	}

	public List<Status> getListStatus() {
		return listStatus;
	}

	public void setListStatus(List<Status> listStatus) {
		this.listStatus = listStatus;
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
