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
@Table(name = "ProfileType")
@Cacheable
public class TraineeCandidateProfileType {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "profile_status_id", length = 20, unique = true, nullable = false)
	private String profileStatusId;

	@Column(name = "type", length = 20, unique = true, nullable = false)
	private String type;

	@OneToMany(mappedBy = "type")
	private List<TraineeCandidateProfile> traineeCandidateProfiles;

	public String getProfileStatusId() {
		return profileStatusId;
	}

	public void setProfileStatusId(String profileStatusId) {
		this.profileStatusId = profileStatusId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<TraineeCandidateProfile> getTraineeCandidateProfiles() {
		return traineeCandidateProfiles;
	}

	public void setTraineeCandidateProfiles(List<TraineeCandidateProfile> traineeCandidateProfiles) {
		this.traineeCandidateProfiles = traineeCandidateProfiles;
	}

	public TraineeCandidateProfileType() {
		super();
	}

	public TraineeCandidateProfileType(TraineeCandidateProfileType find) {
		super();
		this.profileStatusId = find.getProfileStatusId();
		this.type = find.getType();
	}

	@Override
	public String toString() {
		return type;
	}

}
