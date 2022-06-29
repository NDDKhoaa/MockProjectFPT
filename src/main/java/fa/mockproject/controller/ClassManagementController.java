package fa.mockproject.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fa.mockproject.entity.enumtype.BudgetCodeEnum;
import fa.mockproject.model.AuditModel;
import fa.mockproject.model.BudgetModel;
import fa.mockproject.model.ClassAdminModel;
import fa.mockproject.model.ClassBatchModel;
import fa.mockproject.model.DeliveryTypeModel;
import fa.mockproject.model.FormatTypeModel;
import fa.mockproject.model.LocationModel;
import fa.mockproject.model.ScopeModel;
import fa.mockproject.model.SubSubjectTypeModel;
import fa.mockproject.model.SubjectTypeModel;
import fa.mockproject.model.TrainerModel;

@Controller
public class ClassManagementController {
	
	@GetMapping("/")
	public String getClassList(Model model) {
		List<LocationModel> locationModels = new ArrayList<LocationModel>();
		locationModels.add(new LocationModel("CG", "Cau Giay", ""));
		locationModels.add(new LocationModel("HL", "Hoa Lac", ""));
		locationModels.add(new LocationModel("DN", "Da Nang", ""));
		locationModels.add(new LocationModel("QN", "Quy Nhon", ""));
		locationModels.add(new LocationModel("HCM", "Ho Chi Minh", ""));
		
		BudgetCodeEnum[] budgetCodeEnums = BudgetCodeEnum.values();
		
		List<ClassAdminModel> classAdminModels = new ArrayList<ClassAdminModel>();
		classAdminModels.add(new ClassAdminModel(1, 1, "Nguyen Nhu Ngoc", LocalDate.of(1995, 10, 13), 1, "0937652189", "NgocNN@email.com", "ngocnn", ""));
		classAdminModels.add(new ClassAdminModel(2, 2, "Le Nguyen Ai Nhi", LocalDate.of(1996, 6, 16), 1, "0937254689", "NhiLNA@email.com", "NhiLNA", ""));
		classAdminModels.add(new ClassAdminModel(3, 3, "Tran Ngoc Nhu Quynh", LocalDate.of(1997, 11, 21), 1, "09637636189", "QuynhTNN@email.com", "QuynhTNN", ""));
		classAdminModels.add(new ClassAdminModel(4, 4, "Le Hong Tham", LocalDate.of(1994, 9, 25), 1, "0934766589", "ThamLH@email.com", "ThamLH", ""));
		classAdminModels.add(new ClassAdminModel(5, 5, "Duong Vu Quynh Anh", LocalDate.of(1994, 4, 12), 1, "0974554779", "AnhDVQ@email.com", "AnhDVQ", ""));
		classAdminModels.add(new ClassAdminModel(6, 6, "Nguyen Tran Kim Ngan", LocalDate.of(1995, 7, 8), 1, "0936346768", "NganNTK@email.com", "NganNTK", ""));
		
		List<SubjectTypeModel> subjectTypeModels = new ArrayList<SubjectTypeModel>();
		subjectTypeModels.add(new SubjectTypeModel(1, "Organizational Overview & Culture", ""));
		subjectTypeModels.add(new SubjectTypeModel(2, "Company Process", ""));
		subjectTypeModels.add(new SubjectTypeModel(3, "Standard Process", ""));
		subjectTypeModels.add(new SubjectTypeModel(4, "IT Technical", ""));
		subjectTypeModels.add(new SubjectTypeModel(5, "Non-IT Technical", ""));
		subjectTypeModels.add(new SubjectTypeModel(6, "Foreign Language", ""));
		subjectTypeModels.add(new SubjectTypeModel(7, "Soft Skill", ""));
		subjectTypeModels.add(new SubjectTypeModel(8, "Management", ""));
		
		List<SubSubjectTypeModel> subSubjectTypeModels = new ArrayList<SubSubjectTypeModel>();
		subSubjectTypeModels.add(new SubSubjectTypeModel(1, "Cloud", ""));
		subSubjectTypeModels.add(new SubSubjectTypeModel(2, "Big Data", ""));
		subSubjectTypeModels.add(new SubSubjectTypeModel(3, "CAD", ""));
		subSubjectTypeModels.add(new SubSubjectTypeModel(4, "CAE", ""));
		subSubjectTypeModels.add(new SubSubjectTypeModel(5, "SAP", ""));
		subSubjectTypeModels.add(new SubSubjectTypeModel(6, "IT General", ""));
		subSubjectTypeModels.add(new SubSubjectTypeModel(7, "Test", ""));
		subSubjectTypeModels.add(new SubSubjectTypeModel(8, "Others", ""));
		
		List<DeliveryTypeModel> deliveryTypeModels = new ArrayList<DeliveryTypeModel>();
		deliveryTypeModels.add(new DeliveryTypeModel(1, "Class", ""));
		deliveryTypeModels.add(new DeliveryTypeModel(2, "Seminar", ""));
		deliveryTypeModels.add(new DeliveryTypeModel(3, "Exam", ""));
		deliveryTypeModels.add(new DeliveryTypeModel(4, "Contest", ""));
		deliveryTypeModels.add(new DeliveryTypeModel(5, "Certificate", ""));
		deliveryTypeModels.add(new DeliveryTypeModel(6, "Club", ""));
		deliveryTypeModels.add(new DeliveryTypeModel(7, "OJT", ""));
		deliveryTypeModels.add(new DeliveryTypeModel(8, "Others", ""));
		
		List<FormatTypeModel> formatTypeModels = new ArrayList<FormatTypeModel>();
		formatTypeModels.add(new FormatTypeModel(1, "Online", ""));
		formatTypeModels.add(new FormatTypeModel(2, "Offline", ""));
		formatTypeModels.add(new FormatTypeModel(3, "Blended", ""));
		
		List<ScopeModel> scopeModels = new ArrayList<ScopeModel>();
		scopeModels.add(new ScopeModel(1, "Company", ""));
		scopeModels.add(new ScopeModel(2, "Unit", ""));
		scopeModels.add(new ScopeModel(3, "Outside", ""));
		
		List<TrainerModel> trainerModels = new ArrayList<TrainerModel>();
		trainerModels.add(new TrainerModel(1, 1, null, "MinhDV", "Dang Van Minh",null, 0, null, null, null, null, 0, null));
		trainerModels.add(new TrainerModel(2, 2, null, "DungNH", "Nguyen Hoang Dung",null, 0, null, null, null, null, 0, null));
		trainerModels.add(new TrainerModel(3, 3, null, "LienDTM", "Duong Thi My Lien",null, 0, null, null, null, null, 0, null));
		trainerModels.add(new TrainerModel(4, 4, null, "DungTV", "Tran Van Dung",null, 0, null, null, null, null, 0, null));
		trainerModels.add(new TrainerModel(5, 5, null, "HaiLH", "Le Hoang Hai",null, 0, null, null, null, null, 0, null));
		
		List<BudgetModel> budgetModels = new ArrayList<BudgetModel>();
		
		List<AuditModel> auditModels = new ArrayList<AuditModel>();
		
		ClassBatchModel classBatchModel = new ClassBatchModel();
		classBatchModel.setBudgetModels(budgetModels);
		classBatchModel.setAuditModels(auditModels);

		model.addAttribute("locationModels", locationModels);
		model.addAttribute("budgetCodeEnums", budgetCodeEnums);
		model.addAttribute("classAdminModels", classAdminModels);
		model.addAttribute("subjectTypeModels", subjectTypeModels);
		model.addAttribute("subSubjectTypeModels", subSubjectTypeModels);
		model.addAttribute("deliveryTypeModels", deliveryTypeModels);
		model.addAttribute("formatTypeModels", formatTypeModels);
		model.addAttribute("scopeModels", scopeModels);
		model.addAttribute("trainerModels", trainerModels);
		model.addAttribute("classBatchModel", classBatchModel);
		
		return "ClassManagement";
	}
	
