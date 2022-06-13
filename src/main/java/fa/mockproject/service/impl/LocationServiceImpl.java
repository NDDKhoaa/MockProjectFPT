package fa.mockproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Location;
import fa.mockproject.repository.LocationRepository;
import fa.mockproject.service.LocationService;


@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationRepository repo;

	public List<Location> listAll() {
		return (List<Location>) repo.findAll();
	}

	public void save(Location location) {
		repo.save(location);
	}

	public Location findById(String locationId) {
		Optional<Location> location = repo.findById(locationId);
		return location.get();
	}

	public void delete(Location location) {
		repo.delete(location);
	}

	public void deleteById(String locationId) {
		repo.deleteById(locationId);
	}
}
