package fa.mockproject.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	@OneToOne(mappedBy = "formatType")
	private ClassBatch classBatch;

	public FormatType() {
		super();
	}

	public FormatType(long formatTypeId, String formatTypeName, String remarks, ClassBatch classBatch) {
		super();
		this.formatTypeId = formatTypeId;
		this.formatTypeName = formatTypeName;
		this.remarks = remarks;
		this.classBatch = classBatch;
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

	public ClassBatch getClassBatch() {
		return classBatch;
	}

	public void setClassBatch(ClassBatch classBatch) {
		this.classBatch = classBatch;
	}

	@Override
	public String toString() {
		return "FormatType [formatTypeId=" + formatTypeId + ", formatTypeName=" + formatTypeName + ", remarks="
				+ remarks + ", classBatch=" + classBatch + "]";
	}
	
}
