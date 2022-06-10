package fa.mockproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Location;
import fa.mockproject.repository.LocationRepository;

@Service
public class LocationService {
	@Autowired
	private LocationRepository repo;

	public List<Location> ListAll(){
		return (List<Location>)repo.findAll();
	}
	
	
}
