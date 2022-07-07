package fa.mockproject.service;

<<<<<<< HEAD
import fa.mockproject.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

=======
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.User;

@Service
>>>>>>> origin/haidang
public interface UserService {
    User addUser(User user);
    User findByUserId(long userId);
    boolean findUserByEmail(String email);
<<<<<<< HEAD
    String update(User user);
=======
    User update(User user);
>>>>>>> origin/haidang
    Page<User> users(Pageable pageable);
}
