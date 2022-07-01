package fa.mockproject.controller;

import fa.mockproject.entity.Role;
import fa.mockproject.entity.enumtype.PrivilegesEnum;
import fa.mockproject.model.RoleModel;
import fa.mockproject.service.RoleService;
import fa.mockproject.util.CommonConstant;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RoleController {

  @Autowired
  private RoleService roleService;


  @RequestMapping(value = "/addRole", method = RequestMethod.POST)
  public String addRole(@ModelAttribute("roleModel") RoleModel roleModel) {
    roleService.addRole(new Role(roleModel));

    return "redirect:/addRole";
  }

  @RequestMapping(value = "/addRole", method = RequestMethod.GET)
  public String addRolePage(Model model) {
    List<PrivilegesEnum> privileges = Arrays.asList(PrivilegesEnum.values());
    privileges.remove(PrivilegesEnum.ROLE_SYSTEM_ADMIN);
    model.addAttribute("privileges", privileges);
    model.addAttribute("roleModel", new RoleModel());
    return "addRole";
  }

  @RequestMapping(path = {"/listRole"}, method = RequestMethod.GET)
  public String listUsers(Model model,
      @RequestParam(defaultValue = CommonConstant.PAGE_DEFAULT) int page,
      @RequestParam(defaultValue = CommonConstant.SIZE_DEFAULT) int size) {
    PageRequest pageable = PageRequest.of((page - 1), size);
    Page<Role> roles = roleService.getList(pageable);
    model.addAttribute("roles", roles.toList());
    model.addAttribute("totalPage", roles.getTotalPages());
    model.addAttribute("totalElement", roles.getTotalElements());
    model.addAttribute("size", size);
    model.addAttribute("page", page);
    return "listRole";
  }

  @RequestMapping(value = "/editRole", method = RequestMethod.GET)
  public String editRolePage(Model model, long roleId) {
    Role role = roleService.findByRoleId(roleId);
    List<PrivilegesEnum> privileges = Arrays.asList(PrivilegesEnum.values());
    privileges.remove(PrivilegesEnum.ROLE_SYSTEM_ADMIN);
    model.addAttribute("privileges", privileges);
    model.addAttribute("role", role);
    return "editRole";
  }
}

