package fa.mockproject.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import fa.mockproject.entity.Allocation;
import fa.mockproject.entity.Trainee;

public class AllocationModel {
	private long allocationId;
	private Trainee trainee;
	private String allocationName;
	private String salary;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	private String allocationStatus;
	private String allocationRemarks;
	public AllocationModel() {
		super();
	}
	
	public AllocationModel(long allocationId, String allocationName, String salary, LocalDate startDate,
			String allocationStatus, String remarks) {
		super();
		this.allocationId = allocationId;
		this.allocationName = allocationName;
		this.salary = salary;
		this.startDate = startDate;
		this.allocationStatus = allocationStatus;
		this.allocationRemarks = remarks;
	}

	public AllocationModel(long allocationId, Trainee trainee, String allocationName, String salary,
			LocalDate startDate, String allocationStatus, String remarks) {
		super();
		this.allocationId = allocationId;
		this.trainee = trainee;
		this.allocationName = allocationName;
		this.salary = salary;
		this.startDate = startDate;
		this.allocationStatus = allocationStatus;
		this.allocationRemarks = remarks;
	}
	public AllocationModel(Allocation allocation) {
		this.allocationId = allocation.getAllocationId();
		this.trainee = allocation.getTrainee();
		this.allocationName = allocation.getAllocationName();
		this.salary = allocation.getSalary();
		this.startDate = allocation.getStartDate();
		this.allocationStatus = allocation.getAllocationStatus();
		this.allocationRemarks = allocation.getRemarks();
	}
	
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

	public String getAllocationRemarks() {
		return allocationRemarks;
	}

	public void setAllocationRemarks(String allocationRemarks) {
		this.allocationRemarks = allocationRemarks;
	}

	@Override
	public String toString() {
		return "AllocationModel [allocationId=" + allocationId +  ", allocationName="
				+ allocationName + ", salary=" + salary + ", startDate=" + startDate + ", allocationStatus="
				+ allocationStatus + ", remarks=" + allocationRemarks + "]";
	}
	
	
}
