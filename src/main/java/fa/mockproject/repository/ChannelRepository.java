package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.mockproject.entity.Channel;

public interface ChannelRepository extends JpaRepository<Channel, String>{

}
