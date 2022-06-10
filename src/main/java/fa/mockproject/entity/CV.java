package fa.mockproject.entity;

import java.sql.Blob;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fa.mockproject.model.TraineeCandidateProfileModel;

@Entity
@Table(name = "CV")
@Cacheable
public class CV {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_id", nullable = false, unique = true)
	private long cvId;

	@Column(name = "name", length = 512, nullable = false, unique = true)
	private String name;

	@Column(name = "size", nullable = true)
	private long size;

	@Column(name = "content", nullable = true)
	private Blob content;

	@ManyToOne
	@JoinColumn(name = "candidate_id", nullable = true)
	private Candidate candidate;

	public long getCvId() {
		return cvId;
	}

	public void setCvId(long cvId) {
		this.cvId = cvId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Blob getContent() {
		return content;
	}

	public void setContent(Blob content) {
		this.content = content;
	}

	public CV(long cvId, String name) {
		super();
		this.cvId = cvId;
		this.name = name;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public CV() {
		super();
	}

	public CV(TraineeCandidateProfileModel model) {
		super();
		this.name = model.getCVname();
		this.size = model.getSize();
		this.content = model.getContent();
	}

	@Override
	public String toString() {
		return "CV [cvId=" + cvId + ", name=" + name + ", size=" + size + "]";
	}

}
