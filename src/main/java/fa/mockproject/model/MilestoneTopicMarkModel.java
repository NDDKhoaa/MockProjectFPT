package fa.mockproject.model;

import java.util.ArrayList;
import java.util.List;

import fa.mockproject.entity.RewardPenalty;
import fa.mockproject.entity.Topic;

public class MilestoneTopicMarkModel {
	
	private String milestoneName;
	private int total;
	private List<Topic> topics;
	private List<RewardPenalty> rewardPenalties = new ArrayList<RewardPenalty>();
	
	public MilestoneTopicMarkModel() {
		super();
	}
	public MilestoneTopicMarkModel(String milestoneName, int total, List<Topic> topics,
			List<RewardPenalty> rewardPenalties) {
		super();
		this.milestoneName = milestoneName;
		this.total = total;
		this.topics = topics;
		this.rewardPenalties = rewardPenalties;
	}
	public String getMilestoneName() {
		return milestoneName;
	}
	public void setMilestoneName(String milestoneName) {
		this.milestoneName = milestoneName;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Topic> getTopics() {
		return topics;
	}
	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
	public List<RewardPenalty> getRewardPenalties() {
		return rewardPenalties;
	}
	public void setRewardPenalties(List<RewardPenalty> rewardPenalties) {
		this.rewardPenalties = rewardPenalties;
	}

	

}
