package fa.mockproject.service.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

}
