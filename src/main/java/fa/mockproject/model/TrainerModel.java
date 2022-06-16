package fa.mockproject.model;

import fa.mockproject.entity.Trainer;

public class TrainerModel {
	
	private long trainerId;
	private String type;
	private TrainerProfileModel trainerProfileModel;
	private String remarks;
	
	public TrainerModel() {
		super();
	}

	public TrainerModel(long trainerId, String type, TrainerProfileModel trainerProfileModel, String remarks) {
		super();
		this.trainerId = trainerId;
		this.type = type;
		this.trainerProfileModel = trainerProfileModel;
		this.remarks = remarks;
	}

	public TrainerModel(Trainer trainer) {
		super();
		this.trainerId = trainer.getTrainerId();
		this.type = trainer.getType();
		this.trainerProfileModel = new TrainerProfileModel(trainer.getTrainerProfile());
		this.remarks = trainer.getRemarks();
	}

	public long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(long trainerId) {
		this.trainerId = trainerId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public TrainerProfileModel getTrainerProfileModel() {
		return trainerProfileModel;
	}

	public void setTrainerProfileModel(TrainerProfileModel trainerProfileModel) {
		this.trainerProfileModel = trainerProfileModel;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "TrainerModel [trainerId=" + trainerId + ", type=" + type + ", trainerProfileModel="
				+ trainerProfileModel + ", remarks=" + remarks + "]";
	}
	
}
