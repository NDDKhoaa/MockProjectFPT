package fa.mockproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.model.FormatTypeModel;
import fa.mockproject.repository.FormatTypeRepository;
import fa.mockproject.service.FormatTypeService;

@Service
public class FormatTypeServiceImpl implements FormatTypeService {

	@Autowired
	FormatTypeRepository formatTypeRepository;
	
	@Override
	public List<FormatTypeModel> getAll() {
		List<FormatTypeModel> formatTypeModels = new ArrayList<FormatTypeModel>();
		formatTypeRepository.findAll().forEach(formatType -> {
			formatTypeModels.add(new FormatTypeModel(formatType));
		});
		return formatTypeModels;
	}

}
