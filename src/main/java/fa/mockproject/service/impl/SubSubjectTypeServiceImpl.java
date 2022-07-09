package fa.mockproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.model.SubSubjectTypeModel;
import fa.mockproject.repository.SubSubjectTypeRepository;
import fa.mockproject.service.SubSubjectTypeService;

@Service
public class SubSubjectTypeServiceImpl implements SubSubjectTypeService {

	@Autowired
	SubSubjectTypeRepository subSubjectTypeRepository;
	
	@Override
	public List<SubSubjectTypeModel> getAll() {
		List<SubSubjectTypeModel> subSubjectTypeModels = new ArrayList<SubSubjectTypeModel>();
		subSubjectTypeRepository.findAll().forEach(subSubjectType -> {
			subSubjectTypeModels.add(new SubSubjectTypeModel(subSubjectType));
		});
		return subSubjectTypeModels;
	}

}
