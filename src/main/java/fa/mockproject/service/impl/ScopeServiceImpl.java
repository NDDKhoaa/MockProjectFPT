package fa.mockproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.model.ScopeModel;
import fa.mockproject.repository.ScopeRepository;
import fa.mockproject.service.ScopeService;

@Service
public class ScopeServiceImpl implements ScopeService{
	
	@Autowired
	ScopeRepository scopeRepository;
	
	@Override
	public List<ScopeModel> getAll() {
		List<ScopeModel> scopeModels = new ArrayList<ScopeModel>();
		scopeRepository.findAll().forEach(scope -> {
			scopeModels.add(new ScopeModel(scope));
		});
		return scopeModels;
	}
}
