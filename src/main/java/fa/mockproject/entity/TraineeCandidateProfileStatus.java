package fa.mockproject.entity;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ProfileStatus")
@Cacheable
public class TraineeCandidateProfileStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "profile_status_id", length = 20, unique = true, nullable = false)
	private String profileStatusId;

	@Column(name = "status", length = 20, unique = true, nullable = false)
	private String status;
	
	@OneToMany(mappedBy = "status")
	private List<Candidate> candidate;
	
	public List<Candidate> getCandidate() {
		return candidate;
	}

	public void setCandidate(List<Candidate> candidate) {
		this.candidate = candidate;
	}

	public String getProfileStatusId() {
		return profileStatusId;
	}

	public void setProfileStatusId(String profileStatusId) {
		this.profileStatusId = profileStatusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TraineeCandidateProfileStatus() {
		super();
	}

	public TraineeCandidateProfileStatus(TraineeCandidateProfileStatus find) {
		this.profileStatusId = find.getProfileStatusId();
		this.status = find.getStatus();
	}

	public TraineeCandidateProfileStatus(String profileStatusId) {
		this.profileStatusId = profileStatusId;
	}

	@Override
	public String toString() {
		return status;
	}

}
