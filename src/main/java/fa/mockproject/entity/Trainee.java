package fa.mockproject.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Trainee")
public class Trainee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "trainee_candiDate_id")
	private int traineeCandidateID;

	// Foreign key cua table Class Batch


	@OneToOne(mappedBy = "trainee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private TraineeCandidateProfile traineeCandidateProfile;

	@Column(name = "remarks", nullable = true)
	private int remarks;

	public Trainee() {
		super();
	}

	public Trainee(int traineeCandidateID, int remarks) {
		super();
		this.traineeCandidateID = traineeCandidateID;
		this.remarks = remarks;
	}

	public int getTraineeCandidateID() {
		return traineeCandidateID;
	}

	public void setTraineeCandidateID(int traineeCandidateID) {
		this.traineeCandidateID = traineeCandidateID;
	}

	public TraineeCandidateProfile getTraineeCandidate() {
		return traineeCandidateProfile;
	}

	public void setTraineeCandidate(TraineeCandidateProfile traineeCandidate) {
		this.traineeCandidateProfile = traineeCandidate;
	}



	public TraineeCandidateProfile getTraineeCandidateProfile() {
		return traineeCandidateProfile;
	}

	public void setTraineeCandidateProfile(TraineeCandidateProfile traineeCandidateProfile) {
		this.traineeCandidateProfile = traineeCandidateProfile;
	}

	public int getRemarks() {
		return remarks;
	}

	public void setRemarks(int remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Trainee [traineeCandidateID=" + traineeCandidateID + ", remarks=" + remarks + "]";
	}
}
