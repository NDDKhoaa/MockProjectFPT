package fa.mockproject.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fa.mockproject.entity.enumtype.TrainerTypeEnum;
import fa.mockproject.model.TrainerModel;

@Entity
@Table(name = "Trainer")
@Cacheable
public class Trainer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "trainer_id")
	private long trainerId;

	@Enumerated(EnumType.STRING)
	@Column(name= "type", length = 255, nullable =  false)
	private TrainerTypeEnum type;
	
	@ManyToOne
	@JoinColumn(name = "trainer_profile_id")
	private TrainerProfile trainerProfile;

	@ManyToOne
	@JoinColumn(name = "class_id")
	private ClassBatch classBatch;

	@Column(name = "remarks", length = 255, nullable = true)
	private String remarks;

	public Trainer() {
		super();
	}

	public Trainer(long trainerId, TrainerTypeEnum type, TrainerProfile trainerProfile, ClassBatch classBatch, String remarks) {
		super();
		this.trainerId = trainerId;
		this.type = type;
		this.trainerProfile = trainerProfile;
		this.classBatch = classBatch;
		this.remarks = remarks;
	}

	public Trainer(TrainerModel trainerModel, ClassBatch classBatch) {
		super();
		this.trainerId = trainerModel.getTrainerId();
		this.type = trainerModel.getType();
		this.trainerProfile = new TrainerProfile(trainerModel);
		this.classBatch = classBatch;
		this.remarks = trainerModel.getRemarks();
	}
	public Trainer(TrainerModel trainerModel) {
		super();
		this.trainerId = trainerModel.getTrainerId();
		this.type = trainerModel.getType();
		this.trainerProfile = new TrainerProfile(trainerModel);
		this.remarks = trainerModel.getRemarks();
	}
	public long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(long trainerId) {
		this.trainerId = trainerId;
	}

	public TrainerTypeEnum getType() {
		return type;
	}

	public void setType(TrainerTypeEnum type) {
		this.type = type;
	}

	public TrainerProfile getTrainerProfile() {
		return trainerProfile;
	}

	public void setTrainerProfile(TrainerProfile trainerProfile) {
		this.trainerProfile = trainerProfile;
	}

	public ClassBatch getClassBatch() {
		return classBatch;
	}

	public void setClassBatch(ClassBatch classBatch) {
		this.classBatch = classBatch;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}