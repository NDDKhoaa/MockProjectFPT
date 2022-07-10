package fa.mockproject.service.impl;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import fa.mockproject.entity.ClassBatch;
import fa.mockproject.entity.DashboardData;
import fa.mockproject.entity.Location;
import fa.mockproject.entity.Skill;
import fa.mockproject.entity.Trainee;
import fa.mockproject.entity.enumtype.ClassBatchStatusEnum;
import fa.mockproject.entity.enumtype.ClassManagementActionEnum;
import fa.mockproject.entity.enumtype.WeightedNumberEnum;
import fa.mockproject.model.AuditModel;
import fa.mockproject.model.BudgetModel;
import fa.mockproject.model.ClassAdminModel;
import fa.mockproject.model.ClassBatchModel;
import fa.mockproject.model.ClassTypeModel;
import fa.mockproject.model.DeliveryTypeModel;
import fa.mockproject.model.FormatTypeModel;
import fa.mockproject.model.LocationModel;
import fa.mockproject.model.PositionModel;
import fa.mockproject.model.ScopeModel;
import fa.mockproject.model.SkillModel;
import fa.mockproject.model.SubSubjectTypeModel;
import fa.mockproject.model.SubjectTypeModel;
import fa.mockproject.model.TraineeModel;
import fa.mockproject.model.TrainerModel;
import fa.mockproject.repository.ClassBatchRepository;
import fa.mockproject.repository.PositionRepository;
import fa.mockproject.repository.SkillRepository;
import fa.mockproject.service.AuditService;
import fa.mockproject.service.BudgetService;
import fa.mockproject.service.ClassAdminService;
import fa.mockproject.service.ClassBatchService;
import fa.mockproject.service.ClassTypeService;
import fa.mockproject.service.CurriculumnService;
import fa.mockproject.service.DeliveryTypeService;
import fa.mockproject.service.FormatTypeService;
import fa.mockproject.service.LocationService;
import fa.mockproject.service.PositionService;
import fa.mockproject.service.ScopeService;
import fa.mockproject.service.SkillService;
import fa.mockproject.service.SubSubjectTypeService;
import fa.mockproject.service.SubjectTypeService;
import fa.mockproject.service.TraineeService;
import fa.mockproject.service.TrainerService;
import fa.mockproject.util.ClassManagementConstant;
import fa.mockproject.util.Converter;

@Service
public class ClassBatchServiceImpl implements ClassBatchService {
	
	@Autowired
	ResourceBundleMessageSource messageSource;
	@Autowired
	private ClassBatchRepository classBatchRepository;
	@Autowired
	private BudgetService budgetService;
	@Autowired
	private AuditService auditService;
	@Autowired
	private TrainerService trainerService;
	@Autowired
	private SkillRepository skillRepository;
	@Autowired
	private PositionRepository positionRepository;
	@Autowired
	private CurriculumnService curriculumnService;
	@Autowired
	private ClassAdminService classAdminService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private SubjectTypeService subjectTypeService;
	@Autowired
	private SubSubjectTypeService subSubjectTypeService;
	@Autowired
	private DeliveryTypeService deliveryTypeService;
	@Autowired
	private FormatTypeService formatTypeService;
	@Autowired
	private ScopeService scopeService;
	@Autowired
	private ClassTypeService classTypeService;
	@Autowired
	private SkillService skillService;
	@Autowired
	private PositionService positionService;
	
	@Override
	public void getClasses(Model model, Map<String, String> filters) {
		Integer pageSize = (Integer) convertRequestParam(Integer.class, filters.get("pageSize"));
		Integer pageIndex = (Integer) convertRequestParam(Integer.class, filters.get("pageIndex"));
		String locationId = (String) convertRequestParam(String.class, filters.get("locationId"));
		String className = (String) convertRequestParam(String.class, filters.get("className"));
		ClassBatchStatusEnum status = (ClassBatchStatusEnum) convertRequestParam(ClassBatchStatusEnum.class, filters.get("status"));
		LocalDate actualStartDate = (LocalDate) convertRequestParam(LocalDate.class, filters.get("actualStartDate"));
		LocalDate actualEndDate = (LocalDate) convertRequestParam(LocalDate.class, filters.get("actualEndDate"));
		
		Specification<ClassBatch> specification = Specification.where(alwaysTrue());
		if (locationId != null) {
			specification = specification.and(locationEqual(locationId));
		}
		if (className != null) {
			specification = specification.and(nameLike(className));
		}
		if (status != null) {
			specification = specification.and((statusLike(status)));
		}
		if (actualStartDate != null) {
			specification = specification.and(fromDate(actualStartDate));
		}
		if (actualEndDate != null) {
			specification = specification.and(toDate(actualEndDate));
		}
		
		pageIndex = pageIndex == null ? 1 : pageIndex;
		pageSize = pageSize == null ? ClassManagementConstant.CLASS_LIST_PAGE_SIZE.get(0) : pageSize;
		
		Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);
		Page<ClassBatch> page = classBatchRepository.findAll(specification, pageable);
		
