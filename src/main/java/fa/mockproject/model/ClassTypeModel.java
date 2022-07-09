package fa.mockproject.model;

import fa.mockproject.entity.ClassType;

public class ClassTypeModel {
	
	private String classTypeId;
	private String classTypeName;
	private String remarks;
	
	public ClassTypeModel() {
		super();
	}
	
	public ClassTypeModel(String classTypeId, String classTypeName, String remarks) {
		super();
		this.classTypeId = classTypeId;
		this.classTypeName = classTypeName;
		this.remarks = remarks;
	}
	
	public ClassTypeModel(ClassType classType) {
		super();
		this.classTypeId = classType.getClassTypeId();
		this.classTypeName = classType.getClassTypeName();
		this.remarks = classType.getRemarks();
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

	@Override
	public String toString() {
		return "ClassTypeModel [classTypeId=" + classTypeId + ", classTypeName=" + classTypeName + ", remarks="
				+ remarks + "]";
	}
}
