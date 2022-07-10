package fa.mockproject.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fa.mockproject.model.AllocationModel;

@Entity
@Table(name = "Allocation")
public class Allocation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "allowance_id", nullable = false)
    private long allocationId;

    @OneToOne
    @JoinColumn(name = "trainee_candidate_id", nullable = false)
    private Trainee trainee;

    @Column(name = "allocation_name")
    private String allocationName;
    
    @Column(name = "salary")
    private String salary;
    
    @Column(name = "start_date")
    private LocalDate startDate;
    
    @Column(name = "allocation_status")
    private String allocationStatus;
    
    @Column(name = "remarks")
    private String remarks;

	public long getAllocationId() {
		return allocationId;
	}

	public void setAllocationId(long allocationId) {
		this.allocationId = allocationId;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	public String getAllocationName() {
		return allocationName;
	}

	public void setAllocationName(String allocationName) {
		this.allocationName = allocationName;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public String getAllocationStatus() {
		return allocationStatus;
	}

	public void setAllocationStatus(String allocationStatus) {
		this.allocationStatus = allocationStatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Allocation(long allocationId, Trainee trainee, String allocationName, String salary, LocalDate startDate,
			String allocationStatus, String remarks) {
		super();
		this.allocationId = allocationId;
		this.trainee = trainee;
		this.allocationName = allocationName;
		this.salary = salary;
		this.startDate = startDate;
		this.allocationStatus = allocationStatus;
		this.remarks = remarks;
	}

	public Allocation() {
		super();
	}

	public Allocation(AllocationModel allocationModel) {
		this.allocationId = allocationModel.getAllocationId();
		this.trainee = allocationModel.getTrainee();
		this.allocationName = allocationModel.getAllocationName();
		this.salary = allocationModel.getSalary();
		this.startDate = allocationModel.getStartDate();
		this.allocationStatus = allocationModel.getAllocationStatus();
		this.remarks = allocationModel.getAllocationRemarks();
	}
    
    
}
