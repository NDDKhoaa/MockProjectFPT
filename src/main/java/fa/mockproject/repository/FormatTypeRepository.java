package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.FormatType;

@Repository
public interface FormatTypeRepository extends JpaRepository<FormatType, Long> {

}
