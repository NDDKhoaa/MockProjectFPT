package fa.mockproject.entity;

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

@Entity
@Table(name = "AttendantDayCheck")
public class AttendantDayCheck {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "day_check_id")
	private long id;
	
	@Column(name = "day_check")
	private int dayCheck;
	
	@Column(name = "attendant_status")
	private String attendantStatus;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "milestone_id")
	private Milestone milestone;

	public AttendantDayCheck() {
		super();
	}

	public AttendantDayCheck(long id, int dayCheck, String attendantStatus, Milestone milestone) {
		super();
		this.id = id;
		this.dayCheck = dayCheck;
		this.attendantStatus = attendantStatus;
		this.milestone = milestone;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public int getDayCheck() {
		return dayCheck;
	}

	public void setDayCheck(int dayCheck) {
		this.dayCheck = dayCheck;
	}

	public String getAttendantStatus() {
		return attendantStatus;
	}

	public void setAttendantStatus(String attendantStatus) {
		this.attendantStatus = attendantStatus;
	}

	public Milestone getMilestone() {
		return milestone;
	}

	public void setMilestone(Milestone milestone) {
		this.milestone = milestone;
	} 
	
	
}
