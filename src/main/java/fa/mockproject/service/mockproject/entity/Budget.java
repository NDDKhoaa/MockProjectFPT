package fa.mockproject.service.mockproject.entity;

import fa.mockproject.entity.ClassBatch;

import javax.persistence.*;

@Entity
@Table(name="Budget")
@Cacheable
public class Budget {
    @Id
    @Column(name="Budget_ID",unique=true)
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long budgetId;
    
    @Column(name="Class_ID")
    private long classId;
    
    @Column(name="Remarks",nullable=true)
    private String remarks;
    
    @Column(name="Budget_Name")
    private String budgetName;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Class_ID") 
    private ClassBatch classBatchClassId;
    
    public Budget() {
		// TODO Auto-generated constructor stub
	}

	public Budget(long classId, String remarks, String budgetName) {
		super();
		this.classId = classId;
		this.remarks = remarks;
		this.budgetName = budgetName;
	}

	public long getBudgetId() {
		return budgetId;
	}

	public void setBudgetId(long budgetId) {
		this.budgetId = budgetId;
	}

	public long getClassId() {
		return classId;
	}

	public void setClassId(long classId) {
		this.classId = classId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getBudgetName() {
		return budgetName;
	}

	public void setBudgetName(String budgetName) {
		this.budgetName = budgetName;
	}

	public ClassBatch getClassBatchClassId() {
		return classBatchClassId;
	}

	public void setClassBatchClassId(ClassBatch classBatchClassId) {
		this.classBatchClassId = classBatchClassId;
	}

	@Override
	public String toString() {
		return "Budget [budgetId=" + budgetId + ", classId=" + classId + ", remarks=" + remarks + ", budgetName="
				+ budgetName + "]";
	}
    
}
