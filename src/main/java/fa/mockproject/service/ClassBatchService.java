package fa.mockproject.service;

import java.util.List;
import java.util.Map;

import fa.mockproject.entity.ClassData;
import fa.mockproject.entity.Location;
import fa.mockproject.entity.enumtype.ClassBatchStatusEnum;
import fa.mockproject.model.ClassBatchModel;

public interface ClassBatchService {
	
	public abstract List<ClassBatchModel> getClassListGeneral(Map<String, String> filters);
	public abstract ClassBatchModel getClass(Long classBatchId);
	public abstract ClassBatchModel addClass(ClassBatchModel classBatchModel);
	public abstract ClassBatchModel updateDraftClass(ClassBatchModel classBatchModel);
	public abstract ClassBatchModel updateInprogressClass(ClassBatchModel classBatchModel);
	public abstract boolean SubmitClass(Long classBatchId);
	public abstract boolean StartClass(Long classBatchId);
	public abstract boolean FinishClass(Long classBatchId);
	public abstract boolean CancelClass(Long classBatchId);
	public abstract boolean ApproveClass(Long classBatchId);
	public abstract boolean RejectClass(Long classBatchId);
	public abstract boolean CloseClass(Long classBatchId);
	public abstract boolean AcceptClass(Long classBatchId);
	public abstract boolean DeclineClass(Long classBatchId);
	
	public abstract boolean addTrainee(Long classBatchId, List<Long> traineeId);
	public abstract boolean removeTrainee(Long classBatchId, List<Long> traineeId);
	List<ClassData> getListTrainee(Location location, ClassBatchStatusEnum status);
}
