package fa.mockproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Channel;
import fa.mockproject.repository.ChannelRepository;
import fa.mockproject.service.ChannelService;

@Service
public class ChannelServiceImpl implements ChannelService {

	@Autowired
	private ChannelRepository repo;

	public List<Channel> listAll() {
		return (List<Channel>) repo.findAll();
	}

	public void save(Channel channel) {
		repo.save(channel);
	}

	public Channel get(String channelId) {
		Optional<Channel> rs = repo.findById(channelId);
		return rs.get();
	}

	public void delete(Channel channel) {
		repo.delete(channel);
	}

	public void deleteById(String channelId) {
		repo.deleteById(channelId);
	}

	public List<Channel> search(@Param("word") String word) {
		return (List<Channel>) repo.search(word);
	}
}
