package fa.mockproject.service;

import java.util.List;

import fa.mockproject.entity.Milestone;
import fa.mockproject.model.AttendanceStatusModel;

public interface AttendaceStatusService {
	public List<AttendanceStatusModel> getAttendaceStatusModels(List<Milestone> milestones);
}
