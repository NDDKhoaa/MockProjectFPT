package fa.mockproject.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.model.SubjectTypeModel;
import fa.mockproject.repository.SubjectTypeRepository;
import fa.mockproject.service.SubjectTypeService;

@Service
public class SubjectTypeServiceImpl implements SubjectTypeService {

	@Autowired
	SubjectTypeRepository subjectTypeRepository;
	
	@Override
	public List<SubjectTypeModel> getAll() {
		List<SubjectTypeModel> subjectTypeModels = subjectTypeRepository.findAll().stream().map(
				subjectType -> new SubjectTypeModel(subjectType)).collect(Collectors.toCollection(ArrayList::new));
		return subjectTypeModels;
	}
}
