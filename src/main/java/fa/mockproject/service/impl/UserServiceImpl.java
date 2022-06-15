package fa.mockproject.service.impl;

import fa.mockproject.entity.User;
import fa.mockproject.repository.UserRepository;
import fa.mockproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

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
}
