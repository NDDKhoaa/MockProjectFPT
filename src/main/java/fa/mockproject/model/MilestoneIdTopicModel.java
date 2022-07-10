package fa.mockproject.model;

import fa.mockproject.entity.Topic;

public class MilestoneIdTopicModel {
	private String milestoneId;
	private Topic topic;
	public MilestoneIdTopicModel() {
		super();
	}
	public MilestoneIdTopicModel(String milestoneId, Topic topic) {
		super();
		this.milestoneId = milestoneId;
		this.topic = topic;
	}
	public String getMilestoneId() {
		return milestoneId;
	}
	public void setMilestoneId(String milestoneId) {
		this.milestoneId = milestoneId;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	
}
