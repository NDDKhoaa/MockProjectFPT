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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_id", nullable = false, unique = true)
	private long cvId;

	@Column(name = "name", length = 512, nullable = false, unique = true)
	private String name;

	@Column(name = "size", nullable = true)
	private long size;

	@Column(name = "content", nullable = true)
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

	public CV(String name, long size, byte[] content) {
		super();
		this.name = name;
		this.size = size;
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

	@Override
	public String toString() {
		return "CV [cvId=" + cvId + ", name=" + name + ", size=" + size + ", content=" + Arrays.toString(content) + "]";
	}

}
