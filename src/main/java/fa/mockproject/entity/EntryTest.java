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
@Table(name = "EntryTest")
@Cacheable
public class EntryTest {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "test_id", unique = true, nullable = false)
	private long testId;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "time", nullable = true)
	private BigDecimal time;

	@DateTimeFormat
	@Column(name = "date", nullable = true)
	private LocalDate date;

	@Column(name = "language_valuator", nullable = true)
	private String languageValuator;

	@Column(name = "language_result", length = 255, nullable = true)
	private String languageResult;

	@Column(name = "techinal_valuator", nullable = true)
	private String technicalValuator;

	@Column(name = "technical_result", length = 255, nullable = true)
	private String technicalResult;

	@Column(name = "result", length = 255, nullable = true)
	private String result;

	@Column(name = "remarks", length = 255, nullable = true)
	private String remarks;

	@ManyToOne
	@JoinColumn(name = "candidate_id", nullable = true)
	private Candidate candidate;

	public EntryTest() {
		super();
	}

	public EntryTest(BigDecimal time, LocalDate date, String languageValuator, String languageResult,
			String technicalValuator, String technicalResult, String result, String remarks) {
		super();
		this.time = time;
		this.date = date;
		this.languageValuator = languageValuator;
		this.languageResult = languageResult;
		this.technicalValuator = technicalValuator;
		this.technicalResult = technicalResult;
		this.result = result;
		this.remarks = remarks;
	}

	public EntryTest(TraineeCandidateProfileModel model) {
		this.time = model.getTestTime();
		this.date = model.getTestDate();
		this.languageValuator = model.getTestLanguageValuator();
		this.languageResult = model.getTestLanguageResult();
		this.technicalValuator = model.getTestTechnicalValuator();
		this.technicalResult = model.getTestTechnicalResult();
		this.result = model.getTestResult();
		this.remarks = model.getTestRemarks();
		this.candidate = model.getCandidate();
	}

	public long getTestId() {
		return testId;
	}

	public void setTestId(long testId) {
		this.testId = testId;
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

	public String getLanguageValuator() {
		return languageValuator;
	}

	public void setLanguageValuator(String languageValuator) {
		this.languageValuator = languageValuator;
	}

	public String getLanguageResult() {
		return languageResult;
	}

	public void setLanguageResult(String languageResult) {
		this.languageResult = languageResult;
	}

	public String getTechnicalValuator() {
		return technicalValuator;
	}

	public void setTechnicalValuator(String technicalValuator) {
		this.technicalValuator = technicalValuator;
	}

	public String getTechnicalResult() {
		return technicalResult;
	}

	public void setTechnicalResult(String technicalResult) {
		this.technicalResult = technicalResult;
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
		return "EntryTest [testId=" + testId + ", time=" + time + ", date=" + date + ", languageValuator="
				+ languageValuator + ", languageResult=" + languageResult + ", technicalValuator=" + technicalValuator
				+ ", technicalResult=" + technicalResult + ", result=" + result + ", remarks=" + remarks + "]";
	}

}
