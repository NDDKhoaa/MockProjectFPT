package fa.mockproject.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "EntryTest")
@Cacheable
public class EntryTest {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "test_id", unique = true, nullable = false)
	private long testId;

	@Column(name = "time", nullable = false)
	private BigDecimal time;

	@DateTimeFormat
	@Column(name = "date", nullable = false)
	private Date date;

	@Column(name = "language_valuator", nullable = false)
	private int languageValuator;

	@Column(name = "language_result", length = 250, nullable = false)
	private String languageResult;

	@Column(name = "techinal_valuator", nullable = false)
	private int technicalValuator;

	@Column(name = "technical_result", length = 250, nullable = false)
	private String technicalResult;

	@Column(name = "result", length = 250, nullable = false)
	private String result;

	@Column(name = "remarks", length = 250, nullable = true)
	private String remarks;

	@Column(name = "candidate_id", nullable = false)
	private Candidate candidate;

	public EntryTest() {
		super();
	}

	public EntryTest(BigDecimal time, Date date, int languageValuator, String languageResult, int technicalValuator,
			String technicalResult, String result, String remarks) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getLanguageValuator() {
		return languageValuator;
	}

	public void setLanguageValuator(int languageValuator) {
		this.languageValuator = languageValuator;
	}

	public String getLanguageResult() {
		return languageResult;
	}

	public void setLanguageResult(String languageResult) {
		this.languageResult = languageResult;
	}

	public int getTechnicalValuator() {
		return technicalValuator;
	}

	public void setTechnicalValuator(int technicalValuator) {
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
