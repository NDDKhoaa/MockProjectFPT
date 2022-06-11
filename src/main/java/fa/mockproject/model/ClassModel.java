package fa.mockproject.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import fa.mockproject.entity.Audit;
import fa.mockproject.entity.SubjectType;
import fa.mockproject.entity.SupplierPartner;
import fa.mockproject.entity.Trainee;
import fa.mockproject.entity.Trainer;
import fa.mockproject.entity.enumtype.BudgetCodeEnum;
import fa.mockproject.entity.enumtype.ClassStatusEnum;
import fa.mockproject.entity.enumtype.SubSubjectTypeEnum;

public class ClassModel {
	
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	
	private long classId;
	private String className;
	private String classCode;
	private LocalDate expectedStartDate;
	private LocalDate expectedEndDate;
	private LocationModel locationModel;
	private String detailLocation;
	private ClassAdminModel classAdminModel;
	private int plannedTraineeNumber;
	private BudgetCodeEnum budgetCode;
	private BudgetModel budgetModel;
	private long estimatedBudget;
	private SubSubjectTypeEnum subSubjectType;
	private DeliveryTypeModel deliveryTypeModel;
	private FormatTypeModel formatTypeModel;
	private ScopeModel scopeModel;
	private String supplierPartnerName;
	private LocalDate actualStartDate;
	private LocalDate actualEndDate;
	private int acceptedTraineeNumber;
	private int actualTraineeNumber;
	private List<TrainerModel> trainerModels;
	private int milestones;
	private byte[] curriculum;
	private Audit audit;
	private List<TraineeModel> traineeModels;
	private SubjectTypeModel subjectTypeModel;
	private ClassStatusEnum status;
	private String remarks;
	
	public ClassModel() {
		super();
	}

	public ClassModel(long classId, String className, String classCode, LocalDate expectedStartDate,
			LocalDate expectedEndDate, LocationModel locationModel, String detailLocation,
			ClassAdminModel classAdminModel, int plannedTraineeNumber, BudgetCodeEnum budgetCode,
			BudgetModel budgetModel, long estimatedBudget, SubSubjectTypeEnum subSubjectType,
			DeliveryTypeModel deliveryTypeModel, FormatTypeModel formatTypeModel, ScopeModel scopeModel,
			String supplierPartnerName, LocalDate actualStartDate, LocalDate actualEndDate, int acceptedTraineeNumber,
			int actualTraineeNumber, List<TrainerModel> trainerModels, int milestones, byte[] curriculum, Audit audit,
			List<TraineeModel> traineeModels, SubjectTypeModel subjectTypeModel, ClassStatusEnum status,
			String remarks) {
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
		this.audit = audit;
		this.traineeModels = traineeModels;
		this.subjectTypeModel = subjectTypeModel;
		this.status = status;
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

	public BudgetModel getBudgetModel() {
		return budgetModel;
	}

	public void setBudgetModel(BudgetModel budgetModel) {
		this.budgetModel = budgetModel;
	}

	public long getEstimatedBudget() {
		return estimatedBudget;
	}

	public void setEstimatedBudget(long estimatedBudget) {
		this.estimatedBudget = estimatedBudget;
	}

	public SubSubjectTypeEnum getSubSubjectType() {
		return subSubjectType;
	}

	public void setSubSubjectType(SubSubjectTypeEnum subSubjectType) {
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

	public List<TrainerModel> getTrainerModels() {
		return trainerModels;
	}

	public void setTrainerModels(List<TrainerModel> trainerModels) {
		this.trainerModels = trainerModels;
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

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
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

	public ClassStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ClassStatusEnum status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "ClassModel [classId=" + classId + ", className=" + className + ", classCode=" + classCode
				+ ", expectedStartDate=" + expectedStartDate + ", expectedEndDate=" + expectedEndDate
				+ ", locationModel=" + locationModel + ", detailLocation=" + detailLocation + ", classAdminModel="
				+ classAdminModel + ", plannedTraineeNumber=" + plannedTraineeNumber + ", budgetCode=" + budgetCode
				+ ", budgetModel=" + budgetModel + ", estimatedBudget=" + estimatedBudget + ", subSubjectType="
				+ subSubjectType + ", deliveryTypeModel=" + deliveryTypeModel + ", formatTypeModel=" + formatTypeModel
				+ ", scopeModel=" + scopeModel + ", supplierPartnerName=" + supplierPartnerName + ", actualStartDate="
				+ actualStartDate + ", actualEndDate=" + actualEndDate + ", acceptedTraineeNumber="
				+ acceptedTraineeNumber + ", actualTraineeNumber=" + actualTraineeNumber + ", trainerModels="
				+ trainerModels + ", milestones=" + milestones + ", curriculum=" + Arrays.toString(curriculum)
				+ ", audit=" + audit + ", subjectTypeModel=" + subjectTypeModel + ", status=" + status + ", remarks="
				+ remarks + "]";
	}

}
