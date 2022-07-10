package fa.mockproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Budget;
import fa.mockproject.entity.ClassBatch;
import fa.mockproject.repository.BudgetRepository;
import fa.mockproject.service.BudgetService;

@Service
public class BudgetServiceImpl implements BudgetService {

	@Autowired
	BudgetRepository budgetRepository;

	@Override
	public List<Budget> updateAllBudgetOfOneClass(ClassBatch classBatch) {
		List<Budget> latestBudgets = budgetRepository.saveAll(classBatch.getBudgets());
		List<Budget> removedBudgets = budgetRepository.findBudgetByClassBatch(classBatch);
		try {
			removedBudgets.removeAll(latestBudgets);			
			budgetRepository.deleteAll(removedBudgets);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		return latestBudgets;
	}

}
