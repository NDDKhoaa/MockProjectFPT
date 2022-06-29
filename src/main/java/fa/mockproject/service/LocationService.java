package fa.mockproject.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import fa.mockproject.entity.Location;

public interface LocationService {
	
	public List<Location> listAll();

	public void save(Location location);

	public Location findById(String locationId);

	public void delete(Location location);

	public void deleteById(String locationId);

	public List<Location> search(@Param("word") String word);
}