package fa.mockproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "SubSubjectType")
@Cacheable
public class SubSubjectType {
	@Id
	@Column(name = "sub_subject_type_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long subSubjectTypeId;
	
	@Column(name = "sub_subject_type_name", length = 255, nullable = false)
	private String subSubjectTypeName;
	
    @Column(name = "remarks", length = 255, nullable = true)
    private String remarks;
    
    @OneToOne(mappedBy = "subSubjectType")
    private ClassBatch classBatch;

	public SubSubjectType() {
		super();
	}

	public SubSubjectType(long subSubjectTypeId, String subSubjectTypeName, String remarks, ClassBatch classBatch) {
		super();
		this.subSubjectTypeId = subSubjectTypeId;
		this.subSubjectTypeName = subSubjectTypeName;
		this.remarks = remarks;
		this.classBatch = classBatch;
	}

	public long getSubSubjectTypeId() {
		return subSubjectTypeId;
	}

	public void setSubSubjectTypeId(long subSubjectTypeId) {
		this.subSubjectTypeId = subSubjectTypeId;
	}

	public String getSubSubjectTypeName() {
		return subSubjectTypeName;
	}

	public void setSubSubjectTypeName(String subSubjectTypeName) {
		this.subSubjectTypeName = subSubjectTypeName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public ClassBatch getClassBatch() {
		return classBatch;
	}

	public void setClassBatch(ClassBatch classBatch) {
		this.classBatch = classBatch;
	}

	@Override
	public String toString() {
		return "SubSubjectType [subSubjectTypeId=" + subSubjectTypeId + ", subSubjectTypeName=" + subSubjectTypeName
				+ ", remarks=" + remarks + ", classBatch=" + classBatch + "]";
	}
    
}
