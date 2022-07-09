package fa.mockproject.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.ClassAdmin;
import fa.mockproject.entity.ClassBatch;
import fa.mockproject.model.ClassAdminModel;
import fa.mockproject.repository.ClassAdminProfileRepository;
import fa.mockproject.repository.ClassAdminRepository;
import fa.mockproject.service.ClassAdminService;

@Service
public class ClassAdminServiceImpl implements ClassAdminService {

	@Autowired
	ClassAdminRepository classAdminRepository;
	
	@Autowired
	ClassAdminProfileRepository classAdminProfileRepository;
	
	@Override
	public List<ClassAdminModel> getAllProfile() {
		List<ClassAdminModel> classAdminModels = classAdminProfileRepository.findAll().stream().map(
				classAdminProfile -> new ClassAdminModel(classAdminProfile)).collect(Collectors.toCollection(ArrayList::new));
		return classAdminModels;
	}

	@Override
	public List<ClassAdmin> updateAllClassAdminOfOneClass(ClassBatch classBatch) {
		List<ClassAdmin> latestClassAdmins = classAdminRepository.saveAll(classBatch.getClassAdmins());
		List<ClassAdmin> removedClassAdmins = classAdminRepository.findClassAdminByClassBatch(classBatch);
		try {
			removedClassAdmins.removeAll(latestClassAdmins);			
			classAdminRepository.deleteAll(removedClassAdmins);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		return latestClassAdmins;
	}

}
