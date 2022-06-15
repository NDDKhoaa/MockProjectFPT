package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.mockproject.entity.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, String>{

}
