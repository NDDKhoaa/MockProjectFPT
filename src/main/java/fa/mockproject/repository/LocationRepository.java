package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.mockproject.entity.Location;

public interface LocationRepository extends JpaRepository<Location, String>{

}
