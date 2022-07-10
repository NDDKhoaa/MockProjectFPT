package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.AttendantDayCheck;

@Repository
public interface AttendantDayCheckRepository extends JpaRepository<AttendantDayCheck, Long> {
	

}
