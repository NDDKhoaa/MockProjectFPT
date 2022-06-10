package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.mockproject.entity.Guarantee;

public interface GuaranteeRepository extends JpaRepository<Guarantee, Long> {
	
	
}
