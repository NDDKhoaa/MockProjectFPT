package fa.mockproject.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fa.mockproject.model.CurriculumnModel;

@Entity
@Table(name = "Curriculumn")
@Cacheable
public class Curriculumn {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "curriculumn_id")
	private long curriculumnId;

	@Column(name = "name", length = 255, nullable = false)
	private String name;

	@Column(name = "type", nullable = false)
	private String type;

	@Lob
	@Column(name = "content", nullable = false)
	private byte[] content;
	
	@OneToOne
	@JoinColumn(name = "class_id")
	private ClassBatch classBatch;
	
	public Curriculumn() {
		super();
	}

	public Curriculumn(long curriculumnId, String name, String type, byte[] content, ClassBatch classBatch) {
		super();
		this.curriculumnId = curriculumnId;
		this.name = name;
		this.type = type;
		this.content = content;
		this.classBatch = classBatch;
	}
	
	public Curriculumn(CurriculumnModel curriculumnModel, ClassBatch classBatch) {
		super();
		if (curriculumnModel == null) 
			return;
		this.curriculumnId = curriculumnModel.getCurriculumnId();
		this.name = curriculumnModel.getName();
		this.type = curriculumnModel.getType();
		this.content = curriculumnModel.getContent();
		this.classBatch = classBatch;
	}

	public long getCurriculumnId() {
		return curriculumnId;
	}

	public void setCurriculumnId(long curriculumnId) {
		this.curriculumnId = curriculumnId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public ClassBatch getClassBatch() {
		return classBatch;
	}

	public void setClassBatch(ClassBatch classBatch) {
		this.classBatch = classBatch;
	}
	
}
