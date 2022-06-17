package fa.mockproject.service.impl;

import java.util.List;
import java.util.Optional;

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
		Trainer trainer = new Trainer(trainerModel);
		trainerRepository.save(trainer);
	}

	private Trainer Trainer(TrainerModel trainerModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trainer findByTrainerId(long trainerId) {
		Optional<Trainer> optional = trainerRepository.findById(trainerId);
		Trainer trainer = null;
		if(optional.isPresent()) {
			trainer = optional.get();
		}else {
			throw new RuntimeException("Trainer not found for id"+trainerId);
		}
		return trainer;
	}

}
