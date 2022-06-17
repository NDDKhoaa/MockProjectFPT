package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.AttendantStatus;

@Repository
public interface AttendantStatusRepository extends JpaRepository<AttendantStatus, Long> {
	
	
}
