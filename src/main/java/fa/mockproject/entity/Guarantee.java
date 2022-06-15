package fa.mockproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Guarantee")
public class Guarantee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "guarantee_id")
    private long guaranteeId;
	
	//TraineeID
	@ManyToOne
	@JoinColumn(name = "trainee_candidate_id", nullable = false)
	private Trainee trainee;
	
	@Column(name = "FSU", nullable = false)
	private int FSU;
	
	@Column(name = "comments", nullable = false, length = 255)
	private String comments;

	public Guarantee() {
		super();
	}

	public Guarantee(long guaranteeId, int fSU, String comments) {
		super();
		this.guaranteeId = guaranteeId;
		FSU = fSU;
		this.comments = comments;
	}

	public Guarantee(long guaranteeId, Trainee trainee, int fSU, String comments) {
		super();
		this.guaranteeId = guaranteeId;
		this.trainee = trainee;
		FSU = fSU;
		this.comments = comments;
	}

	public long getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(long guaranteeId) {
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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Guarantee [guaranteeId=" + guaranteeId + ", FSU=" + FSU + ", comments=" + comments + "]";
	}
}
