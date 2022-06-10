package fa.mockproject.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "InterviewValuation")
public class InterviewValuation {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "interview_valuation_id", nullable = false, unique=true)
    private int interviewValuationId;
	
	//TraineeID
	@ManyToOne
	@JoinColumn(name = "trainee_candidate_id", nullable = false)
	private Trainee trainee;
	
	@Column(name = "date", nullable = false)
	private LocalDate date;
	
	@Column(name = "interviewer", nullable = false, length = 55)
	private String interviewer;
	
	@Column(name = "remarks", nullable = false, length = 255)
	private String remarks;

	public InterviewValuation() {
		super();
	}

	public InterviewValuation(int interviewValuationId, LocalDate date, String interviewer, String remarks) {
		super();
		this.interviewValuationId = interviewValuationId;
		this.date = date;
		this.interviewer = interviewer;
		this.remarks = remarks;
	}

	public InterviewValuation(int interviewValuationId, Trainee trainee, LocalDate date, String interviewer, String remarks) {
		super();
		this.interviewValuationId = interviewValuationId;
		this.trainee = trainee;
		this.date = date;
		this.interviewer = interviewer;
		this.remarks = remarks;
	}

	public int getInterviewValuationId() {
		return interviewValuationId;
	}

	public void setInterviewValuationId(int interviewValuationId) {
		this.interviewValuationId = interviewValuationId;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "InterviewValuation [interviewValuationId=" + interviewValuationId + ", date=" + date + ", interviewer="
				+ interviewer + ", remarks=" + remarks + "]";
	}
}
