package fa.mockproject.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fa.mockproject.model.ClassTypeModel;

@Entity
@Table(name = "ClassType")
public class ClassType {
	@Id
	@Column(name = "class_type_id", length = 20)
	private String classTypeId;
	@Column(name = "class_type_name", nullable = false)
	private String classTypeName;
	@Column(name = "remarks", nullable = true)
	private String remarks;
	@OneToMany(mappedBy = "classType", fetch = FetchType.LAZY)
	private List<ClassBatch> classBatchs;
	
	public ClassType() {
		super();
	}

	public ClassType(String classTypeId, String classTypeName, String remarks, List<ClassBatch> classBatchs) {
		super();
		this.classTypeId = classTypeId;
		this.classTypeName = classTypeName;
		this.remarks = remarks;
		this.classBatchs = classBatchs;
	}
	
	public ClassType(ClassTypeModel classTypeModel) {
		super();
		this.classTypeId = classTypeModel.getClassTypeId();
		this.classTypeName = classTypeModel.getClassTypeName();
		this.remarks = classTypeModel.getRemarks();
	}

	public String getClassTypeId() {
		return classTypeId;
	}

	public void setClassTypeId(String classTypeId) {
		this.classTypeId = classTypeId;
	}

	public String getClassTypeName() {
		return classTypeName;
	}

	public void setClassTypeName(String classTypeName) {
		this.classTypeName = classTypeName;
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

	@Override
	public String toString() {
		return "ClassType [classTypeId=" + classTypeId + ", classTypeName=" + classTypeName + ", remarks=" + remarks
				+ "]";
	}
	
}
