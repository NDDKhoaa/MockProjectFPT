package fa.mockproject.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import fa.mockproject.entity.RewardPenalty;

public class RewardPenaltyModel {

	long milestoneId;
	String milestoneName;
	private String rewardPenaltyId;
	private String bonusPoint;
	private String penaltyPoint;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private String reason;
	private String status;
	
	public RewardPenaltyModel() {
		super();
	}
	
	
	
	public RewardPenaltyModel(long milestoneId, String milestoneName, String rewardPenaltyId, String bonusPoint,
			String penaltyPoint, LocalDate date, String reason, String status) {
		super();
		this.milestoneId = milestoneId;
		this.milestoneName = milestoneName;
		this.rewardPenaltyId = rewardPenaltyId;
		this.bonusPoint = bonusPoint;
		this.penaltyPoint = penaltyPoint;
		this.date = date;
		this.reason = reason;
		this.status = status;
	}
	
	
	public RewardPenaltyModel(RewardPenalty rewardPenalty) {
		super();
		this.milestoneId = rewardPenalty.getMilestone().getMilestoneId();
		this.milestoneName = rewardPenalty.getMilestone().getMilestoneName();
		this.rewardPenaltyId = String.valueOf(rewardPenalty.getRewardPenaltyId());
		this.bonusPoint = String.valueOf(rewardPenalty.getBonusPoint()) ;
		this.penaltyPoint = String.valueOf(rewardPenalty.getPenaltyPoint());
		this.date = rewardPenalty.getDate();
		this.reason = rewardPenalty.getReason();
	}
	
	public long getMilestoneId() {
		return milestoneId;
	}
	public void setMilestoneId(long milestoneId) {
		this.milestoneId = milestoneId;
	}
	public String getMilestoneName() {
		return milestoneName;
	}
	public void setMilestoneName(String milestoneName) {
		this.milestoneName = milestoneName;
	}
	public String getRewardPenaltyId() {
		return rewardPenaltyId;
	}
	public void setRewardPenaltyId(String rewardPenaltyId) {
		this.rewardPenaltyId = rewardPenaltyId;
	}
	public String getBonusPoint() {
		return bonusPoint;
	}
	public void setBonusPoint(String bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	public String getPenaltyPoint() {
		return penaltyPoint;
	}
	public void setPenaltyPoint(String penaltyPoint) {
		this.penaltyPoint = penaltyPoint;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "RewardPenaltyModel [milestoneId=" + milestoneId + ", milestoneName=" + milestoneName
				+ ", rewardPenaltyId=" + rewardPenaltyId + ", bonusPoint=" + bonusPoint + ", penaltyPoint="
				+ penaltyPoint + ", date=" + date + ", reason=" + reason + ", status=" + status + "]";
	}

}
