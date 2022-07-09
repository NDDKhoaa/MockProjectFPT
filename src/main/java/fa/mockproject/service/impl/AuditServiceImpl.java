package fa.mockproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Audit;
import fa.mockproject.entity.ClassBatch;
import fa.mockproject.repository.AuditRepository;
import fa.mockproject.service.AuditService;

@Service
public class AuditServiceImpl implements AuditService {
	
	@Autowired
	AuditRepository auditRepository;

	@Override
	public List<Audit> updateAllAuditOfOneClass(ClassBatch classBatch) {
		List<Audit> latestAudits = auditRepository.saveAll(classBatch.getAudits());
		List<Audit> removedAudits = auditRepository.findAuditByClassBatch(classBatch);
		try {
			removedAudits.removeAll(latestAudits);	
			auditRepository.deleteAll(removedAudits);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}  catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		return latestAudits;
	}

}
