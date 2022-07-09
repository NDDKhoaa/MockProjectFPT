package fa.mockproject.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.model.DeliveryTypeModel;
import fa.mockproject.repository.DeliveryTypeRepository;
import fa.mockproject.service.DeliveryTypeService;

@Service
public class DeliveryTypeServiceImpl implements DeliveryTypeService {

	@Autowired
	DeliveryTypeRepository deliveryTypeRepository;
	
	@Override
	public List<DeliveryTypeModel> getAll() {
		List<DeliveryTypeModel> deliveryTypeModels = deliveryTypeRepository.findAll().stream().map(
				deliveryType -> new DeliveryTypeModel(deliveryType)).collect(Collectors.toCollection(ArrayList::new));
		return deliveryTypeModels;
	}

}
