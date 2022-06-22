package fa.mockproject.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import fa.mockproject.model.TraineeModel;
import fa.mockproject.model.TraineePage;



public interface TraineeService {
	


	public TraineeModel getTraineeModel(long id);

	public TraineePage getTraineeModels(Pageable pageable);


// 	public void update(TraineeModel traineeModelForm);
		
		

}
