package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.SubjectType;

@Repository
public interface SubjectTypeRepository extends JpaRepository<SubjectType, Long> {

}
