package fa.mockproject.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Milestone")
public class Milestone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "milestone_id")
	private long milestoneId;
	
	@Column(name = "milestone_name")
	private String milestoneName;
	
	@Column(name = "salary_paid")
	private String salaryPaid;
	
	@Column(name = "start_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	
	@ManyToOne
	@JoinColumn(name = "trainee_candidate_id")
	private Trainee trainee;
	
	@OneToMany(mappedBy = "milestone", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Topic> topics;

	@OneToMany(mappedBy="milestone", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AttendantDayCheck> attendantDayChecks;
	
	public Milestone() {
		super();
	}

	public Milestone(long milestoneId, String milestoneName, String salaryPaid, LocalDate startDate, LocalDate endDate,
			Trainee trainee, List<Topic> topics, List<fa.mockproject.entity.AttendantDayCheck> attendantDayChecks) {
		super();
		this.milestoneId = milestoneId;
		this.milestoneName = milestoneName;
		this.salaryPaid = salaryPaid;
		this.startDate = startDate;
		this.endDate = endDate;
		this.trainee = trainee;
		this.topics = topics;
		this.attendantDayChecks = attendantDayChecks;
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

	public String getSalaryPaid() {
		return salaryPaid;
	}

	public void setSalaryPaid(String salaryPaid) {
		this.salaryPaid = salaryPaid;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
	
	
	
	public List<AttendantDayCheck> getAttendantDayChecks() {
		return attendantDayChecks;
	}

	public void setAttendantDayChecks(List<AttendantDayCheck> attendantDayChecks) {
		this.attendantDayChecks = attendantDayChecks;
	}

	@Override
	public String toString() {
		return "Milestone [milestoneId=" + milestoneId + ", milestoneName=" + milestoneName + ", salaryPaid="
				+ salaryPaid + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
}
