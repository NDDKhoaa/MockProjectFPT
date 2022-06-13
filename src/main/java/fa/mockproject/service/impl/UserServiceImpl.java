package fa.mockproject.service.impl;

import fa.mockproject.entity.User;
import fa.mockproject.repository.UserRepository;
import fa.mockproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    Validator validator;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User addUser(User user) {
        this.validator.validate(user, null);
        String pwdEncrypt = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(pwdEncrypt);
        return userRepository.save(user);
    }

    @Override
    public User findUserByUserId(long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(null);
    }

    @Override
    public User findByUserId(User userId) {
        return userRepository.findByUser(userId);
    }

    @Override
    public User update(User user) {
        Optional<User> userUpdate = userRepository.findById(user.getUserId());
        if (userUpdate.isEmpty()) {
            return null;
        }
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> users(Pageable pageable) {
        return userRepository.findAll(pageable).toList();
    }
}
