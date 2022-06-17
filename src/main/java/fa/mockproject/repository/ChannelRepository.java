package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.Channel;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, String>{

}
