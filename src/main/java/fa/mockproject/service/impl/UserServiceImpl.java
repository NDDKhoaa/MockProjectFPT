package fa.mockproject.service.impl;

import fa.mockproject.entity.User;
import fa.mockproject.repository.UserRepository;
import fa.mockproject.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepository userRepository;
  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  public User addUser(User user) {
    String pwdEncrypt = bCryptPasswordEncoder.encode(user.getPassword());
    user.setPassword(pwdEncrypt);
    return userRepository.save(user);
  }

  @Override
  public User findByUserId(long userId) {
    Optional<User> user = userRepository.findById(userId);
    return user.orElse(null);
  }

  @Override
  public boolean findUserByEmail(String email) {
    User user = userRepository.findByEmail(email);
    return user != null;
  }

  @Override
  public String update(User user) {
    Optional<User> userUpdate = userRepository.findById(user.getUserId());

    if (userUpdate.isEmpty()) {
      return "User not exited.";
    }
    user.setPassword(userUpdate.get().getPassword());
    if (user.getEmail().equals(userUpdate.get().getEmail())) {
      userRepository.save(user);
      return "OK";
    }
    User checkUser = userRepository.findByEmail(user.getEmail());
    if (checkUser != null) {
      return "Email existed.";
    }
    userRepository.save(user);
    return "OK";
  }

  @Override
  public Page<User> users(Pageable pageable) {
    return userRepository.findAll(pageable);
  }
}
