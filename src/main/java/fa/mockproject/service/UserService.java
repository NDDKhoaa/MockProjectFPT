package fa.mockproject.service;

import fa.mockproject.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User findByUserId(long userId);
    boolean findUserByEmail(String email);
    User update(User user);
    Page<User> users(Pageable pageable);
}
