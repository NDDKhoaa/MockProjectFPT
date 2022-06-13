package fa.mockproject.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import fa.mockproject.entity.ClassBatch;
import fa.mockproject.entity.enumtype.BudgetCodeEnum;
import fa.mockproject.entity.enumtype.ClassBatchStatusEnum;

public class ClassBatchModel {
	
	@SuppressWarnings("unused")
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	
	private long classId;
	private String className;
	private String classCode;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expectedStartDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expectedEndDate;
	private LocationModel locationModel;
	private String detailLocation;
	private ClassAdminModel classAdminModel;
	private Integer plannedTraineeNumber;
	private BudgetCodeEnum budgetCode;
	private BudgetModel budgetModel;
	private Long estimatedBudget;
	private SubSubjectTypeModel subSubjectType;
	private DeliveryTypeModel deliveryTypeModel;
	private FormatTypeModel formatTypeModel;
	private ScopeModel scopeModel;
	private String supplierPartnerName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate actualStartDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate actualEndDate;
	private Integer acceptedTraineeNumber;
	private Integer actualTraineeNumber;
	private List<TrainerModel> trainerModels;
	private Integer milestones;
	private byte[] curriculum;
	private List<AuditModel> auditModels;
	private List<TraineeModel> traineeModels;
	private SubjectTypeModel subjectTypeModel;
	private String weightedNumber;
	private String history;
	private ClassBatchStatusEnum status;
	private String remarks;
	
	public ClassBatchModel() {
		super();
	}

	public ClassBatchModel(long classId, String className, String classCode, LocalDate expectedStartDate,
			LocalDate expectedEndDate, LocationModel locationModel, String detailLocation,
			ClassAdminModel classAdminModel, Integer plannedTraineeNumber, BudgetCodeEnum budgetCode,
			BudgetModel budgetModel, Long estimatedBudget, SubSubjectTypeModel subSubjectType,
			DeliveryTypeModel deliveryTypeModel, FormatTypeModel formatTypeModel, ScopeModel scopeModel,
			String supplierPartnerName, LocalDate actualStartDate, LocalDate actualEndDate, Integer acceptedTraineeNumber,
			Integer actualTraineeNumber, List<TrainerModel> trainerModels, Integer milestones, byte[] curriculum, List<AuditModel> auditModels,
			List<TraineeModel> traineeModels, SubjectTypeModel subjectTypeModel, String weightedNumber, String history,
			ClassBatchStatusEnum status, String remarks) {
		super();
		this.classId = classId;
		this.className = className;
		this.classCode = classCode;
		this.expectedStartDate = expectedStartDate;
		this.expectedEndDate = expectedEndDate;
		this.locationModel = locationModel;
		this.detailLocation = detailLocation;
		this.classAdminModel = classAdminModel;
		this.plannedTraineeNumber = plannedTraineeNumber;
		this.budgetCode = budgetCode;
		this.budgetModel = budgetModel;
		this.estimatedBudget = estimatedBudget;
		this.subSubjectType = subSubjectType;
		this.deliveryTypeModel = deliveryTypeModel;
		this.formatTypeModel = formatTypeModel;
		this.scopeModel = scopeModel;
		this.supplierPartnerName = supplierPartnerName;
		this.actualStartDate = actualStartDate;
		this.actualEndDate = actualEndDate;
		this.acceptedTraineeNumber = acceptedTraineeNumber;
		this.actualTraineeNumber = actualTraineeNumber;
		this.trainerModels = trainerModels;
		this.milestones = milestones;
		this.curriculum = curriculum;
		this.auditModels = auditModels;
		this.traineeModels = traineeModels;
		this.subjectTypeModel = subjectTypeModel;
		this.weightedNumber = weightedNumber;
		this.history = history;
		this.status = status;
		this.remarks = remarks;
	}
	
