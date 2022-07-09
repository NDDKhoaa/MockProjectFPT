package fa.mockproject.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.util.Pair;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fa.mockproject.entity.ClassBatch;
import fa.mockproject.entity.enumtype.ClassBatchStatusEnum;
import fa.mockproject.entity.enumtype.ClassManagementActionEnum;
import fa.mockproject.entity.enumtype.ClassManagementActionResultEnum;
import fa.mockproject.entity.enumtype.ClassViewMode;
import fa.mockproject.model.AuditModel;
import fa.mockproject.model.BudgetModel;
import fa.mockproject.model.ClassAdminModel;
import fa.mockproject.model.ClassBatchModel;
import fa.mockproject.model.ClassTypeModel;
import fa.mockproject.model.CurriculumnModel;
import fa.mockproject.model.DeliveryTypeModel;
import fa.mockproject.model.FormatTypeModel;
import fa.mockproject.model.LocationModel;
import fa.mockproject.model.PositionModel;
import fa.mockproject.model.ScopeModel;
import fa.mockproject.model.SkillModel;
import fa.mockproject.model.SubSubjectTypeModel;
import fa.mockproject.model.SubjectTypeModel;
import fa.mockproject.model.TrainerModel;
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
import fa.mockproject.service.TrainerService;
import fa.mockproject.util.ClassManagementConstant;
import net.bytebuddy.implementation.bytecode.constant.ClassConstant;

@Controller
public class ClassManagementController {
	
	@Autowired
	ResourceBundleMessageSource messageSource;
	@Autowired
	ClassBatchService classBatchService;
	@Autowired
	LocationService locationService;
	@Autowired
	ClassAdminService classAdminService;
	@Autowired
	SubjectTypeService subjectTypeService;
	@Autowired
	SubSubjectTypeService subSubjectTypeService;
	@Autowired
	DeliveryTypeService deliveryTypeService;
	@Autowired
	FormatTypeService formatTypeService;
	@Autowired
	ScopeService scopeService;
	@Autowired
	TrainerService trainerService;
	@Autowired
	BudgetService budgetService;
	@Autowired
	AuditService auditService;
	@Autowired
	ClassTypeService classTypeService;
	@Autowired
	SkillService skillService;
	@Autowired
	PositionService positionService;
	@Autowired
	CurriculumnService curriculumnService;
	
	@GetMapping({"/classes", "/classes/view"})
	public String getClassList(Model model, @RequestParam Map<String, String> params) {
		
		Pair<List<ClassBatchModel>, Page<ClassBatch>> pair = classBatchService.getClassList(params);
		List<ClassBatchModel> classBatchModels = pair.getFirst();
		
		List<LocationModel> locationModels = locationService.getAll();
		List<String> classNames = classBatchService.getAllClassNames();
		
		model.addAttribute("classBatchModels", classBatchModels);
		model.addAttribute("totalElements", pair.getSecond().getTotalElements());
		model.addAttribute("totalPage", pair.getSecond().getTotalPages());
		model.addAttribute("pageIndex", pair.getSecond().getNumber() + 1);
		model.addAttribute("pageSize", pair.getSecond().getSize());
		model.addAttribute("locationModels", locationModels);
		model.addAttribute("classNames", classNames);
//		model.addAttribute("classListPageSize", ClassManagementConstant.CLASS_LIST_PAGE_SIZE);
		
		if (classBatchModels == null || classBatchModels.size() == 0) {
			model.addAttribute("showModal", true);
			model.addAttribute("message", messageSource.getMessage("msg8", null, null));			
		}
		
		return "classManagement/classList";
	}
	
	@GetMapping("/classes/view/{classId}")
	public String getClass(Model model, @PathVariable(required = true) String classId) {

		ClassBatchModel classBatchModel = classBatchService.getClazz(classId);
		if (classBatchModel == null) {
			return "redirect:/classes";
		}
		
		List<ClassManagementActionEnum> actionables = new ArrayList<ClassManagementActionEnum>();
		ClassManagementConstant.CLASS_PRE_CONDITION.forEach((ClassManagementActionEnum action, List<ClassBatchStatusEnum> status) -> {
			if (status.contains(classBatchModel.getStatus())) {
				actionables.add(action);
			}
		});
		
		model.addAttribute("classBatchModel", classBatchModel);
		model.addAttribute("curriculumnModel", classBatchModel.getCurriculumnModel());		
		model.addAttribute("viewMode", ClassViewMode.ViewClass);
		model.addAttribute("actionables", actionables);
				
		return "classManagement/classDetail";
	}
	
