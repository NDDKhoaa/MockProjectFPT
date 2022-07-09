package fa.mockproject.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.model.ClassTypeModel;
import fa.mockproject.repository.ClassTypeRepository;
import fa.mockproject.service.ClassTypeService;

@Service
public class ClassTypeServiceImpl implements ClassTypeService {

	@Autowired
	ClassTypeRepository classTypeRepository;
	
	@Override
	public List<ClassTypeModel> getAll() {
		return classTypeRepository.findAll().stream().map(classType -> 
			new ClassTypeModel(classType)).collect(Collectors.toCollection(ArrayList::new));
	}

}
