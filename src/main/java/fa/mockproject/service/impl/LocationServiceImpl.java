package fa.mockproject.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Location;
import fa.mockproject.model.LocationModel;
import fa.mockproject.repository.LocationRepository;
import fa.mockproject.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository repo;

	@Override
	public List<Location> listAll() {
		return (List<Location>) repo.findAll();
	}

	@Override
	public void save(Location location) {
		repo.save(location);
	}

	@Override
	public Location findById(String locationId) {
		Optional<Location> location = repo.findById(locationId);
		return location.get();
	}

	@Override
	public void delete(Location location) {
		repo.delete(location);
	}

	@Override
	public void deleteById(String locationId) {
		repo.deleteById(locationId);
	}

	@Override
	public List<LocationModel> getAll() {
		List<LocationModel> locationModels = repo.findAll().stream().map(
				location -> new LocationModel(location)).collect(Collectors.toCollection(ArrayList::new));
		return locationModels;
	}

	@Override
	public List<Location> search(@Param("word") String word) {
		return (List<Location>) repo.search(word);

	}
}
