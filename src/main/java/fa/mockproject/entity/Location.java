package fa.mockproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "Location")
@Cacheable
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "location_id", length = 20, unique = true, nullable = false)
	private String locationId;

	@Column(name = "location_name", nullable = false)
	private String locationName;

	@Column(name = "remarks", length = 250, nullable = true)
	private String remarks;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "class_id", nullable = false)
	private ClassBatch classBatch;

	public Location() {
		super();
	}

	public Location(String locationName, String remarks) {
		super();
		this.locationName = locationName;
		this.remarks = remarks;
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

	public ClassBatch getClassBatch() {
		return classBatch;
	}

	public void setClassBatch(ClassBatch classBatch) {
		this.classBatch = classBatch;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", locationName=" + locationName + ", remarks=" + remarks + "]";
	}

}