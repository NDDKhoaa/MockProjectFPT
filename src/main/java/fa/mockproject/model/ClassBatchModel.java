package fa.mockproject.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import fa.mockproject.entity.ClassBatch;
import fa.mockproject.entity.enumtype.BudgetCodeEnum;
import fa.mockproject.entity.enumtype.ClassBatchStatusEnum;
import fa.mockproject.entity.enumtype.TrainerTypeEnum;
import fa.mockproject.util.Converter;

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
	private Integer plannedTraineeNumber;
	private Long estimatedBudget;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate actualStartDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate actualEndDate;
	private Integer acceptedTraineeNumber;
	private Integer actualTraineeNumber;
	private Integer milestones;
	private String weightedNumber;
	private String history;
	private String detailLocation;
	private BudgetCodeEnum budgetCode;
	private ClassBatchStatusEnum status;
	private ClassTypeModel classTypeModel;
	private SkillModel skillModel;
	private PositionModel positionModel;
	private CurriculumnModel curriculumnModel;
	private LocationModel locationModel;
	private SubjectTypeModel subjectTypeModel;
	private SubSubjectTypeModel subSubjectTypeModel;
	private DeliveryTypeModel deliveryTypeModel;
	private ScopeModel scopeModel;
	private FormatTypeModel formatTypeModel;
	private SupplierPartnerModel supplierPartnerModel;
	private List<ClassAdminModel> classAdminModels;
	private List<BudgetModel> budgetModels;
	private TrainerModel masterTrainerModel;
	private List<TrainerModel> trainerModels;
	private List<AuditModel> auditModels;
	private List<TraineeModel> traineeModels;
	private String remarks;
	
	public ClassBatchModel() {
		super();
	}
	
	public ClassBatchModel(Long classId) {
		super();
		this.classId = classId;
	}

	public ClassBatchModel(long classId, String className, String classCode, LocalDate expectedStartDate,
			LocalDate expectedEndDate, Integer plannedTraineeNumber, Long estimatedBudget, LocalDate actualStartDate,
			LocalDate actualEndDate, Integer acceptedTraineeNumber, Integer actualTraineeNumber, Integer milestones,
			String weightedNumber, String history, String detailLocation, BudgetCodeEnum budgetCode,
			ClassBatchStatusEnum status, ClassTypeModel classTypeModel, SkillModel skillModel,
			PositionModel positionModel, CurriculumnModel curriculumnModel, LocationModel locationModel,
			SubjectTypeModel subjectTypeModel, SubSubjectTypeModel subSubjectTypeModel,
			DeliveryTypeModel deliveryTypeModel, ScopeModel scopeModel, FormatTypeModel formatTypeModel,
			SupplierPartnerModel supplierPartnerModel, List<ClassAdminModel> classAdminModels,
			List<BudgetModel> budgetModels, TrainerModel masterTrainerModel, List<TrainerModel> trainerModels,
			List<AuditModel> auditModels, List<TraineeModel> traineeModels, String remarks) {
		super();
		this.classId = classId;
		this.className = className;
		this.classCode = classCode;
		this.expectedStartDate = expectedStartDate;
		this.expectedEndDate = expectedEndDate;
		this.plannedTraineeNumber = plannedTraineeNumber;
		this.estimatedBudget = estimatedBudget;
		this.actualStartDate = actualStartDate;
		this.actualEndDate = actualEndDate;
		this.acceptedTraineeNumber = acceptedTraineeNumber;
		this.actualTraineeNumber = actualTraineeNumber;
		this.milestones = milestones;
		this.weightedNumber = weightedNumber;
		this.history = history;
		this.detailLocation = detailLocation;
		this.budgetCode = budgetCode;
		this.status = status;
		this.classTypeModel = classTypeModel;
		this.skillModel = skillModel;
		this.positionModel = positionModel;
		this.curriculumnModel = curriculumnModel;
		this.locationModel = locationModel;
		this.subjectTypeModel = subjectTypeModel;
		this.subSubjectTypeModel = subSubjectTypeModel;
		this.deliveryTypeModel = deliveryTypeModel;
		this.scopeModel = scopeModel;
		this.formatTypeModel = formatTypeModel;
		this.supplierPartnerModel = supplierPartnerModel;
		this.classAdminModels = classAdminModels;
		this.budgetModels = budgetModels;
		this.masterTrainerModel = masterTrainerModel;
		this.masterTrainerModel.setType(TrainerTypeEnum.MasterTrainer);
		this.trainerModels = Converter.convertList(trainerModels, trainerModel -> {
				trainerModel.setType(TrainerTypeEnum.Trainer);
				return trainerModel;
		});
		this.auditModels = auditModels;
		this.traineeModels = traineeModels;
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
		this.classAdminModels = Converter.convertList(classBatch.getClassAdmins(), classAdmin -> 
				new ClassAdminModel(classAdmin));
		this.plannedTraineeNumber = classBatch.getPlannedTraineeNumber();
		this.budgetCode = classBatch.getBudgetCode();
		this.budgetModels = Converter.convertList(classBatch.getBudgets(), budget -> 
				new BudgetModel(budget));
		this.estimatedBudget = classBatch.getEstimatedBudget();
		this.subSubjectTypeModel = new SubSubjectTypeModel(classBatch.getSubSubjectType());
		this.deliveryTypeModel = new DeliveryTypeModel(classBatch.getDeliveryType());
		this.formatTypeModel = new FormatTypeModel(classBatch.getFormatType());
		this.scopeModel = new ScopeModel(classBatch.getScope());
		this.supplierPartnerModel = new SupplierPartnerModel(classBatch.getSupplierPartner());
		this.actualStartDate = classBatch.getActualStartDate();
		this.actualEndDate = classBatch.getActualEndDate();
		this.acceptedTraineeNumber = classBatch.getAcceptedTraineeNumber();
		this.actualTraineeNumber = classBatch.getActualTraineeNumber();
		this.trainerModels = Converter.convertList(classBatch.getTrainers(), trainer -> {
				if (trainer.getType() == TrainerTypeEnum.MasterTrainer) {
					this.masterTrainerModel = new TrainerModel(trainer);
					return null;
				}
				return new TrainerModel(trainer);
		}, trainer -> trainer != null);
		this.milestones = classBatch.getMilestones();
		this.curriculumnModel = new CurriculumnModel(classBatch.getCurriculumn());
		this.auditModels = Converter.convertList(classBatch.getAudits(), audit -> 
				new AuditModel(audit));
		this.traineeModels = Converter.convertList(classBatch.getTrainees(), trainee -> 
				new TraineeModel(trainee));
		this.subjectTypeModel = new SubjectTypeModel(classBatch.getSubjectType());
		this.weightedNumber = classBatch.getWeightedNumber();
		this.history = classBatch.getHistory();
		this.status = classBatch.getStatus();
		this.remarks = classBatch.getRemarks();
		this.classTypeModel = new ClassTypeModel(classBatch.getClassType());
		this.skillModel = new SkillModel(classBatch.getSkill());
		this.positionModel = new PositionModel(classBatch.getPosition());
	}
	
	public void setAll(ClassBatch classBatch) {
		this.classId = classBatch.getClassId();
		this.className = classBatch.getClassName();
		this.classCode = classBatch.getClassCode();
		this.expectedStartDate = classBatch.getExpectedStartDate();
		this.expectedEndDate = classBatch.getExpectedEndDate();
		this.locationModel = new LocationModel(classBatch.getLocation());
		this.detailLocation = classBatch.getDetailLocation();
		this.classAdminModels = Converter.convertList(classBatch.getClassAdmins(), classAdmin -> 
				new ClassAdminModel(classAdmin));
		this.plannedTraineeNumber = classBatch.getPlannedTraineeNumber();
		this.budgetCode = classBatch.getBudgetCode();
		this.budgetModels = Converter.convertList(classBatch.getBudgets(), budget -> 
				new BudgetModel(budget));
		this.estimatedBudget = classBatch.getEstimatedBudget();
		this.subSubjectTypeModel = new SubSubjectTypeModel(classBatch.getSubSubjectType());
		this.deliveryTypeModel = new DeliveryTypeModel(classBatch.getDeliveryType());
		this.formatTypeModel = new FormatTypeModel(classBatch.getFormatType());
		this.scopeModel = new ScopeModel(classBatch.getScope());
		this.supplierPartnerModel = new SupplierPartnerModel(classBatch.getSupplierPartner());
		this.actualStartDate = classBatch.getActualStartDate();
		this.actualEndDate = classBatch.getActualEndDate();
		this.acceptedTraineeNumber = classBatch.getAcceptedTraineeNumber();
		this.actualTraineeNumber = classBatch.getActualTraineeNumber();
		this.trainerModels = Converter.convertList(classBatch.getTrainers(), trainer -> {
				if (trainer.getType() == TrainerTypeEnum.MasterTrainer) {
					this.masterTrainerModel = new TrainerModel(trainer);
					return null;
				}
				return new TrainerModel(trainer);
		}, trainer -> trainer != null);
		this.milestones = classBatch.getMilestones();
		this.curriculumnModel = new CurriculumnModel(classBatch.getCurriculumn());
		this.auditModels = Converter.convertList(classBatch.getAudits(), audit -> 
				new AuditModel(audit));
		this.traineeModels = Converter.convertList(classBatch.getTrainees(), trainee -> 
				new TraineeModel(trainee));
		this.subjectTypeModel = new SubjectTypeModel(classBatch.getSubjectType());
		this.weightedNumber = classBatch.getWeightedNumber();
		this.history = classBatch.getHistory();
		this.status = classBatch.getStatus();
		this.remarks = classBatch.getRemarks();
		this.classTypeModel = new ClassTypeModel(classBatch.getClassType());
		this.skillModel = new SkillModel(classBatch.getSkill());
		this.positionModel = new PositionModel(classBatch.getPosition());
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

	public Integer getPlannedTraineeNumber() {
		return plannedTraineeNumber;
	}

	public void setPlannedTraineeNumber(Integer plannedTraineeNumber) {
		this.plannedTraineeNumber = plannedTraineeNumber;
	}

	public Long getEstimatedBudget() {
		return estimatedBudget;
	}

	public void setEstimatedBudget(Long estimatedBudget) {
		this.estimatedBudget = estimatedBudget;
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

	public Integer getMilestones() {
		return milestones;
	}

	public void setMilestones(Integer milestones) {
		this.milestones = milestones;
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

	public String getDetailLocation() {
		return detailLocation;
	}

	public void setDetailLocation(String detailLocation) {
		this.detailLocation = detailLocation;
	}

	public BudgetCodeEnum getBudgetCode() {
		return budgetCode;
	}

	public void setBudgetCode(BudgetCodeEnum budgetCode) {
		this.budgetCode = budgetCode;
	}

	public ClassBatchStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ClassBatchStatusEnum status) {
		this.status = status;
	}

	public CurriculumnModel getCurriculumnModel() {
		return curriculumnModel;
	}

	public void setCurriculumnModel(CurriculumnModel curriculumnModel) {
		this.curriculumnModel = curriculumnModel;
	}

	public LocationModel getLocationModel() {
		return locationModel;
	}

	public void setLocationModel(LocationModel locationModel) {
		this.locationModel = locationModel;
	}

	public SubjectTypeModel getSubjectTypeModel() {
		return subjectTypeModel;
	}

	public void setSubjectTypeModel(SubjectTypeModel subjectTypeModel) {
		this.subjectTypeModel = subjectTypeModel;
	}

	public SubSubjectTypeModel getSubSubjectTypeModel() {
		return subSubjectTypeModel;
	}

	public void setSubSubjectTypeModel(SubSubjectTypeModel subSubjectTypeModel) {
		this.subSubjectTypeModel = subSubjectTypeModel;
	}

	public DeliveryTypeModel getDeliveryTypeModel() {
		return deliveryTypeModel;
	}

	public void setDeliveryTypeModel(DeliveryTypeModel deliveryTypeModel) {
		this.deliveryTypeModel = deliveryTypeModel;
	}

	public ScopeModel getScopeModel() {
		return scopeModel;
	}

	public void setScopeModel(ScopeModel scopeModel) {
		this.scopeModel = scopeModel;
	}

	public FormatTypeModel getFormatTypeModel() {
		return formatTypeModel;
	}

	public void setFormatTypeModel(FormatTypeModel formatTypeModel) {
		this.formatTypeModel = formatTypeModel;
	}

	public SupplierPartnerModel getSupplierPartnerModel() {
		return supplierPartnerModel;
	}

	public void setSupplierPartnerModel(SupplierPartnerModel supplierPartnerModel) {
		this.supplierPartnerModel = supplierPartnerModel;
	}

	public List<ClassAdminModel> getClassAdminModels() {
		return classAdminModels;
	}

	public void setClassAdminModels(List<ClassAdminModel> classAdminModels) {
		this.classAdminModels = classAdminModels;
	}

	public List<BudgetModel> getBudgetModels() {
		return budgetModels;
	}

	public void setBudgetModels(List<BudgetModel> budgetModels) {
		this.budgetModels = budgetModels;
	}

	public TrainerModel getMasterTrainerModel() {
		return masterTrainerModel;
	}

	public void setMasterTrainerModel(TrainerModel masterTrainerModel) {
		this.masterTrainerModel = masterTrainerModel;
		this.masterTrainerModel.setType(TrainerTypeEnum.MasterTrainer);
	}

	public List<TrainerModel> getTrainerModels() {
		return trainerModels;
	}

	public void setTrainerModels(List<TrainerModel> trainerModels) {
		this.trainerModels = Converter.convertList(trainerModels, trainerModel -> {
			trainerModel.setType(TrainerTypeEnum.Trainer);
			return trainerModel;
	});
	}

	public List<AuditModel> getAuditModels() {
		return auditModels;
	}

	public void setAuditModels(List<AuditModel> auditModels) {
		this.auditModels = auditModels;
	}

	public List<TraineeModel> getTraineeModels() {
		return traineeModels;
	}

	public void setTraineeModels(List<TraineeModel> traineeModels) {
		this.traineeModels = traineeModels;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public ClassTypeModel getClassTypeModel() {
		return classTypeModel;
	}

	public void setClassTypeModel(ClassTypeModel classTypeModel) {
		this.classTypeModel = classTypeModel;
	}

	public SkillModel getSkillModel() {
		return skillModel;
	}

	public void setSkillModel(SkillModel skillModel) {
		this.skillModel = skillModel;
	}

	public PositionModel getPositionModel() {
		return positionModel;
	}

	public void setPositionModel(PositionModel positionModel) {
		this.positionModel = positionModel;
	}

	@Override
	public String toString() {
		return "ClassBatchModel"
				+ "classId: " + classId + "\n"
				+ "className: " + className + "\n"
				+ "classCode: " + classCode + "\n"
				+ "expectedStartDate: " + expectedStartDate + "\n"
				+ "expectedEndDate: " + expectedEndDate + "\n"
				+ "plannedTraineeNumber: " + plannedTraineeNumber + "\n"
				+ "estimatedBudget: " + estimatedBudget + "\n"
				+ "actualStartDate: " + actualStartDate + "\n"
				+ "actualEndDate: " + actualEndDate + "\n"
				+ "acceptedTraineeNumber: " + acceptedTraineeNumber + "\n"
				+ "actualTraineeNumber: " + actualTraineeNumber + "\n"
				+ "milestones: " + milestones + "\n"
				+ "weightedNumber: " + weightedNumber + "\n"
				+ "history: " + history + "\n"
				+ "detailLocation: " + detailLocation + "\n"
				+ "budgetCode: " + budgetCode + "\n"
				+ "status: " + status + "\n"
				+ "curriculumnModel: " + curriculumnModel + "\n"
				+ "locationModel: " + locationModel + "\n"
				+ "subjectTypeModel: " + subjectTypeModel + "\n"
				+ "subSubjectTypeModel: " + subSubjectTypeModel + "\n"
				+ "deliveryTypeModel: " + deliveryTypeModel + "\n"
				+ "scopeModel: " + scopeModel + "\n"
				+ "formatTypeModel: " + formatTypeModel + "\n"
				+ "supplierPartnerModel: " + supplierPartnerModel + "\n"
				+ "classAdminModels: " + classAdminModels + "\n"
				+ "budgetModels: " + budgetModels + "\n"
				+ "masterTrainerModel: " + masterTrainerModel + "\n"
				+ "trainerModels: " + trainerModels + "\n"
				+ "auditModels: " + auditModels + "\n"
				+ "traineeModels: " + traineeModels + "\n"
				+ "classType: " + classTypeModel + "\n"
				+ "skill: " + skillModel + "\n"
				+ "position: " + positionModel + "\n"
				+ "remarks: " + remarks + "\n";
	}
	
}
