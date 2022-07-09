package fa.mockproject.config;

import fa.mockproject.entity.Role;
import fa.mockproject.entity.User;
import fa.mockproject.entity.enumtype.PrivilegesEnum;
import fa.mockproject.repository.RoleRepository;
import fa.mockproject.repository.UserRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SpringBootInitialData implements ApplicationRunner {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RoleRepository roleRepository;
  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    List<Role> roles = roleRepository.findAll();
    if (roles.isEmpty()) {
      Set<PrivilegesEnum> privilegesEnumSet = new HashSet<>();
      privilegesEnumSet.add(PrivilegesEnum.ROLE_SYSTEM_ADMIN);
      Role role = new Role("System admin", privilegesEnumSet);
      roleRepository.save(role);
      roles = roleRepository.findAll();
      String pwdEncrypt = bCryptPasswordEncoder.encode("123456");
      User user = new User("System Admin", "systemadmin@mail.com", pwdEncrypt,new HashSet<>(roles));
      userRepository.save(user);
    }
  }
}
