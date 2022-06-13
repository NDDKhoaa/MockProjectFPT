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
@Table(name = "Scope")
@Cacheable
public class Scope {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long scopeId;
	
	@Column(name = "scope_name", length = 255, nullable = false)
	private String scopeName;
	
	@OneToOne(mappedBy = "scope")
	private ClassBatch classBatch;
	
	@Column(name="remarks", length = 255, nullable = true)
	private String remarks;

	public Scope() {
		super();
	}

	public Scope(long scopeId, String scopeName, ClassBatch classBatch, String remarks) {
		super();
		this.scopeId = scopeId;
		this.scopeName = scopeName;
		this.classBatch = classBatch;
		this.remarks = remarks;
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

	public ClassBatch getClassBatch() {
		return classBatch;
	}

	public void setClassBatch(ClassBatch classBatch) {
		this.classBatch = classBatch;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
