package fa.mockproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Commitment;
import fa.mockproject.entity.Trainee;
import fa.mockproject.model.CommitmentViewModel;
import fa.mockproject.repository.CommitmentRepository;
import fa.mockproject.repository.TraineeRepository;
import fa.mockproject.service.CommitmentService;

@Service
public class CommitmentServiceImpl extends CommitmentService {
	@Autowired
	CommitmentRepository commitmentRepository;

	@Autowired
	TraineeRepository traineeRepository;
	
	public String createAndUpdate(CommitmentViewModel commitmentViewModel, long traineeId) {
		Trainee trainee = traineeRepository.findByTraineeCandidateId(traineeId);
		System.out.println(commitmentViewModel);
		if(commitmentViewModel.getCommitmentId() != 0) {
			Commitment commitment = new Commitment(commitmentViewModel, trainee);
			commitmentRepository.update(commitment.getCommitmentId(), commitment.getCommittedValue(),
					commitment.getCommittedWorkingDuration(), commitment.getCommittedWorkingEndDate(),
					commitment.getCommittedWorkingStartDate(), commitment.getRemarks());
			
		} else {
			Commitment commitment = new Commitment(commitmentViewModel, trainee);
			commitmentRepository.save(commitment);
		}
		
		
		return null;
	}

	public CommitmentViewModel getCommitment(long traineeId) {
		Trainee trainee = traineeRepository.findByTraineeCandidateId(traineeId);
		CommitmentViewModel commitmentViewModel = null;
		if(trainee.getCommitment() != null) {
			commitmentViewModel = new CommitmentViewModel(trainee.getCommitment()); 
		}
		return commitmentViewModel;
	}

}
