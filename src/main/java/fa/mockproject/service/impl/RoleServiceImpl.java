package fa.mockproject.service.impl;

import fa.mockproject.entity.Role;
import fa.mockproject.repository.RoleRepository;
import fa.mockproject.service.RoleService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  RoleRepository roleRepository;

  @Override
  public Role addRole(Role role) {
    return roleRepository.save(role);
  }

  @Override
  public Role findByRoleId(long roleId) {
    Optional<Role> role = roleRepository.findById(roleId);
    if (role.isEmpty()) {
      return null;
    }
    return role.get();
  }

  @Override
  public Page<Role> getList(Pageable pageable) {
    return roleRepository.findAll(pageable);
  }

  @Override
  public List<Role> getList() {
    return roleRepository.findAll();
  }

  @Override
  public Role update(Role role) {
    Optional<Role> roleUpdate = roleRepository.findById(role.getRoleId());
    if (roleUpdate.isEmpty()) {
      return null;
    }
    roleRepository.save(role);
    return role;
  }
}
