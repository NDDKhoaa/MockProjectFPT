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

import fa.mockproject.model.TraineeCandidateProfileModel;

@Entity
@Table(name = "CV")
@Cacheable
public class CV {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_id", nullable = true, unique = true)
	private long cvId;

	@Column(name = "name", length = 512, nullable = true, unique = true)
	private String name;

	@Column(name = "size", nullable = true)
	private long size;

	@Lob
	@Column(name = "content", nullable = true)
	private byte[] content;

	@OneToOne
	@JoinColumn(name = "trainee_candidate_profile_id", nullable = true)
	private TraineeCandidateProfile traineeCandidateProfile;

	public long getCvId() {
		return cvId;
	}

	public CV() {
		super();
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

	public TraineeCandidateProfile getTraineeCandidateProfile() {
		return traineeCandidateProfile;
	}

	public void setTraineeCandidateProfile(TraineeCandidateProfile traineeCandidateProfile) {
		this.traineeCandidateProfile = traineeCandidateProfile;
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

	public CV(TraineeCandidateProfileModel model, TraineeCandidateProfile profile) {
		super();
		this.cvId = model.getCvId();
		this.name = model.getCVname();
		this.size = model.getSize();
		this.content = model.getContent();
		this.traineeCandidateProfile = profile;
	}

	public CV(TraineeCandidateProfileModel model) {
		super();
		this.cvId = model.getCvId();
		this.name = model.getCVname();
		this.size = model.getSize();
		this.content = model.getContent();
	}

	public CV(CV cv) {
		this.cvId = cv.getCvId();
		this.name = cv.getName();
		this.size = cv.getSize();
		this.content = cv.getContent();
	}

	public CV(String fileName, long fileSize, byte[] content2) {
		this.name = fileName;
		this.size = fileSize;
		this.content = content2;
	}

	@Override
	public String toString() {
		return "CV [cvId=" + cvId + ", name=" + name + ", size=" + size + "]";
	}

}
