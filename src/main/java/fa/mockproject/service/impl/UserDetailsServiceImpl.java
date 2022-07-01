package fa.mockproject.service.impl;

import fa.mockproject.entity.Role;
import fa.mockproject.entity.User;
import fa.mockproject.repository.RoleRepository;
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

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
       // Optional<Role> role = roleRepository.findById(user.getRoles().);
       // role.ifPresent(user::setRoles);
        return new CustomUserDetails(user);
    }
}
