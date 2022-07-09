package fa.mockproject.service;

import java.util.List;

import fa.mockproject.entity.Audit;
import fa.mockproject.entity.ClassBatch;

public interface AuditService {

	List<Audit> updateAllAuditOfOneClass(ClassBatch classBatch);
}
