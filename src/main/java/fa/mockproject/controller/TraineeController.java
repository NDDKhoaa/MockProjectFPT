package fa.mockproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.mockproject.entity.Trainee;
import fa.mockproject.entity.enumtype.AllowanceGroupEnum;
import fa.mockproject.entity.enumtype.TopicStatus;
import fa.mockproject.model.CommitmentViewModel;
import fa.mockproject.model.TraineeModel;
import fa.mockproject.service.impl.TraineeServiceImpl;

@Controller
public class TraineeController {
	
	@Autowired
	TraineeServiceImpl traineeService;
	
	@GetMapping(value = "/showTraineeInfo")
	public String showUpdateTrainee(Model model, @RequestParam("id") long id) {
		
		TraineeModel traineeModel = traineeService.getTraineeModel(id);
		
		
		model.addAttribute("traineeModel", traineeModel);
		model.addAttribute("trainee", traineeModel);
		
		return "traineeInfo";
	}
	
	@GetMapping(value = "/getTraineeInfo")
	public String getUpdateTrainee(Model model, @RequestParam("id") long id, HttpSession session) {
		
		TraineeModel traineeModel = traineeService.getTraineeModel(id);
		
		List<String> allowanceGroups = new ArrayList<String>();
		AllowanceGroupEnum[] allowanceGroupEnums = AllowanceGroupEnum.values();
		for(AllowanceGroupEnum status : allowanceGroupEnums) {
			allowanceGroups.add(status.name());
		}
		
		model.addAttribute("trainee", traineeModel);
		model.addAttribute("allowanceGroups", allowanceGroups);
		
		return "traineeForUpdate";
	}	
	
	@PostMapping(value = "/deleteTrainee")
	public String deleteTrainee (@RequestParam(value = "present", required = false) long[] traineeIds,
								@RequestParam(value = "action", required = false) String action,
								@RequestParam(value = "s", required = false) String s,
								@RequestParam(value = "search", required = false) String filter,
								HttpServletRequest rq) {
		if(action.equals("Search")) {
			rq.getSession().setAttribute("search", s);
			rq.getSession().setAttribute("filter", filter);
		} else 
		if(traineeIds.length != 0) {
			String successMessage = traineeService.deleteTrainee(traineeIds);
		}
		return "redirect:/showTraineeList/1";
	}
	
	@PostMapping(value = "/deleteTraineeById")
	public String deleteTrainee (@RequestParam("id") long traineeId) {
		String successMessage = traineeService.deleteTraineeById(traineeId);
		return "redirect:/showTraineeList/1";
	}
	
	@PostMapping(value = "/updateTrainee")
	public String updateTrainee(@ModelAttribute("trainee") TraineeModel traineeModel, Model model,
								@RequestParam("id") int id) {
		
		String successMesage = traineeService.updateTrainee(traineeModel);
		
		return "redirect:/showTraineeList/1";
	}
	
	@GetMapping(value = "/showTraineeList/{pageNo}")
	public String showTraineeList(Model model, HttpServletRequest rs,
								HttpServletRequest request,
								@RequestParam(value = "sizeStr", required = false, defaultValue = "5") String sizeStr,
								@PathVariable("pageNo") int pageNo,
								HttpSession session) {
		int size = Integer.parseInt(sizeStr);  
		String search = (String) session.getAttribute("search");
		String filter = (String) session.getAttribute("filter");
		System.out.println(filter);
		List<TraineeModel> traineeModels = null;
		Pageable pageable = null;
		Page<Trainee> page = null;
		
		if(filter.isEmpty()) {
			pageable = PageRequest.of(pageNo - 1 , size);
			
			traineeModels = traineeService.getTraineeModels(pageable).getTraineeModels();
			page = traineeService.getTraineeModels(pageable).getPage();
		} if(filter.equals("id")) {
			pageable = PageRequest.of(pageNo - 1 , size);
			for (TraineeModel traineeModel : traineeService.getTraineeModels(pageable).getTraineeModels()) {
				if(traineeModel.getId() == Long.parseLong(search)) {
					traineeModels.add(traineeModel);
				}
			}
			page = traineeService.getTraineeModels(pageable).getPage();
		} if(filter.equals("name")) {
			pageable = PageRequest.of(pageNo - 1 , size);
			for (TraineeModel traineeModel : traineeService.getTraineeModels(pageable).getTraineeModels()) {
				if(traineeModel.getFullName().equals(search)) {
					traineeModels.add(traineeModel);
				}
			}
			page = traineeService.getTraineeModels(pageable).getPage();
		}
		
		pageable = PageRequest.of(pageNo - 1 , size);
		
		traineeModels = traineeService.getTraineeModels(pageable).getTraineeModels();
		page = traineeService.getTraineeModels(pageable).getPage();
		
		List<String> urls = new ArrayList<String>();
		
		if(size == 5) {
			urls.add("/showTraineeList/1?sizeStr=" + size);
			urls.add("/showTraineeList/1?sizeStr=10");
			urls.add("/showTraineeList/1?sizeStr=15");
		} else if(size == 10) {
			urls.add("/showTraineeList/1?sizeStr=5" );
			urls.add("/showTraineeList/1?sizeStr="+ size);
			urls.add("/showTraineeList/1?sizeStr=15");
		} else {
			urls.add("/showTraineeList/1?sizeStr=5" );
			urls.add("/showTraineeList/1?sizeStr=10");
			urls.add("/showTraineeList/1?sizeStr=" + size);
		}
		int[] sizes = {5, 10, 15};
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("trainees", traineeModels);
		model.addAttribute("urls", urls);
		model.addAttribute("sizes", sizes);
		model.addAttribute("size", size);
		
		return "traineeList";
	}
}
