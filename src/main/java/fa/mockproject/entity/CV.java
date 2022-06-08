package fa.mockproject.entity;

import java.util.Arrays;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CV")
@Cacheable
public class CV {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "cv_id", nullable = false, unique = true)
	private long cvId;

	@Column(name = "name", length = 512, nullable = false,unique = true)
	private String name;

	@Column(name = "content", nullable = false)
	private byte[] content;

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

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public CV(String name, byte[] content) {
		super();
		this.name = name;
		this.content = content;
	}

	public CV() {
		super();
	}

	@Override
	public String toString() {
		return "CV [cvId=" + cvId + ", name=" + name + ", content=" + Arrays.toString(content) + "]";
	}

}
