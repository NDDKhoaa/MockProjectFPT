package fa.mockproject.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class RewardPenalty {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "reward_penalty_id", nullable = false)
    private int rewardPenaltyId;
	
	//TraineeID
	@ManyToOne
	@JoinColumn(name = "trainee_candidate_id", nullable = false)
	private Trainee trainee;
	
	@Column(name = "milestones", nullable = false)
	private int milestones;
	
	@Column(name = "point", nullable = false)
	private int point;
	
	@Column(name = "comments", nullable = false)
	private int comments;

	public RewardPenalty() {
		super();
	}

	public RewardPenalty(int rewardPenaltyId, int milestones, int point, int comments) {
		super();
		this.rewardPenaltyId = rewardPenaltyId;
		this.milestones = milestones;
		this.point = point;
		this.comments = comments;
	}

	public RewardPenalty(int rewardPenaltyId, Trainee trainee, int milestones, int point, int comments) {
		super();
		this.rewardPenaltyId = rewardPenaltyId;
		this.trainee = trainee;
		this.milestones = milestones;
		this.point = point;
		this.comments = comments;
	}

	public int getRewardPenaltyId() {
		return rewardPenaltyId;
	}

	public void setRewardPenaltyId(int rewardPenaltyId) {
		this.rewardPenaltyId = rewardPenaltyId;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	public int getMilestones() {
		return milestones;
	}

	public void setMilestones(int milestones) {
		this.milestones = milestones;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "RewardPenalty [rewardPenaltyId=" + rewardPenaltyId + ", milestones=" + milestones + ", point=" + point
				+ ", comments=" + comments + "]";
	}
	
	
}
