package fa.mockproject.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import fa.mockproject.entity.Channel;

public interface ChannelService {

	public List<Channel> listAll();

	public void save(Channel channel);

	public Channel get(String channelId);

	public void delete(Channel channel);

	public void deleteById(String channelId);

	public List<Channel> search(@Param("word") String word);
}
