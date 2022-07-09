package fa.mockproject.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.model.PositionModel;
import fa.mockproject.repository.PositionRepository;
import fa.mockproject.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService {

	@Autowired
	PositionRepository positionRepository;
	
	@Override
	public List<PositionModel> getAll() {
		return positionRepository.findAll().stream().map(position -> 
		new PositionModel(position)).collect(Collectors.toCollection(ArrayList::new));
	}

}
