package fa.mockproject.service.mockproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "Subject_Type")
@Cacheable
public class SubjectType {
	@Id
	@Column(name="Subject_Type_ID",unique=true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long subjectTypeId;
	
	@Column(name="Class_ID")
    private long classId;
    
    @Column(name="Remarks",nullable=true)
    private String remarks;
    
    @Column(name="Subject_Type_Name")
    private String subjectTypeName;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Class_ID") 
    private fa.mockproject.service.mockproject.entity.ClassBatch classBatchClassId;
    
    public SubjectType() {
		// TODO Auto-generated constructor stub
	}

	public SubjectType(long classId, String remarks, String subjectTypeName) {
		super();
		this.classId = classId;
		this.remarks = remarks;
		this.subjectTypeName = subjectTypeName;
	}

	public long getSubjectTypeId() {
		return subjectTypeId;
	}

	public void setSubjectTypeId(long subjectTypeId) {
		this.subjectTypeId = subjectTypeId;
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

	public String getSubjectTypeName() {
		return subjectTypeName;
	}

	public void setSubjectTypeName(String subjectTypeName) {
		this.subjectTypeName = subjectTypeName;
	}

	public fa.mockproject.service.mockproject.entity.ClassBatch getClassBatchClassId() {
		return classBatchClassId;
	}

	public void setClassBatchClassId(ClassBatch classBatchClassId) {
		this.classBatchClassId = classBatchClassId;
	}

	@Override
	public String toString() {
		return "SubjectType [subjectTypeId=" + subjectTypeId + ", classId=" + classId + ", remarks=" + remarks
				+ ", subjectTypeName=" + subjectTypeName + "]";
	}
    
    
}
