package fa.mockproject.service;

import fa.mockproject.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    User addUser(User employee);
    User findUserByUserId(long userId);
    User findByUserId(User userId);
    User update(User user);
    List <User> users(Pageable pageable);
}
