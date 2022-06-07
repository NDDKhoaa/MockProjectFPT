package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.mockproject.entity.University;

public interface UniversityRepository extends JpaRepository<University, String>{

}
