package fa.mockproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Milestone;
import fa.mockproject.entity.Trainee;
import fa.mockproject.model.GpaViewModel;
import fa.mockproject.repository.MilestoneRepository;
import fa.mockproject.repository.TraineeRepository;
import fa.mockproject.service.GpaService;

@Service
public class GpaServiceImpl implements GpaService {
	@Autowired
	MilestoneRepository milestoneRepository;

	@Autowired
	TraineeRepository traineeRepository;
	
	public List<GpaViewModel> getGpaModel(long traineeId) {
		Trainee trainee = traineeRepository.findByTraineeCandidateId(traineeId);
		List<GpaViewModel> gpaViewModels = new ArrayList<GpaViewModel>();
		
		for(Milestone milestone : trainee.getMilestones()) {
			
		}
		
		return null;
	}
	
}
