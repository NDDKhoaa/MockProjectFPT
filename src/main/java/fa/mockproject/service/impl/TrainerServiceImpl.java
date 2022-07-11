package fa.mockproject.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fa.mockproject.entity.ClassBatch;
import fa.mockproject.entity.Trainer;
import fa.mockproject.entity.TrainerProfile;
import fa.mockproject.entity.enumtype.ClassBatchStatusEnum;
import fa.mockproject.model.TrainerModel;
import fa.mockproject.repository.TrainerProfileRepository;
import fa.mockproject.repository.TrainerRepository;
import fa.mockproject.service.TrainerService;
import fa.mockproject.util.ClassManagementConstant;

@Service
public class TrainerServiceImpl implements TrainerService{
	
	@Autowired
	private TrainerProfileRepository trainerProfileRepository;
	@Autowired
	private TrainerRepository trainerRepository;
	@Autowired
	ResourceBundleMessageSource messageSource;
	@Override
	public void getAllTrainers(Model model, Map<String, String> filters,String keyword) {
		
		Integer pageSize = (Integer) convertFilterType(Integer.class, filters.get("pageSize"));
		Integer pageIndex = (Integer) convertFilterType(Integer.class, filters.get("pageIndex"));
		
		pageIndex = pageIndex == null ? 1 : pageIndex;
		pageSize = pageSize == null ? ClassManagementConstant.CLASS_LIST_PAGE_SIZE.get(0) : pageSize;
		Sort sort = Sort.by("trainerProfileId").ascending();
		Pageable pageable = PageRequest.of(pageIndex-1, pageSize,sort);
	
		Page<TrainerProfile> page;
		if(keyword!=null) {
			page = trainerProfileRepository.findAll(keyword,pageable);
		}else {
			page = trainerProfileRepository.findAll(pageable);
		}
		List<TrainerProfile> trainerList = page.getContent();
		
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		totalPages = totalPages == 0 ? 1 : totalPages;
		pageIndex = page.getNumber() + 1;
		pageSize = page.getSize();
		
		model.addAttribute("pageSize",pageSize);
		model.addAttribute("pageIndex",pageIndex);
		model.addAttribute("totalItems",totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("trainerList", trainerList);
		System.out.println("page index"+pageIndex);
		if (trainerList == null || trainerList.size() == 0) {
			model.addAttribute("showModal", true);
			model.addAttribute("modal", "warningModal");
			model.addAttribute("message", messageSource.getMessage("msg8", null, null));			
		}

	}
	@Override
	public void getAllTrainers(Model model, Map<String, String> filters) {
		Integer pageSize = (Integer) convertFilterType(Integer.class, filters.get("pageSize"));
		Integer pageIndex = (Integer) convertFilterType(Integer.class, filters.get("pageIndex"));
		
		pageIndex = pageIndex == null ? 1 : pageIndex;
		pageSize = pageSize == null ? ClassManagementConstant.CLASS_LIST_PAGE_SIZE.get(0) : pageSize;
		Sort sort = Sort.by("trainerProfileId").ascending();
		Pageable pageable = PageRequest.of(pageIndex-1, pageSize,sort);
		
		Page<TrainerProfile> page = trainerProfileRepository.findAll(pageable);
		List<TrainerProfile> trainerList = page.getContent();
		
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		totalPages = totalPages == 0 ? 1 : totalPages;
		pageIndex = page.getNumber() + 1;
		pageSize = page.getSize();
		
		model.addAttribute("pageSize",pageSize);
		model.addAttribute("pageIndex",pageIndex);
		model.addAttribute("totalItems",totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("trainerList", trainerList);
		System.out.println("page index"+pageIndex);
		if (trainerList == null || trainerList.size() == 0) {
			model.addAttribute("showModal", true);
			model.addAttribute("modal", "warningModal");
			model.addAttribute("message", messageSource.getMessage("msg8", null, null));			
		}
	}

	@Override
	public void save(TrainerModel trainerModel) {
		TrainerProfile trainerProfile = new TrainerProfile(trainerModel);
		trainerProfileRepository.save(trainerProfile);

	}

	@Override
	public TrainerProfile findByTrainerId(long trainerId) {
		Optional<TrainerProfile> optional = trainerProfileRepository.findById(trainerId);
		TrainerProfile trainer = null;
		if(optional.isPresent()) {
			trainer = optional.get();
		}else {
			throw new RuntimeException("Trainer not found for id"+trainerId);
		}
		return trainer;
	}

	@Override
	public List<TrainerModel> getAllProfile() {
		List<TrainerModel> trainerModels = trainerProfileRepository.findAll().stream().map(
				trainerProfile -> new TrainerModel(trainerProfile)).collect(Collectors.toCollection(ArrayList::new));
		return trainerModels;
	}

	@Override
	public List<Trainer> updateAllTrainerOfOneClass(ClassBatch classBatch) {
		System.out.println(classBatch.getTrainers());
		List<Trainer> latestTrainers = trainerRepository.saveAll(classBatch.getTrainers());
		List<Trainer> removedTrainers = trainerRepository.findAll();
		try {
			removedTrainers.removeAll(latestTrainers);	
			trainerRepository.deleteAll(removedTrainers);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}  catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		return latestTrainers;
	}
	@Override
	public void deleteTrainerProfileById(long id) {
		this.trainerProfileRepository.deleteById(id);
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

}
