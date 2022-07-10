package fa.mockproject.model;

import java.time.LocalDate;

import fa.mockproject.entity.Commitment;

public class CommitmentViewModel {
	private long commitmentId;
	private long committedValue;
	private Integer committedWorkingDuration;
	private LocalDate committedWorkingStartDate; 
	private LocalDate committedWorkingEndDate;
	private String remarks;
	
	
	public CommitmentViewModel(long commitmentId, long committedValue, Integer committedWorkingDuration,
			LocalDate committedWorkingStartDate, LocalDate committedWorkingEndDate, String remarks) {
		super();
		this.commitmentId = commitmentId;
		this.committedValue = committedValue;
		this.committedWorkingDuration = committedWorkingDuration;
		this.committedWorkingStartDate = committedWorkingStartDate;
		this.committedWorkingEndDate = committedWorkingEndDate;
		this.remarks = remarks;
	}
	public CommitmentViewModel() {
		super();
	}
	public CommitmentViewModel(Commitment commitment) {
		this.commitmentId = commitment.getCommitmentId();
		this.committedValue = commitment.getCommittedValue();
		this.committedWorkingDuration = commitment.getCommittedWorkingDuration();
		this.committedWorkingStartDate = commitment.getCommittedWorkingStartDate();
		this.committedWorkingEndDate = commitment.getCommittedWorkingEndDate();
		this.remarks = commitment.getRemarks();
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
	public void setCommittedWorkingDuration(int committedWorkingDuration) {
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
	
	
	public long getCommitmentId() {
		return commitmentId;
	}
	public void setCommitmentId(long commitmentId) {
		this.commitmentId = commitmentId;
	}
	public void setCommittedWorkingDuration(Integer committedWorkingDuration) {
		this.committedWorkingDuration = committedWorkingDuration;
	}
	@Override
	public String toString() {
		return "CommitmentViewModel [committedValue=" + committedValue + ", committedWorkingDuration="
				+ committedWorkingDuration + ", committedWorkingStartDate=" + committedWorkingStartDate
				+ ", committedWorkingEndDate=" + committedWorkingEndDate + ", remarks=" + remarks + "]";
	}
	
	
	
}
