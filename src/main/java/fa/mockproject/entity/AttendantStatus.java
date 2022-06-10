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
@Table(name = "AttendantStatus")
public class AttendantStatus {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "attendant_status_id")
    private int attendantStatusId;
	
	//TraineeID
	@ManyToOne
	@JoinColumn(name = "trainee_candidate_id", nullable = false)
	private Trainee trainee;
	
	@Column(name = "discipline_point", nullable = false)
	private int disciplinePoint;
	
	@Column(name = "mileStones", nullable = false)
	private int mileStones;
	
	@Column(name = "remarks", nullable = true, length = 255)
	private String remarks;

	public AttendantStatus() {
		super();
	}

	public AttendantStatus(int attendantStatusId, int disciplinePoint, int mileStones, String remarks) {
		super();
		this.attendantStatusId = attendantStatusId;
		this.disciplinePoint = disciplinePoint;
		this.mileStones = mileStones;
		this.remarks = remarks;
	}

	public AttendantStatus(int attendantStatusId, Trainee trainee, int disciplinePoint, int mileStones, String remarks) {
		super();
		this.attendantStatusId = attendantStatusId;
		this.trainee = trainee;
		this.disciplinePoint = disciplinePoint;
		this.mileStones = mileStones;
		this.remarks = remarks;
	}

	public int getAttendantStatusId() {
		return attendantStatusId;
	}

	public void setAttendantStatusId(int attendantStatusId) {
		this.attendantStatusId = attendantStatusId;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	public int getDisciplinePoint() {
		return disciplinePoint;
	}

	public void setDisciplinePoint(int disciplinePoint) {
		this.disciplinePoint = disciplinePoint;
	}

	public int getMileStones() {
		return mileStones;
	}

	public void setMileStones(int mileStones) {
		this.mileStones = mileStones;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "AttendantStatus [attendantStatusId=" + attendantStatusId + ", disciplinePoint=" + disciplinePoint
				+ ", mileStones=" + mileStones + ", remarks=" + remarks + "]";
	}
}
