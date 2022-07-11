package fa.mockproject.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
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

import fa.mockproject.entity.enumtype.ClassBatchStatusEnum;
import fa.mockproject.entity.enumtype.ClassManagementActionEnum;
import fa.mockproject.entity.enumtype.ClassViewMode;
import fa.mockproject.model.AuditModel;
import fa.mockproject.model.BudgetModel;
import fa.mockproject.model.ClassBatchModel;
import fa.mockproject.model.CurriculumnModel;
import fa.mockproject.service.ClassBatchService;
import fa.mockproject.service.CurriculumnService;
import fa.mockproject.util.ClassManagementConstant;

@Controller
public class ClassManagementController {
	
	@Autowired
	private ResourceBundleMessageSource messageSource;
	@Autowired
	private ClassBatchService classBatchService;
	@Autowired
	private CurriculumnService curriculumnService;
	
	@GetMapping("/classes")
	public String getClassList(Model model, @RequestParam Map<String, String> params) {
		classBatchService.getClasses(model, params);
		return "classManagement/classList";
	}
	
	@GetMapping("/classes/view")
	public String getClass(Model model, @RequestParam(name = "classId", defaultValue = "0") String classId) {

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
	
	@GetMapping("/classes/trainees")
	public String getClassTrainees(Model model, @RequestParam Map<String, String> params) {
		classBatchService.getClassTrainees(model, params);
		return "classManagement/classDetail";
	}
	
	@GetMapping(value = "/classes/create")
	public String createNewClass(Model model) {
		ClassBatchModel classBatchModel = classBatchService.getEmptyClass();
		
		model.addAttribute("classBatchModel", classBatchModel);
		model.addAttribute("viewMode", ClassViewMode.CreateClass);
		model.addAttribute("action", ClassManagementActionEnum.Create);
		
		classBatchService.getClassBaseData(model);

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
		model.addAttribute("redirect", "/classes/view?classId=" + savedClassBatchModel.getClassId());
		model.addAttribute("redirectDelay", 1000);
		
		return "modals/messageModal";
	}

	@GetMapping(value = "/classes/update")
	public String updateClass(Model model, @RequestParam(name = "classId", defaultValue = "0") String classId) {
		
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
		
		model.addAttribute("classBatchModel", classBatchModel);
		model.addAttribute("action", ClassManagementActionEnum.Update);
		
		classBatchService.getClassBaseData(model);

		return "classManagement/classDetail";
	}
	
	@PostMapping(value = "/classes/update/{classId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateClass(Model model, 
			@ModelAttribute("classBatchModel") @Valid ClassBatchModel classBatchModel, 
			BindingResult result,
			@PathVariable(name = "classId") String classId,
			@RequestParam(name = "confirm", defaultValue = "false") String confirm) {
		
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
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
		model.addAttribute("redirect", "/classes/view?classId=" + classId);
		model.addAttribute("redirectDelay", 1000);
		
		return "modals/messageModal";
	}
	
//	@GetMapping(value = "/classes/{action: |^submit$|^reject$|^cancel$|^approve$|^decline$|^accept$|^start$|^finish$|^close$|^request$}")
//	public String changeClassState(Model model, 
//			@PathVariable(required = true) String action,
//			@RequestParam(name = "classId", defaultValue = "0") String classId) {
//		
//		ClassBatchStatusEnum classStatus = classBatchService.getClassStatus(classId);
//		ClassManagementActionEnum actionEnum; 
//		
//		if (classStatus == null) {
//			model.addAttribute("message", messageSource.getMessage("msg51", null, null));
//			return "modals/errorModal";
//		}
//		
//		try {
//			actionEnum = ClassManagementActionEnum.valueOf(StringUtils.capitalize(action));
//		} catch (IllegalArgumentException | NullPointerException e) {
//			e.printStackTrace();
//			model.addAttribute("message", messageSource.getMessage("msg51", null, null));
//			return "modals/errorModal";
//		}
//		
//		if (ClassManagementConstant.CLASS_PRE_CONDITION.get(actionEnum).contains(classStatus)) {
//			model.addAttribute("classBatchModel", new ClassBatchModel(Long.parseLong(classId)));
//			model.addAttribute("message", messageSource.getMessage(
//					"msg53", 
//					new Object[] {actionEnum.toString().toLowerCase()},
//					null));
//			return "modals/confirmModal";
//		}
//		
//		model.addAttribute("message", messageSource.getMessage("msg52", null, null));
//		return "modals/messageModal";
//	}
	
	@GetMapping(value = "/classes/{action: |^submit$|^reject$|^cancel$|^approve$|^decline$|^accept$|^start$|^finish$|^close$|^request$}")
	public String changeClassState(Model model, 
			@PathVariable(required = true) String action,
			@RequestParam(name = "classId") String[] classIds) {
		
		ClassManagementActionEnum actionEnum; 
		
		try {
			actionEnum = ClassManagementActionEnum.valueOf(StringUtils.capitalize(action));
		} catch (IllegalArgumentException | NullPointerException e) {
			e.printStackTrace();
			model.addAttribute("message", messageSource.getMessage("msg51", null, null));
			return "modals/errorModal";
		}
		
		model.addAttribute("message", messageSource.getMessage(
				"msg53", 
				new Object[] {actionEnum.toString().toLowerCase()},
				null));
		return "modals/confirmModal";
	}
	
//	@PostMapping(value = "/classes/{action: |^submit$|^reject$|^cancel$|^approve$|^decline$|^accept$|^start$|^finish$|^close$|^request$}")
//	public String changeClassState(Model model, 
//			@PathVariable(required = true) String action,
//			@RequestParam(name = "classId", defaultValue = "0") String classId,
//			@RequestParam(name = "remarks", defaultValue = "") String remarks) {
//		
//		ClassManagementActionEnum actionEnum; 
//		
//		try {
//			actionEnum = ClassManagementActionEnum.valueOf(StringUtils.capitalize(action));
//		} catch (IllegalArgumentException | NullPointerException e) {
//			e.printStackTrace();
//			model.addAttribute("message", messageSource.getMessage("msg51", null, null));
//			return "modals/errorModal";
//		}
//		
//		if (!classBatchService.changeClassState(classId, actionEnum, remarks)) {
//			model.addAttribute("message", messageSource.getMessage(
//					"msg50", 
//					new Object[] {actionEnum.toString()}, 
//					null));
//			return "modals/errorModal";
//		}
//		
//		model.addAttribute("message", messageSource.getMessage("msg54", 
//				new Object[] {actionEnum},
//				null));
//		model.addAttribute("redirect", "/classes");
//		model.addAttribute("redirectDelay", 1000);
//		
//		return "modals/messageModal";
//	}
	
	@PostMapping(value = "/classes/{action: |^submit$|^reject$|^cancel$|^approve$|^decline$|^accept$|^start$|^finish$|^close$|^request$}")
	public String changeClassState(Model model, 
			@PathVariable(required = true) String action,
			@RequestParam(name = "classId") String[] classIds,
			@RequestParam(name = "remarks", defaultValue = "") String remarks) {
		
		ClassManagementActionEnum actionEnum; 
		
		try {
			actionEnum = ClassManagementActionEnum.valueOf(StringUtils.capitalize(action));
		} catch (IllegalArgumentException | NullPointerException e) {
			e.printStackTrace();
			model.addAttribute("message", messageSource.getMessage("msg51", null, null));
			return "modals/errorModal";
		}
		
		if (!classBatchService.changeClassState(classIds, actionEnum, remarks)) {
			model.addAttribute("message", messageSource.getMessage(
					"msg50", 
					new Object[] {actionEnum.toString()}, 
					null));
			return "modals/errorModal";
		}
		
		model.addAttribute("message", messageSource.getMessage("msg54", 
				new Object[] {actionEnum},
				null));
		model.addAttribute("redirect", "/classes");
		model.addAttribute("redirectDelay", 1000);
		
		return "modals/messageModal";
	}
	
	@GetMapping(value = "/classes/curriculumn", produces = {MediaType.APPLICATION_PDF_VALUE})
	@ResponseBody
	public byte[] downloadCurriculumn(@RequestParam(name = "curriculumnId", defaultValue = "0") String curriculumnId) {
		CurriculumnModel curriculumnModel = curriculumnService.getOne(Long.parseLong(curriculumnId));
		System.out.println(curriculumnModel);
		return curriculumnModel.getContent();
	}
}
