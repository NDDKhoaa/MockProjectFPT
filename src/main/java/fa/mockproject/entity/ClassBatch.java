package fa.mockproject.entity;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import fa.mockproject.entity.enumtype.BudgetCodeEnum;
import fa.mockproject.entity.enumtype.ClassBatchStatusEnum;
import fa.mockproject.entity.enumtype.TrainerTypeEnum;
import fa.mockproject.model.ClassBatchModel;
import fa.mockproject.util.Converter;

@NamedStoredProcedureQuery(name = "ClassBatch.updateStatus",
		procedureName = "UPDATE_CLASS_BATCH_STATUS", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "status", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "history", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "remarks", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "row_cnt", type = Integer.class)})
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
	@Column(name = "detail_location", length = 255)
	private String detailLocation;
	@Column(name = "planned_trainee_number")
	private int plannedTraineeNumber;
	@Enumerated(EnumType.STRING)
	@Column(name = "budget_code", nullable = false)
	private BudgetCodeEnum budgetCode;
	@Column(name = "estimated_budget", nullable = false)
	private long estimatedBudget;
	@Column(name = "accepted_trainee_number")
	private int acceptedTraineeNumber;
	@Column(name = "actual_trainee_number")
	private int actualTraineeNumber;
	@Column(name = "actual_start_date")
	private LocalDate actualStartDate;
	@Column(name = "actual_end_date")
	private LocalDate actualEndDate;
	@Column(name = "milestones", nullable = false)
	private int milestones;
	@Column(name = "weighted_number", length = 255)
	private String weightedNumber;
	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 255, nullable = false)
	private ClassBatchStatusEnum status;
	@Column(name = "history", length = 255, nullable = true)
	private String history;
	@Column(name = "remarks", length = 255, nullable = true)
	private String remarks;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "class_type_id", nullable = false)
	private ClassType classType;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "skill_id", nullable = false)
	private Skill skill;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "position_id", nullable = false)
	private Position position;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id", nullable = false)
	private Location location;
	@OneToMany(mappedBy = "classBatch", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<ClassAdmin> classAdmins;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_type_id", nullable = false)
	private SubjectType subjectType;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sub_subject_type_id", nullable = false)
	private SubSubjectType subSubjectType;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "delivery_type_id", nullable = false)
	private DeliveryType deliveryType;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "format_type_id", nullable = false)
	private FormatType formatType;
	@ManyToOne
	@JoinColumn(name = "scope_id", nullable = false)
	private Scope scope;
	@OneToMany(mappedBy = "classBatch", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Budget> budgets;
	@OneToMany(mappedBy = "classBatch", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Trainer> trainers;
	@OneToOne(mappedBy = "classBatch", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Curriculumn curriculumn;
	@OneToMany(mappedBy = "classBatch", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Audit> audits;
	@OneToMany(mappedBy = "classBatch", fetch = FetchType.LAZY)
	private List<Trainee> trainees;
	@OneToOne(mappedBy = "classBatch", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private SupplierPartner supplierPartner;
	@Column(name = "created_date", updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;

	public ClassBatch() {
		super();
	}

	public ClassBatch(long classId, String className, String classCode, LocalDate expectedStartDate,
			LocalDate expectedEndDate, String detailLocation, int plannedTraineeNumber, BudgetCodeEnum budgetCode,
			long estimatedBudget, int acceptedTraineeNumber, int actualTraineeNumber, LocalDate actualStartDate,
			LocalDate actualEndDate, int milestones, String weightedNumber, ClassBatchStatusEnum status, String history,
			String remarks, ClassType classType, Skill skill, Position position, Location location,
			List<ClassAdmin> classAdmins, SubjectType subjectType, SubSubjectType subSubjectType,
			DeliveryType deliveryType, FormatType formatType, Scope scope, List<Budget> budgets, List<Trainer> trainers,
			Curriculumn curriculumn, List<Audit> audits, List<Trainee> trainees, SupplierPartner supplierPartner) {
		super();
		this.classId = classId;
		this.className = className;
		this.classCode = classCode;
		this.expectedStartDate = expectedStartDate;
		this.expectedEndDate = expectedEndDate;
		this.detailLocation = detailLocation;
		this.plannedTraineeNumber = plannedTraineeNumber;
		this.budgetCode = budgetCode;
		this.estimatedBudget = estimatedBudget;
		this.acceptedTraineeNumber = acceptedTraineeNumber;
		this.actualTraineeNumber = actualTraineeNumber;
		this.actualStartDate = actualStartDate;
		this.actualEndDate = actualEndDate;
		this.milestones = milestones;
		this.weightedNumber = weightedNumber;
		this.status = status;
		this.history = history;
		this.remarks = remarks;
		this.classType = classType;
		this.skill = skill;
		this.position = position;
		this.location = location;
		this.classAdmins = classAdmins;
		this.subjectType = subjectType;
		this.subSubjectType = subSubjectType;
		this.deliveryType = deliveryType;
		this.formatType = formatType;
		this.scope = scope;
		this.budgets = budgets;
		this.trainers = trainers;
		this.curriculumn = curriculumn;
		this.audits = audits;
		this.trainees = trainees;
		this.supplierPartner = supplierPartner;
	}

	public ClassBatch(ClassBatchModel classBatchModel) throws IOException {
		super();
		this.classId = classBatchModel.getClassId();
        this.className = classBatchModel.getClassName();
        this.classCode = classBatchModel.getClassCode();
        this.expectedStartDate = classBatchModel.getExpectedStartDate();
        this.expectedEndDate = classBatchModel.getExpectedEndDate();
        this.location = new Location(classBatchModel.getLocationModel());
        this.detailLocation = classBatchModel.getDetailLocation();
        this.classAdmins = Converter.convertList(classBatchModel.getClassAdminModels(), 
        		classAdminModel -> new ClassAdmin(classAdminModel, this));
        this.plannedTraineeNumber = Optional.ofNullable(classBatchModel.getPlannedTraineeNumber()).orElse(0);
        this.budgetCode = classBatchModel.getBudgetCode();
        this.budgets = Converter.convertList(classBatchModel.getBudgetModels(), 
        		budgetModel -> new Budget(budgetModel, this));
        this.estimatedBudget = Optional.ofNullable(classBatchModel.getEstimatedBudget()).orElse(0L);
        this.subSubjectType = new SubSubjectType(classBatchModel.getSubSubjectTypeModel());
        this.deliveryType = new DeliveryType(classBatchModel.getDeliveryTypeModel());
        this.formatType = new FormatType(classBatchModel.getFormatTypeModel());
        this.scope = new Scope(classBatchModel.getScopeModel());
        this.supplierPartner = new SupplierPartner(classBatchModel.getSupplierPartnerModel(), this);
        this.actualStartDate = classBatchModel.getActualStartDate();
        this.actualEndDate = classBatchModel.getActualEndDate();
        this.acceptedTraineeNumber = Optional.ofNullable(classBatchModel.getAcceptedTraineeNumber()).orElse(0);
        this.actualTraineeNumber = Optional.ofNullable(classBatchModel.getActualTraineeNumber()).orElse(0);
        this.trainers = Converter.convertList(classBatchModel.getTrainerModels(), trainerModel -> {
        	trainerModel.setType(TrainerTypeEnum.Trainer);
        	return new Trainer(trainerModel, this);
        });
        classBatchModel.getMasterTrainerModel().setType(TrainerTypeEnum.MasterTrainer);
        this.trainers.add(new Trainer(classBatchModel.getMasterTrainerModel(), this));
        this.milestones = Optional.ofNullable(classBatchModel.getMilestones()).orElse(0);
        this.curriculumn = new Curriculumn(classBatchModel.getCurriculumnModel(), this);
        this.audits = Converter.convertList(classBatchModel.getAuditModels(), 
        		auditModel -> new Audit(auditModel, this));
        this.trainees = Converter.convertList(classBatchModel.getTraineeModels(), 
        		traineeModel -> new Trainee(traineeModel, this));
        this.subjectType = new SubjectType(classBatchModel.getSubjectTypeModel());
        this.status = classBatchModel.getStatus();
        this.weightedNumber = classBatchModel.getWeightedNumber();
        this.history = classBatchModel.getHistory();
        this.remarks = classBatchModel.getRemarks();
        this.classType = new ClassType(classBatchModel.getClassTypeModel());
        this.skill = new Skill(classBatchModel.getSkillModel());
        this.position = new Position(classBatchModel.getPositionModel());
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

	public List<ClassAdmin> getClassAdmins() {
		return classAdmins;
	}

	public void setClassAdmins(List<ClassAdmin> classAdmins) {
		this.classAdmins = classAdmins;
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

	public List<Budget> getBudgets() {
		return budgets;
	}

	public void setBudgets(List<Budget> budgets) {
		this.budgets = budgets;
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

	public Curriculumn getCurriculumn() {
		return curriculumn;
	}

	public void setCurriculumn(Curriculumn curriculumn) {
		this.curriculumn = curriculumn;
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

	public ClassType getClassType() {
		return classType;
	}

	public void setClassType(ClassType classType) {
		this.classType = classType;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "ClassBatch [\n\tclassId=" + classId 
	            + "\n\tclassName=" + className 
	            + "\n\tclassCode=" + classCode 
	            + "\n\texpectedStartDate=" + expectedStartDate 
	            + "\n\texpectedEndDate=" + expectedEndDate 
	            + "\n\tdetailLocation=" + detailLocation 
	            + "\n\tplannedTraineeNumber=" + plannedTraineeNumber 
	            + "\n\tbudgetCode=" + budgetCode 
	            + "\n\testimatedBudget=" + estimatedBudget 
	            + "\n\tacceptedTraineeNumber=" + acceptedTraineeNumber 
	            + "\n\tactualTraineeNumber=" + actualTraineeNumber 
	            + "\n\tactualStartDate=" + actualStartDate 
	            + "\n\tactualEndDate=" + actualEndDate 
	            + "\n\tmilestones=" + milestones 
	            + "\n\tweightedNumber=" + weightedNumber 
	            + "\n\tstatus=" + status 
	            + "\n\thistory=" + history 
	            + "\n\tremarks=" + remarks 
	            + "\n\tclassType=" + classType 
	            + "\n\tskill=" + skill 
	            + "\n\tposition=" + position 
	            + "\n\tlocation=" + location 
	            + "\n\tclassAdmins=" + classAdmins 
	            + "\n\tsubjectType=" + subjectType 
	            + "\n\tsubSubjectType=" + subSubjectType 
	            + "\n\tdeliveryType=" + deliveryType 
	            + "\n\tformatType=" + formatType 
	            + "\n\tscope=" + scope 
	            + "\n\tbudgets=" + budgets 
	            + "\n\ttrainers=" + trainers 
	            + "\n\tcurriculumn=" + curriculumn 
	            + "\n\taudits=" + audits 
	            + "\n\ttrainees=" + trainees 
	            + "\n\tsupplierPartner=" + supplierPartner 
	            + "]";
	}
	
}
