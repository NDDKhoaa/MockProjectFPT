package fa.mockproject.entity;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fa.mockproject.model.TrainerModel;

@Entity
@Table(name = "Trainer")
@Cacheable
public class Trainer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "trainer_id")
	private long trainerId;
	
	@Column(name= "type", length = 255, nullable =  false)
	private String type;
	
	@OneToOne(mappedBy = "trainer", cascade = CascadeType.ALL)
	private TrainerProfile trainerProfile;
	
	@ManyToOne
	@JoinColumn(name = "class_id")
	private ClassBatch classBatch;
	
	@Column(name = "remarks", length = 255, nullable =  true)
	private String remarks;

	public Trainer() {
		super();
	}

	public Trainer(long trainerId, String type, TrainerProfile trainerProfile, ClassBatch classBatch, String remarks) {
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
		this.trainerProfile = trainerModel.getTrainerProfileModel();
		this.classBatch = classBatch;
		this.remarks = trainerModel.getRemarks();
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

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", type=" + type + ", trainerProfile=" + trainerProfile
				+ ", classBatch=" + classBatch + ", remarks=" + remarks + "]";
	}
	
}
