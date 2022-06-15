package fa.mockproject.entity;

import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fa.mockproject.model.LocationModel;

@Entity
@Table(name = "Location")
@Cacheable
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "location_id", length = 20, unique = true, nullable = false)
	private String locationId;

	@Column(name = "location_name", length = 255, nullable = false)
	private String locationName;

	@Column(name = "remarks", length = 255, nullable = true)
	private String remarks;

	@OneToMany(mappedBy = "location")
	private Set<ClassBatch> classBatch;

	@OneToMany(mappedBy = "location")
	private Set<TraineeCandidateProfile> traineeCandidateProfile;

	public Location() {
		super();
	}

	public Location(String locationName, String remarks) {
		super();
		this.locationName = locationName;
		this.remarks = remarks;
	}

	public Location(Location location) {
		super();
		this.locationId = location.getLocationId();
		this.locationName = location.getLocationName();
		this.remarks = location.getRemarks();
	}

	public Location(LocationModel locationModel) {
		super();
		this.locationId = locationModel.getLocationId();
		this.locationName = locationModel.getLocationName();
		this.remarks = locationModel.getRemarks();

	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Set<ClassBatch> getClassBatch() {
		return classBatch;
	}

	public void setClassBatch(Set<ClassBatch> classBatch) {
		this.classBatch = classBatch;
	}

	public Set<TraineeCandidateProfile> getTraineeCandidateProfile() {
		return traineeCandidateProfile;
	}

	public void setTraineeCandidateProfile(Set<TraineeCandidateProfile> traineeCandidateProfile) {
		this.traineeCandidateProfile = traineeCandidateProfile;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", locationName=" + locationName + ", remarks=" + remarks + "]";
	}

}