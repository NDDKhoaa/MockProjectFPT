package fa.mockproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Trainer;
import fa.mockproject.model.TrainerModel;
import fa.mockproject.repository.TrainerRepository;
import fa.mockproject.service.TrainerService;

@Service
public class TrainerServiceImpl implements TrainerService{
	@Autowired
	private TrainerRepository trainerRepository;
	
	@Override
	public List<Trainer> getAllTrainers() {
		return trainerRepository.findAll();
	}

	@Override
	public void save(TrainerModel trainerModel) {
		Trainer trainer = Trainer(trainerModel);
		trainerRepository.save(trainer);
	}

	@Override
	public Trainer findByTrainer_id(int trainer_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
