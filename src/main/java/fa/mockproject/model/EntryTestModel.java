package fa.mockproject.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import fa.mockproject.entity.EntryTest;

public class EntryTestModel {
	private long id;
	private BigDecimal time;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private String languageValuator;
	private String languageResult;
	private String technicalValuator;
	private String technicalResult;
	private String result;
	private String remarks;

	public EntryTestModel() {
		super();
	}

	public EntryTestModel(long testid, BigDecimal testtime, LocalDate testdate, String testlanguageValuator,
			String testlanguageresult, String testtechnicalValuator, String testtechnicalresult, String testresult,
			String testremarks) {
		super();
		this.id = testid;
		this.time = testtime;
		this.date = testdate;
		this.languageValuator = testlanguageValuator;
		this.languageResult = testlanguageresult;
		this.technicalValuator = testtechnicalValuator;
		this.technicalResult = testtechnicalresult;
		this.result = testresult;
		this.remarks = testremarks;
	}

	public EntryTestModel(EntryTest entryTest) {
		super();
		this.id = entryTest.getTestId();
		this.time = entryTest.getTime();
		this.date = entryTest.getDate();
		this.languageValuator = entryTest.getLanguageValuator();
		this.languageResult = entryTest.getLanguageResult();
		this.technicalValuator = entryTest.getTechnicalValuator();
		this.technicalResult = entryTest.getTechnicalResult();
		this.result = entryTest.getResult();
		this.remarks = entryTest.getRemarks();
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

}
