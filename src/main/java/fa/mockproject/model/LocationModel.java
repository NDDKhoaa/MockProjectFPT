package fa.mockproject.model;

import fa.mockproject.entity.Location;

public class LocationModel {

	private long locationId;
	private String locationName;
	private String remarks;
	
	public LocationModel() {
		super();
	}

	public LocationModel(long locationId, String locationName, String remarks) {
		super();
		this.locationId = locationId;
		this.locationName = locationName;
		this.remarks = remarks;
	}
	
	public LocationModel(Location location) {
		super();
		this.locationId = location.getLocationId();
		this.locationName = location.getLocationName();
		this.remarks = location.getRemarks();
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
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

	@Override
	public String toString() {
		return "LocationModel [locationId=" + locationId + ", locationName=" + locationName + ", remarks=" + remarks
				+ "]";
	}

}