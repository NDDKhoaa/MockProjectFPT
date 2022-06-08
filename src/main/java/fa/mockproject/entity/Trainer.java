package fa.mockproject.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Trainer")
@Cacheable
public class Trainer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "trainer_id")
	private int trainer_id;
	
	@OneToOne
	@JoinColumn(name = "class_id", nullable = false)
	private ClassBatch classBatch;
	
	@OneToOne
	@JoinColumn(name= "trainerprofile_id")
	private int trainerprofile_id;
	
	@Column(name= "type")
	private int type;
	
	@Column(name="remarks")
	private int remarks;
	


	public int getTrainer_id() {
		return trainer_id;
	}

	public void setTrainer_id(int trainer_id) {
		this.trainer_id = trainer_id;
	}

	public ClassBatch getClassBatch() {
		return classBatch;
	}

	public void setClassBatch(ClassBatch classBatch) {
		this.classBatch = classBatch;
	}

	public int getTrainerprofile_id() {
		return trainerprofile_id;
	}

	public void setTrainerprofile_id(int trainerprofile_id) {
		this.trainerprofile_id = trainerprofile_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getRemarks() {
		return remarks;
	}

	public void setRemarks(int remarks) {
		this.remarks = remarks;
	}


	@Override
	public String toString() {
		return "Trainer [trainer_id=" + trainer_id + ", classBatch=" + classBatch + ", trainerprofile_id="
				+ trainerprofile_id + ", type=" + type + ", remarks=" + remarks + "]";
	}

	public Trainer(int trainer_id, ClassBatch classBatch, int trainerprofile_id, int type, int remarks) {
		super();
		this.trainer_id = trainer_id;
		this.classBatch = classBatch;
		this.trainerprofile_id = trainerprofile_id;
		this.type = type;
		this.remarks = remarks;
	}
	
	
	
}
