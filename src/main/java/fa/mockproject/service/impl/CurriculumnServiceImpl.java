package fa.mockproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.model.CurriculumnModel;
import fa.mockproject.repository.CurriculumnRepository;
import fa.mockproject.service.CurriculumnService;

@Service
public class CurriculumnServiceImpl implements CurriculumnService {

	@Autowired
	CurriculumnRepository curriculumnRepository;
	
	@Override
	public CurriculumnModel getOne(long curriculumnId) {
		CurriculumnModel curriculumnModel = new CurriculumnModel(curriculumnRepository.getOne(curriculumnId));
		return curriculumnModel;
	}

}
