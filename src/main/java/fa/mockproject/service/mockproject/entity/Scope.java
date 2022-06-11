package fa.mockproject.service.mockproject.entity;

import fa.mockproject.entity.ClassBatch;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Scope")
@Cacheable
public class Scope {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int scope_id;
	
	@OneToOne
	@JoinColumn(name = "class_id", nullable = false)
	private ClassBatch classBatch;

	@Column(name="remarks")
	private int remarks;



	public int getScope_id() {
		return scope_id;
	}

	public void setScope_id(int scope_id) {
		this.scope_id = scope_id;
	}

	public ClassBatch getClassBatch() {
		return classBatch;
	}

	public void setClassBatch(ClassBatch classBatch) {
		this.classBatch = classBatch;
	}

	public int getRemarks() {
		return remarks;
	}

	public void setRemarks(int remarks) {
		this.remarks = remarks;
	}


	@Override
	public String toString() {
		return "Scope [scope_id=" + scope_id + ", classBatch=" + classBatch + ", remarks=" + remarks + "]";
	}

	public Scope(int scope_id, ClassBatch classBatch, int remarks) {
		super();
		this.scope_id = scope_id;
		this.classBatch = classBatch;
		this.remarks = remarks;
	}
	
	
}
