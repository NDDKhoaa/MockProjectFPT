package fa.mockproject.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import fa.mockproject.entity.ClassBatch;

public interface ClassBatchRepositoryCustom {
	List<ClassBatch> getClasses(Map<String, Object> params, Pageable pageable);
}
