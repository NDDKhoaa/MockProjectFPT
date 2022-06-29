package fa.mockproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.Channel;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, String> {
	@Query(value = "SELECT c from Channel c where c.channelId LIKE '%' || :word || '%' "
			+ "OR c.channelName LIKE '%' || :word || '%' " + "OR c.remarks LIKE '%' || :word || '%' ")
	public List<Channel> search(@Param("word") String word);
}
