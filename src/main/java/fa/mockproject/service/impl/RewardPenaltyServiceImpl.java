package fa.mockproject.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Milestone;
import fa.mockproject.entity.RewardPenalty;
import fa.mockproject.entity.Trainee;
import fa.mockproject.model.RewardPenaltyModel;
import fa.mockproject.repository.MilestoneRepository;
import fa.mockproject.repository.RewardPenaltyRepository;
import fa.mockproject.repository.TraineeRepository;
import fa.mockproject.service.RewardPenaltyService;

@Service
public class RewardPenaltyServiceImpl implements RewardPenaltyService {
	@Autowired
	RewardPenaltyRepository rewardPenaltyRepository;

	@Autowired
	TraineeRepository traineeRepository;

	@Autowired
	MilestoneRepository milestoneRepository;

	public List<RewardPenaltyModel> getRewardAndPenalties(long traineeId) {
		Trainee trainee = traineeRepository.findByTraineeCandidateId(traineeId);

		List<Milestone> milestones = trainee.getMilestones();
		List<RewardPenaltyModel> rewardPenaltyModels = new ArrayList<RewardPenaltyModel>();
		for (Milestone milestone : milestones) {
			for (RewardPenalty rewardPenalty : milestone.getRewardPenalties()) {
				RewardPenaltyModel rewardPenaltyModel = new RewardPenaltyModel(rewardPenalty);
				rewardPenaltyModel.setStatus("1");
				rewardPenaltyModels.add(rewardPenaltyModel);
			}
		}
		if (rewardPenaltyModels.size() == 0) {
			rewardPenaltyModels.add(new RewardPenaltyModel());
		}
		return rewardPenaltyModels;
	}

	public String createNewRewardAndPenalty(List<RewardPenaltyModel> rewardPenaltyModels) {
		
		
		System.out.println(rewardPenaltyModels.size());
		
		for (RewardPenaltyModel rewardPenaltyModel : rewardPenaltyModels) {
			System.out.println(rewardPenaltyModel);
			if(rewardPenaltyModel.getStatus().equals("2")) {
				System.out.println("------------------------" + rewardPenaltyModel.getStatus());
				Milestone milestone = milestoneRepository.findById(rewardPenaltyModel.getMilestoneId()).get();
				RewardPenalty rewardPenalty = new RewardPenalty(rewardPenaltyModel, milestone);
				rewardPenaltyRepository.deleteById(rewardPenalty.getRewardPenaltyId());
			} else if(rewardPenaltyModel.getStatus().equals("1")) {
				Milestone milestone = milestoneRepository.findById(rewardPenaltyModel.getMilestoneId()).get();
				RewardPenalty rewardPenalty = new RewardPenalty(rewardPenaltyModel, milestone);
				rewardPenaltyRepository.updateById(rewardPenalty.getRewardPenaltyId(), rewardPenalty.getDate(), rewardPenalty.getPenaltyPoint(), rewardPenalty.getBonusPoint(),
												rewardPenalty.getReason());
			} else if(rewardPenaltyModel.getStatus().equals("0") || rewardPenaltyModel.getStatus().equals("") ) {
				Milestone milestone = milestoneRepository.findById(rewardPenaltyModel.getMilestoneId()).get();
				RewardPenalty rewardPenalty = new RewardPenalty(rewardPenaltyModel, milestone);
				rewardPenaltyRepository.save(rewardPenalty);
			}

		}

		return null;
	}

	public String deleteRewardPenalty(long rewardPenaltyId) {

		rewardPenaltyRepository.deleteById(rewardPenaltyId);

		return "Delete Successfully!";
	}
}
