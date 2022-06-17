package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, String>{

}
