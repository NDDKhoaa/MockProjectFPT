package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.Guarantee;

@Repository
public interface GuaranteeRepository extends JpaRepository<Guarantee, Long> {
	
	
}
