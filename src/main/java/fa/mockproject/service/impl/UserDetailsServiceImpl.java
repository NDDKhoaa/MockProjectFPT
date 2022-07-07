package fa.mockproject.service.impl;

import fa.mockproject.entity.Role;
import fa.mockproject.entity.User;
<<<<<<< HEAD
import fa.mockproject.repository.RoleRepository;
=======
>>>>>>> origin/haidang
import fa.mockproject.repository.UserRepository;
import fa.mockproject.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
<<<<<<< HEAD
        return new CustomUserDetails(user);
=======
        return new CustomUserDetails();
>>>>>>> origin/haidang
    }
}
