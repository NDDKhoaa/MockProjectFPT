package fa.mockproject.util;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

import fa.mockproject.entity.enumtype.ClassBatchStatusEnum;
import fa.mockproject.entity.enumtype.ClassManagementActionEnum;
import fa.mockproject.entity.enumtype.WeightedNumberEnum;

public final class ClassManagementConstant {
	
	public static final List<Integer> CLASS_LIST_PAGE_SIZE = List.of(10, 20, 30, 50, 100);
	public static final String HISTORY_DATE_FORMAT = "dd-MMM-yyyy";
	public static final Map<ClassManagementActionEnum, List<ClassBatchStatusEnum>> CLASS_PRE_CONDITION = Map.ofEntries(
			new AbstractMap.SimpleEntry<ClassManagementActionEnum, List<ClassBatchStatusEnum>>(
					ClassManagementActionEnum.Update, 
					List.of(ClassBatchStatusEnum.Draft, ClassBatchStatusEnum.InProgress, ClassBatchStatusEnum.Rejected, ClassBatchStatusEnum.Declined)),
			new AbstractMap.SimpleEntry<ClassManagementActionEnum, List<ClassBatchStatusEnum>>(
					ClassManagementActionEnum.Submit, 
					List.of(ClassBatchStatusEnum.Draft, ClassBatchStatusEnum.Rejected, ClassBatchStatusEnum.Declined)),
			new AbstractMap.SimpleEntry<ClassManagementActionEnum, List<ClassBatchStatusEnum>>(
					ClassManagementActionEnum.Cancel, 
					List.of(ClassBatchStatusEnum.Draft, ClassBatchStatusEnum.Submitted)),
			new AbstractMap.SimpleEntry<ClassManagementActionEnum, List<ClassBatchStatusEnum>>(
					ClassManagementActionEnum.Reject, 
					List.of(ClassBatchStatusEnum.Submitted)),
			new AbstractMap.SimpleEntry<ClassManagementActionEnum, List<ClassBatchStatusEnum>>(
					ClassManagementActionEnum.Approve, 
					List.of(ClassBatchStatusEnum.Submitted)),
			new AbstractMap.SimpleEntry<ClassManagementActionEnum, List<ClassBatchStatusEnum>>(
					ClassManagementActionEnum.Decline, 
					List.of(ClassBatchStatusEnum.Planning)),
			new AbstractMap.SimpleEntry<ClassManagementActionEnum, List<ClassBatchStatusEnum>>(
					ClassManagementActionEnum.Accept, 
					List.of(ClassBatchStatusEnum.Planning)),
			new AbstractMap.SimpleEntry<ClassManagementActionEnum, List<ClassBatchStatusEnum>>(
					ClassManagementActionEnum.Start, 
					List.of(ClassBatchStatusEnum.Planned)),
			new AbstractMap.SimpleEntry<ClassManagementActionEnum, List<ClassBatchStatusEnum>>(
					ClassManagementActionEnum.Finish, 
					List.of(ClassBatchStatusEnum.InProgress, ClassBatchStatusEnum.WaitingForMoreInformation)),
			new AbstractMap.SimpleEntry<ClassManagementActionEnum, List<ClassBatchStatusEnum>>(
					ClassManagementActionEnum.Close, 
					List.of(ClassBatchStatusEnum.PendingForReview)),
			new AbstractMap.SimpleEntry<ClassManagementActionEnum, List<ClassBatchStatusEnum>>(
					ClassManagementActionEnum.Request, 
					List.of(ClassBatchStatusEnum.Closed))
	);
	public static final List<WeightedNumberEnum> WEIGHTED_NUMBER_FORMAT  = List.of(
			WeightedNumberEnum.AcademicMark, 
			WeightedNumberEnum.DisciplinaryPoint, 
			WeightedNumberEnum.BonusPoint, 
			WeightedNumberEnum.Penaltypoint);
	public static final String WEIGHTED_NUMBER_DELIMITER = "-";
}
