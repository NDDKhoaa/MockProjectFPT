package fa.mockproject.service;

import fa.mockproject.entity.Role;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoleService {

  Role addRole(Role role);

  Role findByRoleId(long roleId);

  Page<Role> getList(Pageable pageable);

  List<Role> getList();

  Role update(Role role);
}