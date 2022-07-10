package fa.mockproject.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fa.mockproject.model.RewardPenaltyModel;

@Entity
@Table(name = "RewardPenalty")
public class RewardPenalty {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "reward_penalty_id")
    private long rewardPenaltyId;
	
	//TraineeID
	@ManyToOne
	@JoinColumn(name = "trainee_candidate_id", nullable = true)
	private Trainee trainee;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "milestone_id")
    private Milestone milestone;
	
	@Column(name = "bonus_point", nullable = true, columnDefinition = "int default 0")
	private int bonusPoint;
	
	@Column(name = "penalty_point", nullable = true, columnDefinition = "int default 0")
	private int penaltyPoint;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "reason", nullable = false, length = 255)
	private String reason;

	public RewardPenalty() {
		super();
	}


	public RewardPenalty(long rewardPenaltyId, Trainee trainee, Milestone milestone, int bonusPoint, int penaltyPoint,
			LocalDate date, String reason) {
		super();
		this.rewardPenaltyId = rewardPenaltyId;
		this.trainee = trainee;
		this.milestone = milestone;
		this.bonusPoint = bonusPoint;
		this.penaltyPoint = penaltyPoint;
		this.date = date;
		this.reason = reason;
	}


	public RewardPenalty(RewardPenaltyModel rewardPenaltyModel, Milestone milestone) {
		this.milestone = milestone;
		if(!(rewardPenaltyModel.getRewardPenaltyId().isEmpty())) {
			this.rewardPenaltyId = Long.parseLong(rewardPenaltyModel.getRewardPenaltyId()) ;
		}
		if(!(rewardPenaltyModel.getPenaltyPoint().isEmpty())) {
			this.penaltyPoint =  Integer.parseInt(rewardPenaltyModel.getPenaltyPoint());
		}
		if (!(rewardPenaltyModel.getBonusPoint().isEmpty())) {
			this.bonusPoint = Integer.parseInt(rewardPenaltyModel.getBonusPoint());
		}
		this.date = rewardPenaltyModel.getDate();
		this.reason = rewardPenaltyModel.getReason();
	}


	public long getRewardPenaltyId() {
		return rewardPenaltyId;
	}

	public void setRewardPenaltyId(long rewardPenaltyId) {
		this.rewardPenaltyId = rewardPenaltyId;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	public Milestone getMilestone() {
		return milestone;
	}

	public void setMilestone(Milestone milestone) {
		this.milestone = milestone;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public int getPenaltyPoint() {
		return penaltyPoint;
	}

	public void setPenaltyPoint(int penaltyPoint) {
		this.penaltyPoint = penaltyPoint;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "RewardPenalty [rewardPenaltyId=" + rewardPenaltyId + ", bonusPoint=" + bonusPoint + ", penaltyPoint="
				+ penaltyPoint + ", reason=" + reason + "]";
	}

}
