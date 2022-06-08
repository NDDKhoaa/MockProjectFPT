package fa.mockproject.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Guarantee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "guarantee_id", nullable = false, unique=true)
    private int guaranteeId;
	
	//TraineeID
	@ManyToOne
	@JoinColumn(name = "trainee_candidate_id", nullable = false)
	private Trainee trainee;
	
	@Column(name = "FSU", nullable = false)
	private int FSU;
	
	@Column(name = "comments", nullable = false)
	private int comments;

	public Guarantee() {
		super();
	}

	public Guarantee(int guaranteeId, int fSU, int comments) {
		super();
		this.guaranteeId = guaranteeId;
		FSU = fSU;
		this.comments = comments;
	}

	public Guarantee(int guaranteeId, Trainee trainee, int fSU, int comments) {
		super();
		this.guaranteeId = guaranteeId;
		this.trainee = trainee;
		FSU = fSU;
		this.comments = comments;
	}

	public int getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(int guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	public int getFSU() {
		return FSU;
	}

	public void setFSU(int fSU) {
		FSU = fSU;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Guarantee [guaranteeId=" + guaranteeId + ", FSU=" + FSU + ", comments=" + comments + "]";
	}
}