		List<ClassBatchModel> classBatchModels = new ArrayList<ClassBatchModel>();
		page.getContent().forEach(classBatch -> {
			classBatchModels.add(new ClassBatchModel(classBatch));
		});
		
		List<LocationModel> locationModels = locationService.getAll();
		List<String> classNames = classBatchRepository.findAllClassName();
		
		int totalPages = page.getTotalPages();
		totalPages = totalPages == 0 ? 1 : totalPages;
		pageIndex = page.getNumber() + 1;
		pageSize = page.getSize();
		
		model.addAttribute("classBatchModels", classBatchModels);
		model.addAttribute("totalElements", page.getTotalElements());
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("pageIndex", pageIndex);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("locationModels", locationModels);
		model.addAttribute("classNames", classNames);
		
		if (classBatchModels == null || classBatchModels.size() == 0) {
			model.addAttribute("modal", "warningModal");
			model.addAttribute("message", messageSource.getMessage("msg8", null, null));
		}
	}

	@Override
	public ClassBatchModel getEmptyClass() {
		ClassBatchModel classBatchModel = new ClassBatchModel();
		classBatchModel.setTrainerModels(new ArrayList<TrainerModel>());
		classBatchModel.setBudgetModels(new ArrayList<BudgetModel>());
		classBatchModel.setAuditModels(new ArrayList<AuditModel>());
		
		classBatchModel.getBudgetModels().add(new BudgetModel());
		classBatchModel.getAuditModels().add(new AuditModel());
		return classBatchModel;
	}
	
	@Override
	public void getClassBaseData(Model model) {
		List<LocationModel> locationModels = locationService.getAll();
		List<ClassAdminModel> classAdminModels = classAdminService.getAllProfile();
		List<SubjectTypeModel> subjectTypeModels = subjectTypeService.getAll();
		List<SubSubjectTypeModel> subSubjectTypeModels = subSubjectTypeService.getAll();
		List<DeliveryTypeModel> deliveryTypeModels = deliveryTypeService.getAll();
		List<FormatTypeModel> formatTypeModels = formatTypeService.getAll();
		List<ScopeModel> scopeModels = scopeService.getAll();
		List<TrainerModel> trainerModels = trainerService.getAllProfile();
		List<ClassTypeModel> classTypeModels = classTypeService.getAll();
		List<SkillModel> skillModels = skillService.getAll();
		List<PositionModel> positionModels = positionService.getAll();
		
		model.addAttribute("locationModels", locationModels);
		model.addAttribute("classAdminModels", classAdminModels);
		model.addAttribute("subjectTypeModels", subjectTypeModels);
		model.addAttribute("subSubjectTypeModels", subSubjectTypeModels);
		model.addAttribute("deliveryTypeModels", deliveryTypeModels);
		model.addAttribute("formatTypeModels", formatTypeModels);
		model.addAttribute("scopeModels", scopeModels);
		model.addAttribute("trainerModels", trainerModels);
		model.addAttribute("classTypeModels", classTypeModels);
		model.addAttribute("skillModels", skillModels);
		model.addAttribute("positionModels", positionModels);
	}

	@Override
	public ClassBatchModel getClazz(String classId) {
		ClassBatchModel classBatchModel = null;
		ClassBatch classBatch = null;
		try {
			classBatch = classBatchRepository.getOne(Long.parseLong(classId));
			classBatchModel = new ClassBatchModel(classBatch);
			return classBatchModel;	
		} catch(NumberFormatException | EntityNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ClassBatchStatusEnum getClassStatus(String classId) {
		try {
			return classBatchRepository.findStatusByClassId(Long.parseLong(classId));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void getClassTrainees(Model model, Map<String, String> filters) {
		Long classId = (Long) convertRequestParam(Long.class, filters.get("classId"));
		Integer pageSize = (Integer) convertRequestParam(Integer.class, filters.get("pageSize"));
		Integer pageIndex = (Integer) convertRequestParam(Integer.class, filters.get("pageIndex"));
		
		classId = classId == null ? 0 : classId;
		pageIndex = pageIndex == null ? 1 : pageIndex;
		pageSize = pageSize == null ? ClassManagementConstant.CLASS_LIST_PAGE_SIZE.get(0) : pageSize;
		
		if(classBatchRepository.findById(classId).isEmpty()) {
			model.addAttribute("traineeModels", new ArrayList<TraineeModel>());
			model.addAttribute("tab", "trainee");
			model.addAttribute("totalElements", 0);
			model.addAttribute("totalPages", 1);
			model.addAttribute("pageIndex", 1);
			model.addAttribute("pageSize", pageSize);
			model.addAttribute("modal", "messageModal");
			model.addAttribute("message", messageSource.getMessage("msg55", null, null));
		}
		
		Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);
		Page<Trainee> page = classBatchRepository.findTraineeByClassId(classId, pageable);
		
		int totalPages = page.getTotalPages();
		totalPages = totalPages == 0 ? 1 : totalPages;
		pageIndex = page.getNumber() + 1;
		pageSize = page.getSize();
		
		List<TraineeModel> traineeModels = Converter.convertList(page.getContent(), trainee -> new TraineeModel(trainee));
		
		model.addAttribute("traineeModels", traineeModels);
		model.addAttribute("tab", "trainee");
		model.addAttribute("totalElements", page.getTotalElements());
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("pageIndex", pageIndex);
		model.addAttribute("pageSize", pageSize);
	}
	
	@Override
	public ClassBatchModel createClass(ClassBatchModel classBatchModel) {
		ClassBatch classBatch;
		try {
			if (classBatchModel.getBudgetModels() != null && classBatchModel.getBudgetModels().size() == 1 && classBatchModel.getBudgetModels().get(0).isEmpty()) {
				classBatchModel.getBudgetModels().clear();
			}
			if (classBatchModel.getAuditModels() != null && classBatchModel.getAuditModels().size() == 1 && classBatchModel.getAuditModels().get(0).isEmpty()) {
				classBatchModel.getAuditModels().clear();
			}
			classBatch = new ClassBatch(classBatchModel);
			classBatch.setClassCode(createClassCode(classBatch));
			classBatch.setClassName(createClassName(classBatch));
			classBatch.setStatus(ClassBatchStatusEnum.Draft);
			classBatch.setHistory(createHistory(ClassManagementActionEnum.Create));
			classBatch = classBatchRepository.save(classBatch);
			classBatchModel.setAll(classBatch);
			// Send email
			return classBatchModel;
		} catch (IOException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean validateClass(ClassBatchModel classBatchModel, BindingResult result) {
		if (result.hasGlobalErrors()) {
			return false;
		}
		
		return !result.getFieldErrors().stream().anyMatch(error -> {
			if (!error.getField().equals("auditModels") && !error.getField().equals("budgetModels")) {
				return true;				
			}
			if (error.getField().equals("auditModels")) {
				List<AuditModel> auditModels = classBatchModel.getAuditModels();
				if (auditModels.size() == 0 || (auditModels.size() == 1 && auditModels.get(0).isEmpty())) {
					return false;
				}
			}
			if (error.getField().equals("budgetModels")) {
				List<BudgetModel> budgetModels = classBatchModel.getBudgetModels();
				if (budgetModels.size() == 0 || (budgetModels.size() == 1 && budgetModels.get(0).isEmpty())) {
					return false;
				}
			}
			return false;
		});
	}
	
	@Override
	public boolean updateClass(ClassBatchModel classBatchModel) {
		if (classBatchModel.getCurriculumnModel().getUpdateState() == 0) {
			classBatchModel.setCurriculumnModel(curriculumnService.getOne(classBatchModel.getCurriculumnModel().getCurriculumnId()));
		}
		if (classBatchModel.getBudgetModels() != null && classBatchModel.getBudgetModels().size() == 1 && classBatchModel.getBudgetModels().get(0).isEmpty()) {
			classBatchModel.getBudgetModels().clear();
		}
		if (classBatchModel.getAuditModels() != null && classBatchModel.getAuditModels().size() == 1 && classBatchModel.getAuditModels().get(0).isEmpty()) {
			classBatchModel.getAuditModels().clear();
		}
		if (classBatchModel.getStatus() == ClassBatchStatusEnum.InProgress) {
			return this.updateInprogressClass(classBatchModel);
		}
		else {
			return this.updateDraftClass(classBatchModel);
		}
	}
	
	@Override
	public boolean updateDraftClass(ClassBatchModel classBatchModel) {
		ClassBatch classBatch;
		try {
			classBatch = new ClassBatch(classBatchModel);
			classBatch.setClassCode(createClassCode(classBatch));
			classBatch.setClassName(createClassName(classBatch));
			classAdminService.updateAllClassAdminOfOneClass(classBatch);
			trainerService.updateAllTrainerOfOneClass(classBatch);
			budgetService.updateAllBudgetOfOneClass(classBatch);
			System.out.println(classBatch);
			classBatchRepository.save(classBatch);
			// Send email
			return true;
		} catch (IOException | IllegalArgumentException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	@Override
	public boolean updateInprogressClass(ClassBatchModel classBatchModel) {
		classBatchModel.setHistory(createHistory(ClassManagementActionEnum.Update));
		ClassBatch classBatch;
		try {
			classBatch = new ClassBatch(classBatchModel);
			auditService.updateAllAuditOfOneClass(classBatch);
			classBatchRepository.save(classBatch);
			// Send email
			return true;
			
		} catch (IOException | IllegalArgumentException e) {
			e.printStackTrace();
		}	
		return false;
	}

	@Override
	public boolean changeClassState(String classId, ClassManagementActionEnum action) {
		return changeClassState(classId, action, null);
	}
	
	@Override
	public boolean changeClassState(String classId, ClassManagementActionEnum action, String remark) {
		if (action == null) {
			return false;
		}
		
		try {
			ClassBatchStatusEnum classStatus = classBatchRepository.findStatusByClassId(Long.parseLong(classId));
			if (ClassManagementConstant.CLASS_PRE_CONDITION.get(action).contains(classStatus)) {
				if (classBatchRepository
						.updateStatus(Long.parseLong(classId), action.getStatusAfterAction().toString(),createHistory(action), remark) == 0) {
					return false;
				}
				// Send email
				return true;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean addTrainee(Long classId, List<Long> traineeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeTrainee(Long classId, List<Long> traineeId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private String createHistory(ClassManagementActionEnum action) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ClassManagementConstant.HISTORY_DATE_FORMAT);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication != null ? authentication.getName() : "";
		
		return LocalDate.now().format(formatter) + " - " + action.getPast() + " by " + currentUserName;
	}

	private String createClassCode(ClassBatch classBatch) {
		classBatch.setSkill(skillRepository.getOne(classBatch.getSkill().getSkillId()));
		
		String saperate = "_";
		String site = classBatch.getLocation().getLocationId();
		String classType = classBatch.getClassType().getClassTypeId();
		String skill = classBatch.getSkill().getSkillName();
		// Update feature in future
		String skillSerialNumber = "01";
		int year = LocalDate.now().getYear() % 100;
		
		return site + saperate + 
				classType + saperate + 
				skill + saperate +
				year + saperate +
				skillSerialNumber;
	}
	
	private String createClassName(ClassBatch classBatch) {
		classBatch.setSkill(skillRepository.getOne(classBatch.getSkill().getSkillId()));
		classBatch.setPosition(positionRepository.getOne(classBatch.getPosition().getPositionId()));
		
		String saperate = " ";
		String prefix = "Fresher";
		String position = classBatch.getPosition().getPositionName();
		String skill = classBatch.getSkill().getSkillName();
		
		return prefix + saperate +
				position + saperate +
				skill;
	}
	
	private Specification<ClassBatch> alwaysTrue() {
		return (classBatch, cq, cb) -> cb.greaterThanOrEqualTo(classBatch.get("classId"), 0);
	}
	
	private Specification<ClassBatch> locationEqual(String locationId) {
		return (classBatch, cq, cb) -> cb.equal(classBatch.get("location").get("locationId"), locationId);
	}
	
	private Specification<ClassBatch> nameLike(String className) {
		return (classBatch, cq, cb) -> cb.equal(classBatch.get("className"), className);
	}
	
	private Specification<ClassBatch> statusLike(ClassBatchStatusEnum status) {
		return (classBatch, cq, cb) -> cb.equal(classBatch.get("status"), status);
	}
	
	private Specification<ClassBatch> fromDate(LocalDate actualStartDate) {
		return (classBatch, cq, cb) -> cb.greaterThanOrEqualTo(classBatch.get("actualStartDate"), actualStartDate);
	}
	
	private Specification<ClassBatch> toDate(LocalDate actualEndDate) {
		return (classBatch, cq, cb) -> cb.lessThanOrEqualTo(classBatch.get("actualEndDate"), actualEndDate);
	}
	
	@SuppressWarnings("unchecked")
	private Object convertRequestParam(@SuppressWarnings("rawtypes") Class type, String value) {
		if (type.isAssignableFrom(String.class)) {
			if (value == null || value.trim().equals("")) {
				return null;				
			}
			return value;
		}
		if (type.isAssignableFrom(Integer.class)) {
			try {
				return Integer.parseInt(value);
			} catch (NumberFormatException e) {
				return null;
			}
		}
		if (type.isAssignableFrom(Long.class)) {
			try {
				return Long.parseLong(value);
			} catch (NumberFormatException e) {
				return null;
			}
		}
		if (type.isAssignableFrom(ClassBatchStatusEnum.class)) {
			try {
				return ClassBatchStatusEnum.valueOf(value);
			} catch (IllegalArgumentException | NullPointerException e) {
				return null;
			}
		}
		if (type.isAssignableFrom(LocalDate.class)) {
			try {
				return LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			} catch (DateTimeParseException | NullPointerException e) {
				return null;
			}
		}
		
		return null;
	}

	/** 
	 * @param weightedNumber: W-X-Y-Z
	 * 		W: Weighted number for Academic Mark.
	 * 		X: Weighted number for Disciplinary Point.
	 * 		Y: Weighted number for Bonus Point.
	 * 		Z: Weighted number for Penalty point. 
	 * @return Map<String, Integer>
	 */
	@Override
	public Map<WeightedNumberEnum, Integer> convertWeightedNumber(String weightedNumber) {
		Map<WeightedNumberEnum, Integer> weightedNumberMap = new HashMap<WeightedNumberEnum, Integer>();
		int weightedNumberQuantity = ClassManagementConstant.WEIGHTED_NUMBER_FORMAT.size();
		if (weightedNumber == null) {
			return weightedNumberMap;
		}
		String[] weightedArr = weightedNumber.split(ClassManagementConstant.WEIGHTED_NUMBER_DELIMITER);
		if (weightedArr.length != weightedNumberQuantity) {
			return weightedNumberMap;
		}
		for (int i = 0; i < weightedNumberQuantity; i++) {
			try {
				weightedNumberMap.put(ClassManagementConstant.WEIGHTED_NUMBER_FORMAT.get(i), Integer.parseInt(weightedArr[i]));
			} catch (NumberFormatException e) {
				weightedNumberMap.clear();
				break;
			}
		}
		return weightedNumberMap;
	}

	@Override
	public List<DashboardData> getListTrainee(Location location, ClassBatchStatusEnum status) {
		List<ClassBatch> classBatches = new ArrayList<>();
		List<Trainee> trainees = new ArrayList<>();
		if (location == null && status == null) {
			classBatches = classBatchRepository.findAll();
		} else {
			classBatches = classBatchRepository.findByLocationAndStatus(location, status);
		}
		if (location == null) {
			classBatches = classBatchRepository.findByStatus(status);
		}
		if (status == null) {
			classBatches = classBatchRepository.findByLocation(location);
		}
		for (ClassBatch classBatch : classBatches) {
			trainees.addAll(classBatch.getTrainees());
		}
		Map<String, Integer> stringIntegerMap = new HashMap<>();
		for (Trainee trainee : trainees) {
			Skill skill = trainee.getTraineeCandidateProfile().getSkill();
			String skillName = skill.getSkillName();
			if (stringIntegerMap.containsKey(skillName)) {
				int value = stringIntegerMap.get(skillName) + 1;
				stringIntegerMap.put(skillName, value);
			} else {
				stringIntegerMap.put(skillName, 1);
			}
		}
		return stringIntegerMap.entrySet().stream().map(
				stringIntegerEntry -> new DashboardData(stringIntegerEntry.getKey(),
						stringIntegerEntry.getValue())).collect(Collectors.toList());
	}

}
