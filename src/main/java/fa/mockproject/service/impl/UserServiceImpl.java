package fa.mockproject.service.impl;

import fa.mockproject.entity.User;
import fa.mockproject.repository.UserRepository;
import fa.mockproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
}
