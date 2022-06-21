package fa.mockproject.model;

import java.util.List;

import org.springframework.data.domain.Page;

import fa.mockproject.entity.Trainee;


public class TraineePage {
	Page<Trainee> page;
	List<TraineeModel> traineeModels;
	public TraineePage() {
		super();
	}
	public Page<Trainee> getPage() {
		return page;
	}
	public void setPage(Page<Trainee> page) {
		this.page = page;
	}
	public List<TraineeModel> getTraineeModels() {
		return traineeModels;
	}
	public void setTraineeModels(List<TraineeModel> traineeModels) {
		this.traineeModels = traineeModels;
	}

}
