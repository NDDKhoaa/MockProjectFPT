package fa.mockproject.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import fa.mockproject.model.TraineeCandidateProfileModel;

@Entity
@Table(name = "Interview")
@Cacheable
public class Interview {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "interview_id", unique = true, nullable = false)
	private long interviewId;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "time", nullable = true)
	private BigDecimal time;

	@DateTimeFormat
	@Column(name = "date", nullable = true)
	private LocalDate date;

	@Column(name = "interviewer", length = 255, nullable = true)
	private String interviewer;

	@Column(name = "comments", length = 1000, nullable = true)
	private String comments;

	@Column(name = "result", length = 255, nullable = true)
	private String result;

	@Column(name = "remarks", length = 255, nullable = true)
	private String remarks;

	@ManyToOne
	@JoinColumn(name = "candidate_id",nullable = true)
	private Candidate candidate;

	public Interview() {
		super();
	}

	public Interview(BigDecimal time, LocalDate date, String interviewer, String comments, String result,
			String remarks) {
		super();
		this.time = time;
		this.date = date;
		this.interviewer = interviewer;
		this.comments = comments;
		this.result = result;
		this.remarks = remarks;
	}

	public Interview(TraineeCandidateProfileModel model) {
		this.time = model.getInterviewTime();
		this.date = model.getInterviewDate();
		this.interviewer = model.getInterviewer();
		this.comments = model.getInterviewComments();
		this.result = model.getInterviewResult();
		this.remarks = model.getInterviewRemarks();
		this.candidate=model.getCandidate();
	}

	public long getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(long interviewId) {
		this.interviewId = interviewId;
	}

	public BigDecimal getTime() {
		return time;
	}

	public void setTime(BigDecimal time) {
		this.time = time;
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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	@Override
	public String toString() {
		return "Interview [interviewId=" + interviewId + ", time=" + time + ", date=" + date + ", interviewer="
				+ interviewer + ", comments=" + comments + ", result=" + result + ", remarks=" + remarks + "]";
	}

}