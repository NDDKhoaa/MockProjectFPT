package fa.mockproject.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fa.mockproject.model.CommitmentViewModel;

@Entity
@Table(name = "Commitment")
public class Commitment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "allowance_id", nullable = false)
	private long commitmentId;

	@OneToOne
	@JoinColumn(name = "trainee_candidate_id", nullable = false)
	private Trainee trainee;

	@Column(name = "commitment_value")
	private long committedValue;

	@Column(name = "commitment_working_duration")
	private Integer committedWorkingDuration;

	@Column(name = "committed_working_startdate")
	private LocalDate committedWorkingStartDate;
	
	@Column(name = "committed_working_enđate")
	private LocalDate committedWorkingEndDate;

	@Column(name = "remarks")
	private String remarks;
	
	public Commitment() {
		super();
	}

	public Commitment(long commitmentId, Trainee trainee, long committedValue, Integer committedWorkingDuration,
			LocalDate committedWorkingStartDate, LocalDate committedWorkingEndDate, String remarks) {
		super();
		this.commitmentId = commitmentId;
		this.trainee = trainee;
		this.committedValue = committedValue;
		this.committedWorkingDuration = committedWorkingDuration;
		this.committedWorkingStartDate = committedWorkingStartDate;
		this.committedWorkingEndDate = committedWorkingEndDate;
		this.remarks = remarks;
	}

	public Commitment(CommitmentViewModel commitmentViewModel, Trainee trainee) {
		this.commitmentId = commitmentViewModel.getCommitmentId();
		this.trainee = trainee;
		this.committedValue = commitmentViewModel.getCommittedValue();
		this.committedWorkingDuration = commitmentViewModel.getCommittedWorkingDuration();
		this.committedWorkingStartDate = commitmentViewModel.getCommittedWorkingStartDate();
		this.committedWorkingEndDate = commitmentViewModel.getCommittedWorkingStartDate();
		this.remarks = commitmentViewModel.getRemarks();
	}

	public long getCommitmentId() {
		return commitmentId;
	}

	public void setCommitmentId(long commitmentId) {
		this.commitmentId = commitmentId;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	public long getCommittedValue() {
		return committedValue;
	}

	public void setCommittedValue(long committedValue) {
		this.committedValue = committedValue;
	}

	public Integer getCommittedWorkingDuration() {
		return committedWorkingDuration;
	}

	public void setCommittedWorkingDuration(Integer committedWorkingDuration) {
		this.committedWorkingDuration = committedWorkingDuration;
	}

	public LocalDate getCommittedWorkingStartDate() {
		return committedWorkingStartDate;
	}

	public void setCommittedWorkingStartDate(LocalDate committedWorkingStartDate) {
		this.committedWorkingStartDate = committedWorkingStartDate;
	}

	public LocalDate getCommittedWorkingEndDate() {
		return committedWorkingEndDate;
	}

	public void setCommittedWorkingEndDate(LocalDate committedWorkingEndDate) {
		this.committedWorkingEndDate = committedWorkingEndDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
