package fa.mockproject.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fa.mockproject.entity.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {
	
	@Modifying
	@Transactional
	@Query("Update Topic t set t.traineeScore = :traineeScore Where t.topicId = :topicId")
	void updateTraineeScoreByTopicId(@Param("topicId") long topicId, @Param("traineeScore") int traineeScore);
	
	
	@Modifying
	@Transactional
	@Query("Delete Topic t Where t.topicId = :topicId")
	void deleteById(@Param("topicId") long topicId);
	
}
