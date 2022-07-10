package fa.mockproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.Budget;
import fa.mockproject.entity.ClassBatch;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
	List<Budget> findBudgetByClassBatch(ClassBatch classBatch);
}
