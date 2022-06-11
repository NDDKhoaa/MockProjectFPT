package fa.mockproject.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

public class ClassModel {
	
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	
	private long classId;
	private String className;
	private String classCode;
	private LocalDate expectedStartDate;
	private LocalDate expectedEndDate;
	private LocationModel locationModel;
	private String detailLocation;
	private ClassAdminMOdel classAdminModel;
	private int plannedTraineeNumber;
	private BudgetModel budgetModel;
	private long estimatedBudget;
	private SubSubjectTypeEnum subSubjectType;
	private DeliveryTypeModel deliveryTypeModel;
	private FormatTypeModel formatTypeModel;
	private ScopeModel scopeModel;
	private SupplierPartner supplierPartner;
	private LocalDate actualStartDate;
	private LocalDate actualEndDate;
	private int acceptedTraineeNumber;
	private int actualTraineeNumber;
	private List<Trainer> trainers;
	private int milestones;
	private byte[] curriculum;
	private Audit audit;
	private Trainee trainee;
	private SubjectType subjectType;
	private ClassStatusEnum status;
	private String remarks;

	
}