	@PostMapping("/addClass")
	@ResponseBody
	public String creatNewClass(Model model, @ModelAttribute("classBatchModel") ClassBatchModel classBatchModel) {
		List<LocationModel> locationModels = new ArrayList<LocationModel>();
		locationModels.add(new LocationModel("CG", "Cau Giay", ""));
		locationModels.add(new LocationModel("HL", "Hoa Lac", ""));
		locationModels.add(new LocationModel("DN", "Da Nang", ""));
		locationModels.add(new LocationModel("QN", "Quy Nhon", ""));
		locationModels.add(new LocationModel("HCM", "Ho Chi Minh", ""));
		
		BudgetCodeEnum[] budgetCodeEnums = BudgetCodeEnum.values();
		
		List<ClassAdminModel> classAdminModels = new ArrayList<ClassAdminModel>();
		classAdminModels.add(new ClassAdminModel(1, 1, "Nguyen Nhu Ngoc", LocalDate.of(1995, 10, 13), 1, "0937652189", "NgocNN@email.com", "ngocnn", ""));
		classAdminModels.add(new ClassAdminModel(2, 2, "Le Nguyen Ai Nhi", LocalDate.of(1996, 6, 16), 1, "0937254689", "NhiLNA@email.com", "NhiLNA", ""));
		classAdminModels.add(new ClassAdminModel(3, 3, "Tran Ngoc Nhu Quynh", LocalDate.of(1997, 11, 21), 1, "09637636189", "QuynhTNN@email.com", "QuynhTNN", ""));
		classAdminModels.add(new ClassAdminModel(4, 4, "Le Hong Tham", LocalDate.of(1994, 9, 25), 1, "0934766589", "ThamLH@email.com", "ThamLH", ""));
		classAdminModels.add(new ClassAdminModel(5, 5, "Duong Vu Quynh Anh", LocalDate.of(1994, 4, 12), 1, "0974554779", "AnhDVQ@email.com", "AnhDVQ", ""));
		classAdminModels.add(new ClassAdminModel(6, 6, "Nguyen Tran Kim Ngan", LocalDate.of(1995, 7, 8), 1, "0936346768", "NganNTK@email.com", "NganNTK", ""));
		
		List<SubjectTypeModel> subjectTypeModels = new ArrayList<SubjectTypeModel>();
		subjectTypeModels.add(new SubjectTypeModel(1, "Organizational Overview & Culture", ""));
		subjectTypeModels.add(new SubjectTypeModel(2, "Company Process", ""));
		subjectTypeModels.add(new SubjectTypeModel(3, "Standard Process", ""));
		subjectTypeModels.add(new SubjectTypeModel(4, "IT Technical", ""));
		subjectTypeModels.add(new SubjectTypeModel(5, "Non-IT Technical", ""));
		subjectTypeModels.add(new SubjectTypeModel(6, "Foreign Language", ""));
		subjectTypeModels.add(new SubjectTypeModel(7, "Soft Skill", ""));
		subjectTypeModels.add(new SubjectTypeModel(8, "Management", ""));
		
		List<SubSubjectTypeModel> subSubjectTypeModels = new ArrayList<SubSubjectTypeModel>();
		subSubjectTypeModels.add(new SubSubjectTypeModel(1, "Cloud", ""));
		subSubjectTypeModels.add(new SubSubjectTypeModel(2, "Big Data", ""));
		subSubjectTypeModels.add(new SubSubjectTypeModel(3, "CAD", ""));
		subSubjectTypeModels.add(new SubSubjectTypeModel(4, "CAE", ""));
		subSubjectTypeModels.add(new SubSubjectTypeModel(5, "SAP", ""));
		subSubjectTypeModels.add(new SubSubjectTypeModel(6, "IT General", ""));
		subSubjectTypeModels.add(new SubSubjectTypeModel(7, "Test", ""));
		subSubjectTypeModels.add(new SubSubjectTypeModel(8, "Others", ""));
		
		List<DeliveryTypeModel> deliveryTypeModels = new ArrayList<DeliveryTypeModel>();
		deliveryTypeModels.add(new DeliveryTypeModel(1, "Class", ""));
		deliveryTypeModels.add(new DeliveryTypeModel(2, "Seminar", ""));
		deliveryTypeModels.add(new DeliveryTypeModel(3, "Exam", ""));
		deliveryTypeModels.add(new DeliveryTypeModel(4, "Contest", ""));
		deliveryTypeModels.add(new DeliveryTypeModel(5, "Certificate", ""));
		deliveryTypeModels.add(new DeliveryTypeModel(6, "Club", ""));
		deliveryTypeModels.add(new DeliveryTypeModel(7, "OJT", ""));
		deliveryTypeModels.add(new DeliveryTypeModel(8, "Others", ""));
		
		List<FormatTypeModel> formatTypeModels = new ArrayList<FormatTypeModel>();
		formatTypeModels.add(new FormatTypeModel(1, "Online", ""));
		formatTypeModels.add(new FormatTypeModel(2, "Offline", ""));
		formatTypeModels.add(new FormatTypeModel(3, "Blended", ""));
		
		List<ScopeModel> scopeModels = new ArrayList<ScopeModel>();
		scopeModels.add(new ScopeModel(1, "Company", ""));
		scopeModels.add(new ScopeModel(2, "Unit", ""));
		scopeModels.add(new ScopeModel(3, "Outside", ""));
		
		List<TrainerModel> trainerModels = new ArrayList<TrainerModel>();
		trainerModels.add(new TrainerModel(1, 1, null, "MinhDV", "Dang Van Minh",null, 0, null, null, null, null, 0, null));
		trainerModels.add(new TrainerModel(2, 2, null, "DungNH", "Nguyen Hoang Dung",null, 0, null, null, null, null, 0, null));
		trainerModels.add(new TrainerModel(3, 3, null, "LienDTM", "Duong Thi My Lien",null, 0, null, null, null, null, 0, null));
		trainerModels.add(new TrainerModel(4, 4, null, "DungTV", "Tran Van Dung",null, 0, null, null, null, null, 0, null));
		trainerModels.add(new TrainerModel(5, 5, null, "HaiLH", "Le Hoang Hai",null, 0, null, null, null, null, 0, null));
		
		System.out.println(classBatchModel);
		
		model.addAttribute("locationModels", locationModels);
		model.addAttribute("budgetCodeEnums", budgetCodeEnums);
		model.addAttribute("classAdminModels", classAdminModels);
		model.addAttribute("subjectTypeModels", subjectTypeModels);
		model.addAttribute("subSubjectTypeModels", subSubjectTypeModels);
		model.addAttribute("deliveryTypeModels", deliveryTypeModels);
		model.addAttribute("formatTypeModels", formatTypeModels);
		model.addAttribute("scopeModels", scopeModels);
		model.addAttribute("trainerModels", trainerModels);
		
		return "ClassManagement";
	}
}
