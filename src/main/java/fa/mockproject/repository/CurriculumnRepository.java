package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.Curriculumn;

@Repository
public interface CurriculumnRepository extends JpaRepository<Curriculumn, Long> {

}
