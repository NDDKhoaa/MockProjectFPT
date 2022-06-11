package fa.mockproject.service.mockproject.entity;

import fa.mockproject.entity.ClassBatch;

import javax.persistence.*;

@Entity
@Table(name = "Sub_Subject_Type")
@Cacheable
public class SubSubjectType {
	@Id
	@Column(name="Sub_Subject_Type_ID",unique=true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long subSubjectTypeId;
	
	@Column(name="Class_ID")
    private long classId;
    
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

	public SubSubjectType(long classId, String remarks, String subSubjectTypeName) {
		super();
		this.classId = classId;
		this.remarks = remarks;
		this.subSubjectTypeName = subSubjectTypeName;
	}

	public long getSubSubjectTypeId() {
		return subSubjectTypeId;
	}

	public void setSubSubjectTypeId(long subSubjectTypeId) {
		this.subSubjectTypeId = subSubjectTypeId;
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
		return "SubSubjectType [subSubjectTypeId=" + subSubjectTypeId + ", classId=" + classId + ", remarks=" + remarks
				+ ", subSubjectTypeName=" + subSubjectTypeName + "]";
	}
    
}
