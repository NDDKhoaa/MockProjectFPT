package fa.mockproject.service;

import java.util.List;

import fa.mockproject.entity.Budget;
import fa.mockproject.entity.ClassBatch;

public interface BudgetService {
	
	List<Budget> updateAllBudgetOfOneClass(ClassBatch classBatch);
}
