package fa.mockproject.service.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fa.mockproject.entity.AttendantStatus;

public interface AttendantStatusRepository extends JpaRepository<AttendantStatus, Long> {
	
	
}