	public ClassBatchModel(ClassBatch classBatch) {
		super();
		this.classId = classBatch.getClassId();
		this.className = classBatch.getClassName();
		this.classCode = classBatch.getClassCode();
		this.expectedStartDate = classBatch.getExpectedStartDate();
		this.expectedEndDate = classBatch.getExpectedEndDate();
		this.locationModel = new LocationModel(classBatch.getLocation());
		this.detailLocation = classBatch.getDetailLocation();
		this.classAdminModel = new ClassAdminModel(classBatch.getClassAdmin());
		this.plannedTraineeNumber = classBatch.getPlannedTraineeNumber();
		this.budgetCode = classBatch.getBudgetCode();
		this.budgetModel = new BudgetModel(classBatch.getBudget());
		this.estimatedBudget = classBatch.getEstimatedBudget();
		this.subSubjectType = new SubSubjectTypeModel(classBatch.getSubSubjectType());
		this.deliveryTypeModel = new DeliveryTypeModel(classBatch.getDeliveryType());
		this.formatTypeModel = new FormatTypeModel(classBatch.getFormatType());
		this.scopeModel = new ScopeModel(classBatch.getScope());
		this.supplierPartnerName = classBatch.getSupplierPartner().getSupplierPartnerName();
		this.actualStartDate = classBatch.getActualStartDate();
		this.actualEndDate = classBatch.getActualEndDate();
		this.acceptedTraineeNumber = classBatch.getAcceptedTraineeNumber();
		this.actualTraineeNumber = classBatch.getActualTraineeNumber();
		this.trainerModels = new ArrayList<TrainerModel>();
		classBatch.getTrainers().forEach(trainer -> {this.trainerModels.add(new TrainerModel(trainer));});
		this.milestones = classBatch.getMilestones();
		this.curriculum = classBatch.getCurriculum();
		this.auditModels = new ArrayList<AuditModel>();
		classBatch.getAudits().forEach(audit -> {this.auditModels.add(new AuditModel(audit));});
		this.traineeModels = new ArrayList<TraineeModel>();
		classBatch.getTrainees().forEach(trainee -> {this.traineeModels.add(new TraineeModel(trainee));});
		this.subjectTypeModel = new SubjectTypeModel(classBatch.getSubjectType());
		this.history = classBatch.getHistory();
		this.status = classBatch.getStatus();
		this.remarks = classBatch.getRemarks();
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

	public LocationModel getLocationModel() {
		return locationModel;
	}

	public void setLocationModel(LocationModel locationModel) {
		this.locationModel = locationModel;
	}

	public String getDetailLocation() {
		return detailLocation;
	}

	public void setDetailLocation(String detailLocation) {
		this.detailLocation = detailLocation;
	}

	public ClassAdminModel getClassAdminModel() {
		return classAdminModel;
	}

	public void setClassAdminModel(ClassAdminModel classAdminModel) {
		this.classAdminModel = classAdminModel;
	}

	public Integer getPlannedTraineeNumber() {
		return plannedTraineeNumber;
	}

	public void setPlannedTraineeNumber(Integer plannedTraineeNumber) {
		this.plannedTraineeNumber = plannedTraineeNumber;
	}

	public BudgetCodeEnum getBudgetCode() {
		return budgetCode;
	}

	public void setBudgetCode(BudgetCodeEnum budgetCode) {
		this.budgetCode = budgetCode;
	}

	public BudgetModel getBudgetModel() {
		return budgetModel;
	}

	public void setBudgetModel(BudgetModel budgetModel) {
		this.budgetModel = budgetModel;
	}

	public Long getEstimatedBudget() {
		return estimatedBudget;
	}

	public void setEstimatedBudget(Long estimatedBudget) {
		this.estimatedBudget = estimatedBudget;
	}

	public SubSubjectTypeModel getSubSubjectType() {
		return subSubjectType;
	}

	public void setSubSubjectType(SubSubjectTypeModel subSubjectType) {
		this.subSubjectType = subSubjectType;
	}

	public DeliveryTypeModel getDeliveryTypeModel() {
		return deliveryTypeModel;
	}

	public void setDeliveryTypeModel(DeliveryTypeModel deliveryTypeModel) {
		this.deliveryTypeModel = deliveryTypeModel;
	}

	public FormatTypeModel getFormatTypeModel() {
		return formatTypeModel;
	}

	public void setFormatTypeModel(FormatTypeModel formatTypeModel) {
		this.formatTypeModel = formatTypeModel;
	}

	public ScopeModel getScopeModel() {
		return scopeModel;
	}

	public void setScopeModel(ScopeModel scopeModel) {
		this.scopeModel = scopeModel;
	}

	public String getSupplierPartnerName() {
		return supplierPartnerName;
	}

	public void setSupplierPartnerName(String supplierPartnerName) {
		this.supplierPartnerName = supplierPartnerName;
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

	public Integer getAcceptedTraineeNumber() {
		return acceptedTraineeNumber;
	}

	public void setAcceptedTraineeNumber(Integer acceptedTraineeNumber) {
		this.acceptedTraineeNumber = acceptedTraineeNumber;
	}

	public Integer getActualTraineeNumber() {
		return actualTraineeNumber;
	}

	public void setActualTraineeNumber(Integer actualTraineeNumber) {
		this.actualTraineeNumber = actualTraineeNumber;
	}

	public List<TrainerModel> getTrainerModels() {
		return trainerModels;
	}

	public void setTrainerModels(List<TrainerModel> trainerModels) {
		this.trainerModels = trainerModels;
	}

	public Integer getMilestones() {
		return milestones;
	}

	public void setMilestones(Integer milestones) {
		this.milestones = milestones;
	}

	public byte[] getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(byte[] curriculum) {
		this.curriculum = curriculum;
	}

	public List<AuditModel> getAudit() {
		return auditModels;
	}

	public void setAudit(List<AuditModel> auditModels) {
		this.auditModels = auditModels;
	}

	public List<TraineeModel> getTraineeModels() {
		return traineeModels;
	}

	public void setTraineeModels(List<TraineeModel> traineeModels) {
		this.traineeModels = traineeModels;
	}

	public SubjectTypeModel getSubjectTypeModel() {
		return subjectTypeModel;
	}

	public void setSubjectTypeModel(SubjectTypeModel subjectTypeModel) {
		this.subjectTypeModel = subjectTypeModel;
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

	public void setGeneralInfor(ClassBatch classBatch) {
		this.classId = classBatch.getClassId();
		this.className = classBatch.getClassName();
		this.classCode = classBatch.getClassCode();
		this.expectedStartDate = classBatch.getExpectedStartDate();
		this.expectedEndDate = classBatch.getExpectedEndDate();
		this.detailLocation = classBatch.getDetailLocation();
		this.plannedTraineeNumber = classBatch.getPlannedTraineeNumber();
		this.budgetCode = classBatch.getBudgetCode();
		this.estimatedBudget = classBatch.getEstimatedBudget();
		this.supplierPartnerName = classBatch.getSupplierPartner().getSupplierPartnerName();
		this.actualStartDate = classBatch.getActualStartDate();
		this.actualEndDate = classBatch.getActualEndDate();
		this.acceptedTraineeNumber = classBatch.getAcceptedTraineeNumber();
		this.actualTraineeNumber = classBatch.getActualTraineeNumber();
		this.milestones = classBatch.getMilestones();
		this.curriculum = classBatch.getCurriculum();
		this.history = classBatch.getHistory();
		this.status = classBatch.getStatus();
		this.remarks = classBatch.getRemarks();
	}
	
	@Override
	public String toString() {
		return "ClassBatchModel [classId=" + classId + ", className=" + className + ", classCode=" + classCode
				+ ", expectedStartDate=" + expectedStartDate + ", expectedEndDate=" + expectedEndDate
				+ ", locationModel=" + locationModel + ", detailLocation=" + detailLocation + ", classAdminModel="
				+ classAdminModel + ", plannedTraineeNumber=" + plannedTraineeNumber + ", budgetCode=" + budgetCode
				+ ", budgetModel=" + budgetModel + ", estimatedBudget=" + estimatedBudget + ", subSubjectType="
				+ subSubjectType + ", deliveryTypeModel=" + deliveryTypeModel + ", formatTypeModel=" + formatTypeModel
				+ ", scopeModel=" + scopeModel + ", supplierPartnerName=" + supplierPartnerName + ", actualStartDate="
				+ actualStartDate + ", actualEndDate=" + actualEndDate + ", acceptedTraineeNumber="
				+ acceptedTraineeNumber + ", actualTraineeNumber=" + actualTraineeNumber + ", trainerModels="
				+ trainerModels + ", milestones=" + milestones + ", curriculum=" + Arrays.toString(curriculum)
				+ ", auditModels=" + auditModels + ", traineeModels=" + traineeModels + ", subjectTypeModel=" + subjectTypeModel
				+ ", weightedNumber=" + weightedNumber + ", history=" + history + ", status=" + status + ", remarks="
				+ remarks + "]";
	}

}
