package fa.mockproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "Sub_Subject_Type")
@Cacheable
public class SubSubjectType {
	@Id
	@Column(name="Sub_Subject_Type_ID",unique=true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long subSubjectTypeId;
	
    @Column(name="Remarks",nullable=true)
    private String remarks;
    
    @Column(name="Sub_Subject_Type_Name")
    private String subSubjectTypeName;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Class_ID") 
    private ClassBatch classBatchClassId;
    
    public SubSubjectType() {
		// TODO Auto-generated constructor stub
	}

	public SubSubjectType(String remarks, String subSubjectTypeName) {
		this.remarks = remarks;
		this.subSubjectTypeName = subSubjectTypeName;
	}

	public long getSubSubjectTypeId() {
		return subSubjectTypeId;
	}

	public void setSubSubjectTypeId(long subSubjectTypeId) {
		this.subSubjectTypeId = subSubjectTypeId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSubSubjectTypeName() {
		return subSubjectTypeName;
	}

	public void setSubSubjectTypeName(String subSubjectTypeName) {
		this.subSubjectTypeName = subSubjectTypeName;
	}

	public ClassBatch getClassBatchClassId() {
		return classBatchClassId;
	}

	public void setClassBatchClassId(ClassBatch classBatchClassId) {
		this.classBatchClassId = classBatchClassId;
	}

	@Override
	public String toString() {
		return "SubSubjectType [subSubjectTypeId=" + subSubjectTypeId +", remarks=" + remarks
				+ ", subSubjectTypeName=" + subSubjectTypeName + "]";
	}
    
}
