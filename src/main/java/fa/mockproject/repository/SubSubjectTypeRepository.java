package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.SubSubjectType;

@Repository
public interface SubSubjectTypeRepository extends JpaRepository<SubSubjectType, Long> {

}
