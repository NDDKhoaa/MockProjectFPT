package fa.mockproject.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.util.Pair;

import fa.mockproject.entity.ClassBatch;
import fa.mockproject.entity.enumtype.ClassBatchStatusEnum;
import fa.mockproject.entity.enumtype.ClassManagementActionEnum;
import fa.mockproject.entity.enumtype.WeightedNumberEnum;
import fa.mockproject.model.ClassBatchModel;

public interface ClassBatchService {
	
	public abstract Pair<List<ClassBatchModel>, Page<ClassBatch>> getClassList(Map<String, String> filters);
	public abstract List<String> getAllClassNames();
	public abstract ClassBatchModel getClazz(String classId);
	ClassBatchStatusEnum getClassStatus(String classId);
	public abstract ClassBatchModel createClass(ClassBatchModel classBatchModel);
	public abstract boolean updateClass(ClassBatchModel classBatchModel);
	public abstract boolean updateDraftClass(ClassBatchModel classBatchModel);
	public abstract boolean updateInprogressClass(ClassBatchModel classBatchModel);
	boolean changeClassState(String classId, ClassManagementActionEnum action);
	boolean changeClassState(String classId, ClassManagementActionEnum action, String remark);
	
	public abstract boolean addTrainee(Long classId, List<Long> traineeId);
	public abstract boolean removeTrainee(Long classId, List<Long> traineeId);
	
	public Map<WeightedNumberEnum, Integer> convertWeightedNumber(String weightedNumber);
}
