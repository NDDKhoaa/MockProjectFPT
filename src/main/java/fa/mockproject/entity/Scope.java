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

import fa.mockproject.model.ScopeModel;

@Entity
@Table(name = "Scope")
@Cacheable
public class Scope {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long scopeId;
	
	@Column(name = "scope_name", length = 255, nullable = false)
	private String scopeName;
	
	@OneToMany(mappedBy = "scope", fetch = FetchType.LAZY)
	private List<ClassBatch> classBatchs;
	
	@Column(name="remarks", length = 255, nullable = true)
	private String remarks;

	public Scope() {
		super();
	}

	public Scope(long scopeId, String scopeName, List<ClassBatch> classBatchs, String remarks) {
		super();
		this.scopeId = scopeId;
		this.scopeName = scopeName;
		this.classBatchs = classBatchs;
		this.remarks = remarks;
	}

	public Scope(ScopeModel scopeModel) {
		super();
		this.scopeId = scopeModel.getScopeId();
		this.scopeName = scopeModel.getScopeName();
		this.remarks = scopeModel.getRemarks();
	}

	public long getScopeId() {
		return scopeId;
	}

	public void setScopeId(long scopeId) {
		this.scopeId = scopeId;
	}

	public String getScopeName() {
		return scopeName;
	}

	public void setScopeName(String scopeName) {
		this.scopeName = scopeName;
	}

	public List<ClassBatch> getClassBatchs() {
		return classBatchs;
	}

	public void setClassBatchs(List<ClassBatch> classBatchs) {
		this.classBatchs = classBatchs;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Scope [scopeId=" + scopeId + ", scopeName=" + scopeName + ", remarks=" + remarks + "]";
	}
	
}
