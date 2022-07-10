package fa.mockproject.model;

import java.util.List;

public class MilestoneForRewardPenaltyDTOModel {

	public List<RewardPenaltyModel> rewardPenaltyModels;

	public MilestoneForRewardPenaltyDTOModel() {
		super();
	}

	public MilestoneForRewardPenaltyDTOModel(List<RewardPenaltyModel> rewardPenaltyModels) {
		super();
		this.rewardPenaltyModels = rewardPenaltyModels;
	}

	public List<RewardPenaltyModel> getRewardPenaltyModels() {
		return rewardPenaltyModels;
	}

	public void setRewardPenaltyModels(List<RewardPenaltyModel> rewardPenaltyModels) {
		this.rewardPenaltyModels = rewardPenaltyModels;
	}

	
	
}
