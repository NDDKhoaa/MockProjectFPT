package fa.mockproject.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import fa.mockproject.entity.ClassBatch;
import fa.mockproject.entity.enumtype.ClassBatchStatusEnum;
import fa.mockproject.model.ClassBatchModel;
import fa.mockproject.repository.ClassBatchRepository;
import fa.mockproject.service.ClassBatchService;
import fa.mockproject.util.ClassManagementConstant;

public class ClassBatchServiceImpl implements ClassBatchService {
	
	@Autowired
	ClassBatchRepository classBatchRepository;

	@Override
	public List<ClassBatchModel> getClassListGeneral(Map<String, String> filters) {
		
		String locationName = filters.get("loactionName");
		String className = filters.get("className");
		String statusStr = filters.get("status");
		String fromDateStr = filters.get("loactionName");
		String toDateStr = filters.get("loactionName");
		String pageSizeStr = filters.get("loactionName");
		String pageNumberStr = filters.get("loactionName");
		
		ClassBatchStatusEnum status = null;
		LocalDate fromDate = null;
		LocalDate toDate = null;
		int pageSize = ClassManagementConstant.classListPageSize.get(0);
		int pageNumber = 1;
		
		try {
			if (statusStr != null && !statusStr.equals("")) {
				status = ClassBatchStatusEnum.valueOf(statusStr);			
			}
			if (fromDateStr != null && !fromDateStr.equals("")) {
				fromDate = LocalDate.parse(fromDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));			
			}
			if (toDateStr != null && !toDateStr.equals("")) {
				toDate = LocalDate.parse(toDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));			
			}
			if (pageSizeStr != null && !pageSizeStr.equals("")) {
				pageSize = Integer.parseInt(pageSizeStr);			
			}
			if (pageNumberStr != null && !pageNumberStr.equals("")) {
				pageNumber = Integer.parseInt(pageNumberStr);			
			} 			
		} catch (DateTimeParseException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		//...
		
		return null;
	}

	@Override
	public ClassBatchModel getClass(Long classBatchId) {
		
		ClassBatchModel classBatchModel = null;
		ClassBatch classBatch = null;
		
		try {
			
			classBatch = classBatchRepository.getOne(classBatchId);
			classBatchModel = new ClassBatchModel(classBatch);
			
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}
		
		return classBatchModel;
	}

	@Override
	public ClassBatchModel addClass(ClassBatchModel classBatchModel) {
		
		classBatchModel.setStatus(ClassBatchStatusEnum.Draft);
		ClassBatch classBatch = new ClassBatch(classBatchModel);
		
		try {
			classBatchRepository.save(classBatch);			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}
		
		return classBatchModel;
	}

	@Override
	public ClassBatchModel updateDraftClass(ClassBatchModel classBatchModel) {
		ClassBatch classBatch = new ClassBatch(classBatchModel);
		
		try {
			classBatchRepository.save(classBatch);			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}
		
		return classBatchModel;
	}
	
	@Override
	public ClassBatchModel updateInprogressClass(ClassBatchModel classBatchModel) {
		return classBatchModel;
		//...
	}

	@Override
	public boolean SubmitClass(Long classBatchId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean StartClass(Long classBatchId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean FinishClass(Long classBatchId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean CancelClass(Long classBatchId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ApproveClass(Long classBatchId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean RejectClass(Long classBatchId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean CloseClass(Long classBatchId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean AcceptClass(Long classBatchId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean DeclineClass(Long classBatchId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addTrainee(Long classBatchId, List<Long> traineeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeTrainee(Long classBatchId, List<Long> traineeId) {
		// TODO Auto-generated method stub
		return false;
	}

}
