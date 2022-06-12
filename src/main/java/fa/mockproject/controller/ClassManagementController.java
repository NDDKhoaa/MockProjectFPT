package fa.mockproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fa.mockproject.entity.enumtype.BudgetCodeEnum;
import fa.mockproject.model.ClassAdminModel;
import fa.mockproject.model.ClassBatchModel;
import fa.mockproject.model.LocationModel;

@Controller
public class ClassManagementController {
	
	@GetMapping("/")
	public String getClassList(Model model) {
		ClassBatchModel classBatchModel = new ClassBatchModel();
		classBatchModel.setLocationModel(new LocationModel());
		classBatchModel.setBudgetCode(BudgetCodeEnum.CTC_Fresher_Allowance);
		classBatchModel.setClassAdminModel(new ClassAdminModel());
		
		BudgetCodeEnum[] budgetCodeEnums = BudgetCodeEnum.values();
		List<LocationModel> locationModels = new ArrayList<LocationModel>();
		locationModels.add(new LocationModel(0, "Ha Noi", ""));
		locationModels.add(new LocationModel(1, "Cau Giay", ""));
		locationModels.add(new LocationModel(2, "HCM", ""));
		locationModels.add(new LocationModel(3, "Da Nang", ""));

		model.addAttribute("classBatchModel", classBatchModel);
		model.addAttribute("budgetCodeEnums", budgetCodeEnums);
		model.addAttribute("locationModels", locationModels);
		model.addAttribute("locationTest", locationModels.get(0));
		
		return "ClassManagement";
	}
	
	@PostMapping("/addClass")
	public String creatNewClass(@ModelAttribute("classBatchModel") ClassBatchModel classBatchModel) {
		System.out.println(classBatchModel);
		System.out.println(classBatchModel.getBudgetCode());
		System.out.println("Hello");
		return "ClassManagement";
	}
}
