package fa.mockproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Allocation;
import fa.mockproject.entity.Trainee;
import fa.mockproject.model.AllocationModel;
import fa.mockproject.repository.AllocationRepository;
import fa.mockproject.repository.TraineeRepository;

@Service
public class AllocationServiceImpl {
	
	@Autowired
	TraineeRepository traineeRepository;
	
	@Autowired
	AllocationRepository allocationRepository;
 	
	public AllocationModel getAllocation(long traineeId) {
		Allocation allocation = traineeRepository.findByTraineeCandidateId(traineeId).getAllocation();
		AllocationModel allocationModel = null;
		if(allocation != null) {
			allocationModel = new AllocationModel(allocation);
		} else {
			allocationModel = new AllocationModel();
		}
		
		return allocationModel;
	}

	public String createAllocation(AllocationModel allocationModel, String traineeIdStr) {
		long traineeId = Long.parseLong(traineeIdStr);
		Trainee trainee = traineeRepository.findByTraineeCandidateId(traineeId);
		allocationModel.setTrainee(trainee);
		Allocation allocation = new Allocation(allocationModel);
		allocationRepository.save(allocation);
		return null;
	}


}
