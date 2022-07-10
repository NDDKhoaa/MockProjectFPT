package fa.mockproject.model;

public class TopicModel {
	private long milestoneId1;
	private String topicName;
	private int maxScore;
	private int passingScore;
	private int weightedNumber;
	
	
	public TopicModel() {
		super();
	}


	public TopicModel(long milestoneId, String topicName, int maxScore, int passingScore, int weightedNumber) {
		super();
		this.milestoneId1 = milestoneId;
		this.topicName = topicName;
		this.maxScore = maxScore;
		this.passingScore = passingScore;
		this.weightedNumber = weightedNumber;
	}


	public long getMilestoneId1() {
		return milestoneId1;
	}


	public void setMilestoneId1(long milestoneId) {
		this.milestoneId1 = milestoneId;
	}


	public String getTopicName() {
		return topicName;
	}


	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}


	public int getMaxScore() {
		return maxScore;
	}


	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}


	public int getPassingScore() {
		return passingScore;
	}


	public void setPassingScore(int passingScore) {
		this.passingScore = passingScore;
	}


	public int getWeightedNumber() {
		return weightedNumber;
	}


	public void setWeightedNumber(int weightedNumber) {
		this.weightedNumber = weightedNumber;
	}
	
	
}
