package fa.mockproject.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import fa.mockproject.entity.Interview;

public class InterviewModel {
	private long id;
	private BigDecimal time;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private String interviewer;
	private String comments;
	private String result;
	private String remarks;

	public InterviewModel() {
		super();
	}

	public InterviewModel(long interviewId, BigDecimal interviewTime, LocalDate interviewDate, String interviewer,
			String interviewComments, String interviewResult, String interviewRemarks) {
		super();
		this.id = interviewId;
		this.time = interviewTime;
		this.date = interviewDate;
		this.interviewer = interviewer;
		this.comments = interviewComments;
		this.result = interviewResult;
		this.remarks = interviewRemarks;
	}

	public InterviewModel(Interview interview) {
		super();
		this.id = interview.getInterviewId();
		this.time = interview.getTime();
		this.date = interview.getDate();
		this.interviewer = interview.getInterviewer();
		this.comments = interview.getComments();
		this.result = interview.getResult();
		this.remarks = interview.getRemarks();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

}