	@GetMapping(value = "/classes/create")
	public String createNewClass(Model model) {
		
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
		
		ClassBatchModel classBatchModel = new ClassBatchModel();
		classBatchModel.setTrainerModels(new ArrayList<TrainerModel>());
		classBatchModel.setBudgetModels(new ArrayList<BudgetModel>());
		classBatchModel.setAuditModels(new ArrayList<AuditModel>());
		
		classBatchModel.getBudgetModels().add(new BudgetModel());
		classBatchModel.getAuditModels().add(new AuditModel());
		
		model.addAttribute("classBatchModel", classBatchModel);
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
		model.addAttribute("viewMode", ClassViewMode.CreateClass);
		model.addAttribute("action", ClassManagementActionEnum.Create);

		return "classManagement/classDetail";
	}
	
	@PostMapping(value = "/classes/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public String createNewClass(Model model, 
			@ModelAttribute("classBatchModel") @Valid ClassBatchModel classBatchModel, 
			BindingResult result,
			@RequestParam(name = "confirm", defaultValue = "false") String confirm) {
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> {
				System.out.println(error.getDefaultMessage());
			});
			model.addAttribute("viewMode", ClassViewMode.CreateClass);
			return "classManagement/classDetail";
		}
		
		if (confirm.equals("false")) {
			model.addAttribute("message", messageSource.getMessage(
					"msg53", 
					new Object[] {ClassManagementActionEnum.Submit.toString().toLowerCase()},
					null));
			return "modals/confirmModal";
		}
		
		ClassBatchModel savedClassBatchModel = classBatchService.createClass(classBatchModel);
		
		if (savedClassBatchModel == null) {
			model.addAttribute("message", messageSource.getMessage(
					"msg50", 
					new Object[] {ClassManagementActionEnum.Create}, 
					null));
			return "modals/errorModal";
		}
		
		model.addAttribute("message", messageSource.getMessage("msg54", 
				new Object[] {ClassManagementActionEnum.Create}, 
				null));
		model.addAttribute("redirect", "/classes/view/" + savedClassBatchModel.getClassId());
		model.addAttribute("redirectDelay", 1000);
		
		return "modals/messageModal";
	}

	@GetMapping(value = "/classes/update/{classId}")
	public String updateClass(Model model, @PathVariable(required = true) String classId) {
		
		ClassBatchStatusEnum classStatus = classBatchService.getClassStatus(classId);
		
		if (classStatus == null) {
			model.addAttribute("message", messageSource.getMessage("msg51", null, null));
			return "modals/errorModal";
		}
		
		if (!ClassManagementConstant.CLASS_PRE_CONDITION.get(ClassManagementActionEnum.Update).contains(classStatus)) {
			model.addAttribute("message", messageSource.getMessage("msg52", null, null));
			return "modals/messageModal";
		}
		
		ClassBatchModel classBatchModel = classBatchService.getClazz(classId);
		if ((classBatchModel.getBudgetModels() == null || classBatchModel.getBudgetModels().size() == 0) && classStatus != ClassBatchStatusEnum.InProgress) {
			classBatchModel.setBudgetModels(new ArrayList<>(Arrays.asList(new BudgetModel())));
		}
		if ((classBatchModel.getAuditModels() == null || classBatchModel.getAuditModels().size() == 0) && classStatus == ClassBatchStatusEnum.InProgress) {
			classBatchModel.setAuditModels(new ArrayList<>(Arrays.asList(new AuditModel())));
		}
		
		if (classStatus == ClassBatchStatusEnum.InProgress) {
			model.addAttribute("viewMode", ClassViewMode.UpdateInprogressClass);
		}
		else {
			model.addAttribute("viewMode", ClassViewMode.UpdateDraftClass);
		}
		
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
		
		model.addAttribute("classBatchModel", classBatchModel);
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
		model.addAttribute("action", ClassManagementActionEnum.Update);

		return "classManagement/classDetail";
	}
	
	@PostMapping(value = "/classes/update/{classId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateClass(Model model, 
			@ModelAttribute("classBatchModel") @Valid ClassBatchModel classBatchModel, 
			BindingResult result,
			@PathVariable(required = true) String classId,
			@RequestParam(name = "confirm", defaultValue = "false") String confirm) {
		
		if (result.hasErrors()) {
			// Do Something
			return "classManagement/classDetail";
		}
		
		if (confirm.equals("false")) {
			model.addAttribute("message", messageSource.getMessage(
					"msg53", 
					new Object[] {ClassManagementActionEnum.Submit.toString().toLowerCase()},
					null));
			return "modals/confirmModal";
		}
		
		if (!classBatchService.updateClass(classBatchModel)) {
			model.addAttribute("message", messageSource.getMessage(
					"msg50", 
					new Object[] {ClassManagementActionEnum.Update}, 
					null));
			return "modals/errorModal";
		}
	
		model.addAttribute("message", messageSource.getMessage("msg54", 
				new Object[] {ClassManagementActionEnum.Update}, 
				null));
		model.addAttribute("redirect", "/classes/view/" + classId);
		model.addAttribute("redirectDelay", 1000);
		
		return "modals/messageModal";
	}
	
	@GetMapping(value = "/classes/{action: |^submit$|^reject$|^cancel$|^approve$|^decline$|^accept$|^start$|^finish$|^close$|^request$}/{classId}")
	public String changeClassState(Model model, 
			@PathVariable(required = true) String action,
			@PathVariable(required = true) String classId) {
		
		ClassBatchStatusEnum classStatus = classBatchService.getClassStatus(classId);
		ClassManagementActionEnum actionEnum; 
		
		if (classStatus == null) {
			model.addAttribute("message", messageSource.getMessage("msg51", null, null));
			return "modals/errorModal";
		}
		
		try {
			actionEnum = ClassManagementActionEnum.valueOf(StringUtils.capitalize(action));
		} catch (IllegalArgumentException | NullPointerException e) {
			e.printStackTrace();
			model.addAttribute("message", messageSource.getMessage("msg51", null, null));
			return "modals/errorModal";
		}
		
		if (ClassManagementConstant.CLASS_PRE_CONDITION.get(actionEnum).contains(classStatus)) {
			model.addAttribute("classBatchModel", new ClassBatchModel(Long.parseLong(classId)));
			model.addAttribute("message", messageSource.getMessage(
					"msg53", 
					new Object[] {actionEnum.toString().toLowerCase()},
					null));
			return "modals/confirmModal";
		}
		
		model.addAttribute("message", messageSource.getMessage("msg52", null, null));
		return "modals/messageModal";
	}
	
	@PostMapping(value = "/classes/{action: |^submit$|^reject$|^cancel$|^approve$|^decline$|^accept$|^start$|^finish$|^close$|^request$}/{classId}")
	public String changeClassState(Model model, 
			@PathVariable(required = true) String action,
			@PathVariable(required = true) String classId,
			@RequestParam(name = "remarks", defaultValue = "") String remarks) {
		
		ClassManagementActionEnum actionEnum; 
		
		try {
			actionEnum = ClassManagementActionEnum.valueOf(StringUtils.capitalize(action));
		} catch (IllegalArgumentException | NullPointerException e) {
			e.printStackTrace();
			model.addAttribute("message", messageSource.getMessage("msg51", null, null));
			return "modals/errorModal";
		}
		
		if (!classBatchService.changeClassState(classId, actionEnum, remarks)) {
			model.addAttribute("message", messageSource.getMessage(
					"msg50", 
					new Object[] {actionEnum.toString()}, 
					null));
			return "modals/errorModal";
		}
		
		model.addAttribute("message", messageSource.getMessage("msg54", 
				new Object[] {actionEnum},
				null));
		model.addAttribute("redirect", "/classes/view/" + classId);
		model.addAttribute("redirectDelay", 1000);
		
		return "modals/messageModal";
	}
	
	@GetMapping(value = "/classes/curriculumn/{curriculumnId}", produces = {MediaType.APPLICATION_PDF_VALUE})
	@ResponseBody
	public byte[] downloadCurriculumn(@PathVariable(required = true) String curriculumnId) {
		CurriculumnModel curriculumnModel = curriculumnService.getOne(Long.parseLong(curriculumnId));
		System.out.println(curriculumnModel);
		return curriculumnModel.getContent();
	}
}
