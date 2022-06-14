package fa.mockproject.service;

import java.util.List;

import fa.mockproject.entity.Location;

public interface LocationService {
	
	public List<Location> listAll();

	public void save(Location location);

	public Location findById(String locationId);

	public void delete(Location location);

	public void deleteById(String locationId);

}