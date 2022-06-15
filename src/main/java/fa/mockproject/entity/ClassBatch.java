package fa.mockproject.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fa.mockproject.entity.enumtype.BudgetCodeEnum;
import fa.mockproject.entity.enumtype.ClassBatchStatusEnum;

@Entity
@Table(name = "ClassBatch")
@Cacheable
public class ClassBatch {
	
	@SuppressWarnings("unused")
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "class_id")
	private long classId;
	
	@Column(name = "class_name", length = 255, unique = true, nullable = false)
	private String className;
	
	@Column(name = "class_code", length = 255, unique = true, nullable = false)
	private String classCode;
	
	@Column(name = "expected_start_date", nullable = false)
	private LocalDate expectedStartDate;
	
	@Column(name = "expected_end_date", nullable = false)
	private LocalDate expectedEndDate;
	
	@OneToOne
	@JoinColumn(name = "location_id", nullable = false)
	private Location location;
	
	@Column(name = "detail_location", length = 255, nullable = false)
	private String detailLocation;
	
	@OneToOne
	@JoinColumn(name = "class_admin_id", nullable = false)
	private ClassAdmin classAdmin;
	
	@Column(name = "planned_trainee_number", nullable = false)
	private int plannedTraineeNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "budget_code", nullable = false)
	private BudgetCodeEnum budgetCode;
	
	@OneToMany(mappedBy = "classBatch", cascade = CascadeType.ALL)
	private Budget budget;
	
	@Column(name = "estimated_budget", nullable = false)
	private long estimatedBudget;
	
	@OneToOne
	@JoinColumn(name = "sub_subject_type_id", nullable = false)
	private SubSubjectType subSubjectType;
	
	@OneToOne
	@JoinColumn(name = "delivery_type_id", nullable = false)
	private DeliveryType deliveryType;
	
	@OneToOne
	@JoinColumn(name = "format_type_id", nullable = false)
	private FormatType formatType;
	
	@OneToOne
	@JoinColumn(name = "scope_id", nullable = false)
	private Scope scope;
	
	@OneToOne(mappedBy = "classBatch", cascade = CascadeType.ALL)
	private SupplierPartner supplierPartner;
	
	@Column(name = "actual_start_date", nullable = false)
	private LocalDate actualStartDate;
	
	@Column(name = "actual_end_date", nullable = false)
	private LocalDate actualEndDate;
	
	@Column(name = "accepted_trainee_number", nullable = false)
	private int acceptedTraineeNumber;
	
	@Column(name = "actual_trainee_number", nullable = false)
	private int actualTraineeNumber;
	
	@OneToMany(mappedBy = "classBatch", fetch = FetchType.LAZY)
	private List<Trainer> trainers;
	
	@Column(name = "milestones", nullable = false)
	private int milestones;
	
	@Lob
	@Column(name = "curriculum", nullable = false)
	private byte[] curriculum;
	
	@OneToMany(mappedBy = "classBatch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Audit> audits;
	
	@OneToMany(mappedBy = "classBatch", fetch = FetchType.LAZY)
	private List<Trainee> trainees;
	
	@OneToOne
	@JoinColumn(name = "subject_type_id", nullable = false)
	private SubjectType subjectType;
	
	@Enumerated
	@Column(name = "status", length = 255, nullable = false)
	private ClassBatchStatusEnum status;
	
	@Column(name = "weighted_number", length = 255, nullable = true)
	private String weightedNumber;
	
	@Column(name = "history", length = 255, nullable = true)
	private String history;
	
	@Column(name = "remarks", length = 255, nullable = true)
	private String remarks;

	public ClassBatch() {
		super();
	}

	public ClassBatch(long classId, String className, String classCode, LocalDate expectedStartDate,
			LocalDate expectedEndDate, Location location, String detailLocation, ClassAdmin classAdmin,
			int plannedTraineeNumber, BudgetCodeEnum budgetCode, Budget budget, long estimatedBudget,
			SubSubjectType subSubjectType, DeliveryType deliveryType, FormatType formatType, Scope scope,
			SupplierPartner supplierPartner, LocalDate actualStartDate, LocalDate actualEndDate,
			int acceptedTraineeNumber, int actualTraineeNumber, List<Trainer> trainers, int milestones,
			byte[] curriculum, List<Audit> audits, List<Trainee> trainees, SubjectType subjectType,
			ClassBatchStatusEnum status, String weightedNumber, String history, String remarks) {
		super();
		this.classId = classId;
		this.className = className;
		this.classCode = classCode;
		this.expectedStartDate = expectedStartDate;
		this.expectedEndDate = expectedEndDate;
		this.location = location;
		this.detailLocation = detailLocation;
		this.classAdmin = classAdmin;
		this.plannedTraineeNumber = plannedTraineeNumber;
		this.budgetCode = budgetCode;
		this.budget = budget;
		this.estimatedBudget = estimatedBudget;
		this.subSubjectType = subSubjectType;
		this.deliveryType = deliveryType;
		this.formatType = formatType;
		this.scope = scope;
		this.supplierPartner = supplierPartner;
		this.actualStartDate = actualStartDate;
		this.actualEndDate = actualEndDate;
		this.acceptedTraineeNumber = acceptedTraineeNumber;
		this.actualTraineeNumber = actualTraineeNumber;
		this.trainers = trainers;
		this.milestones = milestones;
		this.curriculum = curriculum;
		this.audits = audits;
		this.trainees = trainees;
		this.subjectType = subjectType;
		this.status = status;
		this.weightedNumber = weightedNumber;
		this.history = history;
		this.remarks = remarks;
	}

	public long getClassId() {
		return classId;
	}

	public void setClassId(long classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public LocalDate getExpectedStartDate() {
		return expectedStartDate;
	}

	public void setExpectedStartDate(LocalDate expectedStartDate) {
		this.expectedStartDate = expectedStartDate;
	}

	public LocalDate getExpectedEndDate() {
		return expectedEndDate;
	}

	public void setExpectedEndDate(LocalDate expectedEndDate) {
		this.expectedEndDate = expectedEndDate;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getDetailLocation() {
		return detailLocation;
	}

	public void setDetailLocation(String detailLocation) {
		this.detailLocation = detailLocation;
	}

	public ClassAdmin getClassAdmin() {
		return classAdmin;
	}

	public void setClassAdmin(ClassAdmin classAdmin) {
		this.classAdmin = classAdmin;
	}

	public int getPlannedTraineeNumber() {
		return plannedTraineeNumber;
	}

	public void setPlannedTraineeNumber(int plannedTraineeNumber) {
		this.plannedTraineeNumber = plannedTraineeNumber;
	}

	public BudgetCodeEnum getBudgetCode() {
		return budgetCode;
	}

	public void setBudgetCode(BudgetCodeEnum budgetCode) {
		this.budgetCode = budgetCode;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}

	public long getEstimatedBudget() {
		return estimatedBudget;
	}

	public void setEstimatedBudget(long estimatedBudget) {
		this.estimatedBudget = estimatedBudget;
	}

	public SubSubjectType getSubSubjectType() {
		return subSubjectType;
	}

	public void setSubSubjectType(SubSubjectType subSubjectType) {
		this.subSubjectType = subSubjectType;
	}

	public DeliveryType getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(DeliveryType deliveryType) {
		this.deliveryType = deliveryType;
	}

	public FormatType getFormatType() {
		return formatType;
	}

	public void setFormatType(FormatType formatType) {
		this.formatType = formatType;
	}

	public Scope getScope() {
		return scope;
	}

	public void setScope(Scope scope) {
		this.scope = scope;
	}

	public SupplierPartner getSupplierPartner() {
		return supplierPartner;
	}

	public void setSupplierPartner(SupplierPartner supplierPartner) {
		this.supplierPartner = supplierPartner;
	}

	public LocalDate getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(LocalDate actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public LocalDate getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(LocalDate actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public int getAcceptedTraineeNumber() {
		return acceptedTraineeNumber;
	}

	public void setAcceptedTraineeNumber(int acceptedTraineeNumber) {
		this.acceptedTraineeNumber = acceptedTraineeNumber;
	}

	public int getActualTraineeNumber() {
		return actualTraineeNumber;
	}

	public void setActualTraineeNumber(int actualTraineeNumber) {
		this.actualTraineeNumber = actualTraineeNumber;
	}

	public List<Trainer> getTrainers() {
		return trainers;
	}

	public void setTrainers(List<Trainer> trainers) {
		this.trainers = trainers;
	}

	public int getMilestones() {
		return milestones;
	}

	public void setMilestones(int milestones) {
		this.milestones = milestones;
	}

	public byte[] getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(byte[] curriculum) {
		this.curriculum = curriculum;
	}

	public List<Audit> getAudits() {
		return audits;
	}

	public void setAudits(List<Audit> audits) {
		this.audits = audits;
	}

	public List<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}

	public SubjectType getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(SubjectType subjectType) {
		this.subjectType = subjectType;
	}

	public ClassBatchStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ClassBatchStatusEnum status) {
		this.status = status;
	}

	public String getWeightedNumber() {
		return weightedNumber;
	}

	public void setWeightedNumber(String weightedNumber) {
		this.weightedNumber = weightedNumber;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
