package fa.mockproject.service;

import java.util.List;

import fa.mockproject.entity.Budget;
import fa.mockproject.entity.ClassAdmin;
import fa.mockproject.entity.ClassBatch;
import fa.mockproject.model.ClassAdminModel;

public interface ClassAdminService {
	List<ClassAdminModel> getAllProfile();
	List<ClassAdmin> updateAllClassAdminOfOneClass(ClassBatch classBatch);
}
