package fa.mockproject.model;

import java.util.Set;

public class milestoneRewardPenaltyForCheck {
	long milestoneId;
	Set<RewardPenaltyModel> rewardPenaltyModels;
	public milestoneRewardPenaltyForCheck(long milestoneId, Set<RewardPenaltyModel> rewardPenaltyModels) {
		super();
		this.milestoneId = milestoneId;
		this.rewardPenaltyModels = rewardPenaltyModels;
	}
	public milestoneRewardPenaltyForCheck() {
		super();
	}
	public long getMilestoneId() {
		return milestoneId;
	}
	public void setMilestoneId(long milestoneId) {
		this.milestoneId = milestoneId;
	}
	public Set<RewardPenaltyModel> getRewardPenaltyModels() {
		return rewardPenaltyModels;
	}
	public void setRewardPenaltyModels(Set<RewardPenaltyModel> rewardPenaltyModels) {
		this.rewardPenaltyModels = rewardPenaltyModels;
	}
	
	
}
