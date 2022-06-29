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

import fa.mockproject.model.FormatTypeModel;

@Entity
@Table(name = "FormatType")
@Cacheable
public class FormatType {
	
	@Id
	@Column(name = "format_type_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long formatTypeId;

	@Column(name= "format_type_name", length = 255, nullable = false)
	private String formatTypeName;
	
	@Column(name= "remarks", length = 255, nullable = true)
	private String remarks;
	
	@OneToMany(mappedBy = "formatType", fetch = FetchType.LAZY)
	private List<ClassBatch> classBatchs;

	public FormatType() {
		super();
	}

	public FormatType(long formatTypeId, String formatTypeName, String remarks, List<ClassBatch> classBatchs) {
		super();
		this.formatTypeId = formatTypeId;
		this.formatTypeName = formatTypeName;
		this.remarks = remarks;
		this.classBatchs = classBatchs;
	}

	public FormatType(FormatTypeModel formatTypeModel) {
		super();
		this.formatTypeId = formatTypeModel.getFormatTypeId();
		this.formatTypeName = formatTypeModel.getFormatTypeName();
		this.remarks = formatTypeModel.getRemarks();
	}

	public long getFormatTypeId() {
		return formatTypeId;
	}

	public void setFormatTypeId(long formatTypeId) {
		this.formatTypeId = formatTypeId;
	}

	public String getFormatTypeName() {
		return formatTypeName;
	}

	public void setFormatTypeName(String formatTypeName) {
		this.formatTypeName = formatTypeName;
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
