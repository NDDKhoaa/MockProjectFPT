package fa.mockproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Channel;
import fa.mockproject.repository.ChannelRepository;

@Service
public class ChannelService {
	@Autowired
	private ChannelRepository repo;

	public List<Channel> ListAll(){
		return (List<Channel>)repo.findAll();
	}
	
}
