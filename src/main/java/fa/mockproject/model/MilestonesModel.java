package fa.mockproject.model;

import java.util.List;

import fa.mockproject.entity.Milestone;

public class MilestonesModel {
	
	private int totalMaxScore;
	private int totalPassingScore;
	private int totalWeightedNumber;
	private List<Milestone> mileStones;
	
	public MilestonesModel() {
		super();
	}
	
	public MilestonesModel(int totalMaxScore, int totalPassingScore, int totalWeightedNumber,
			List<Milestone> mileStones) {
		super();
		this.totalMaxScore = totalMaxScore;
		this.totalPassingScore = totalPassingScore;
		this.totalWeightedNumber = totalWeightedNumber;
		this.mileStones = mileStones;
	}



	public int getTotalMaxScore() {
		return totalMaxScore;
	}
	public void setTotalMaxScore(int totalMaxScore) {
		this.totalMaxScore = totalMaxScore;
	}
	public int getTotalPassingScore() {
		return totalPassingScore;
	}
	public void setTotalPassingScore(int totalPassingScore) {
		this.totalPassingScore = totalPassingScore;
	}
	public int getTotalWeightedNumber() {
		return totalWeightedNumber;
	}
	public void setTotalWeightedNumber(int totalWeightedNumber) {
		this.totalWeightedNumber = totalWeightedNumber;
	}

	public List<Milestone> getMileStones() {
		return mileStones;
	}

	public void setMileStones(List<Milestone> mileStones) {
		this.mileStones = mileStones;
	}
	
	
	
}
