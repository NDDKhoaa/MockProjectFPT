package fa.mockproject.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fa.mockproject.model.PositionModel;

@Entity
@Table(name = "Position")
public class Position {
	@Id
	@Column(name = "position_id", length = 20, unique = true, nullable = false)
	private String positionId;

	@Column(name = "position_name", length = 255, nullable = false)
	private String positionName;

	@Column(name = "remarks", length = 255, nullable = true)
	private String remarks;

	@OneToMany(mappedBy = "position")
	private List<ClassBatch> classBatchs;

	public Position() {
		super();
	}
	
	public Position(String positionId, String positionName, String remarks, List<ClassBatch> classBatchs) {
		super();
		this.positionId = positionId;
		this.positionName = positionName;
		this.remarks = remarks;
		this.classBatchs = classBatchs;
	}

	public Position(PositionModel positionModel) {
		super();
		this.positionId = positionModel.getPositionId();
		this.positionName = positionModel.getPositionName();
		this.remarks = positionModel.getRemarks();
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
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
		return "Position [positionId=" + positionId + ", positionName=" + positionName + ", remarks=" + remarks + "]";
	}
	
}
