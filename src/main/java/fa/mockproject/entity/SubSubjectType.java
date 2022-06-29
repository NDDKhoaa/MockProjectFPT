package fa.mockproject.entity;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fa.mockproject.model.SubSubjectTypeModel;

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
    
    @OneToMany(mappedBy = "subSubjectType", fetch = FetchType.LAZY)
    private List<ClassBatch> classBatchs;

	public SubSubjectType() {
		super();
	}

	public SubSubjectType(long subSubjectTypeId, String subSubjectTypeName, String remarks,
			List<ClassBatch> classBatchs) {
		super();
		this.subSubjectTypeId = subSubjectTypeId;
		this.subSubjectTypeName = subSubjectTypeName;
		this.remarks = remarks;
		this.classBatchs = classBatchs;
	}

	public SubSubjectType(SubSubjectTypeModel subSubjectTypeModel) {
		super();
		this.subSubjectTypeId = subSubjectTypeModel.getSubSubjectTypeId();
		this.subSubjectTypeName = subSubjectTypeModel.getSubSubjectTypeName();
		this.remarks = subSubjectTypeModel.getRemarks();
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

	public List<ClassBatch> getClassBatchs() {
		return classBatchs;
	}

	public void setClassBatchs(List<ClassBatch> classBatchs) {
		this.classBatchs = classBatchs;
	}
    
}
