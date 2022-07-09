package fa.mockproject.service.impl;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.util.Pair;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import fa.mockproject.entity.ClassBatch;
import fa.mockproject.entity.enumtype.ClassBatchStatusEnum;
import fa.mockproject.entity.enumtype.ClassManagementActionEnum;
import fa.mockproject.entity.enumtype.WeightedNumberEnum;
import fa.mockproject.model.AuditModel;
import fa.mockproject.model.BudgetModel;
import fa.mockproject.model.ClassBatchModel;
import fa.mockproject.repository.AuditRepository;
import fa.mockproject.repository.BudgetRepository;
import fa.mockproject.repository.ClassBatchRepository;
import fa.mockproject.repository.ClassTypeRepository;
import fa.mockproject.repository.LocationRepository;
import fa.mockproject.repository.PositionRepository;
import fa.mockproject.repository.SkillRepository;
import fa.mockproject.repository.TrainerRepository;
import fa.mockproject.service.AuditService;
import fa.mockproject.service.BudgetService;
import fa.mockproject.service.ClassAdminService;
import fa.mockproject.service.ClassBatchService;
import fa.mockproject.service.CurriculumnService;
import fa.mockproject.service.TrainerService;
import fa.mockproject.util.ClassManagementConstant;

@Service
public class ClassBatchServiceImpl implements ClassBatchService {
	
	@Autowired
	private ClassBatchRepository classBatchRepository;
	@Autowired
	private BudgetService budgetService;
	@Autowired
	private AuditService auditService;
	@Autowired
	private TrainerService trainerService;
	@Autowired
	private BudgetRepository budgetRepository;
	@Autowired
	private AuditRepository auditRepository;
	@Autowired
	private TrainerRepository trainerRepository;
	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private ClassTypeRepository classTypeRepository;
	@Autowired
	private SkillRepository skillRepository;
	@Autowired
	private PositionRepository positionRepository;
	@Autowired
	private CurriculumnService curriculumnService;
	@Autowired
	private ClassAdminService classAdminService;
	
	@Override
	public Pair<List<ClassBatchModel>, Page<ClassBatch>> getClassList(Map<String, String> filters) {
		Integer pageSize = (Integer) convertFilterType(Integer.class, filters.get("pageSize"));
		Integer pageIndex = (Integer) convertFilterType(Integer.class, filters.get("pageIndex"));
		String locationId = (String) convertFilterType(String.class, filters.get("locationId"));
		String className = (String) convertFilterType(String.class, filters.get("className"));
		ClassBatchStatusEnum status = (ClassBatchStatusEnum) convertFilterType(ClassBatchStatusEnum.class, filters.get("status"));
		LocalDate actualStartDate = (LocalDate) convertFilterType(LocalDate.class, filters.get("actualStartDate"));
		LocalDate actualEndDate = (LocalDate) convertFilterType(LocalDate.class, filters.get("actualEndDate"));
		
		Specification<ClassBatch> specification = Specification.where(alwaysTrue());
		if (locationId != null) 
			specification.and(locationEqual(locationId));
		if (className != null)
			specification.and(nameLike(className));
		if (status != null)
			specification.and((statusLike(status)));
		if (actualStartDate != null)
			specification.and(fromDate(actualStartDate));
		if (actualEndDate != null)
			specification.and(toDate(actualEndDate));
		
		pageIndex = pageIndex == null ? 1 : pageIndex;
		pageSize = pageSize == null ? ClassManagementConstant.CLASS_LIST_PAGE_SIZE.get(0) : pageSize;
		
		Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);
		Page<ClassBatch> page = classBatchRepository.findAll(specification, pageable);
		
		List<ClassBatchModel> classBatchModels = new ArrayList<ClassBatchModel>();
		page.getContent().forEach(classBatch -> {
			classBatchModels.add(new ClassBatchModel(classBatch));
		});
		
		return Pair.of(classBatchModels, page);
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
	public List<String> getAllClassNames() {
		return classBatchRepository.findAllClassName();
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
	private Object convertFilterType(@SuppressWarnings("rawtypes") Class type, String value) {
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
}
