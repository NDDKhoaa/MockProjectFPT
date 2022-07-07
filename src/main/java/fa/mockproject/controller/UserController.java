package fa.mockproject.controller;

import fa.mockproject.entity.User;
import fa.mockproject.model.UserModel;
import fa.mockproject.service.RoleService;
import fa.mockproject.service.SecurityService;
import fa.mockproject.service.UserService;
import fa.mockproject.util.CommonConstant;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

  @Autowired
  private UserService userService;
  @Autowired
  private RoleService roleService;
  @Autowired
  private SecurityService securityService;

  @GetMapping("/addUser")
  public String addUserPage(ModelMap model) {
    model.addAttribute("listRole", roleService.getList());
    model.addAttribute("userModel", new UserModel());
    return "users/addUser";
  }

  @RequestMapping(value = "/addUser", method = RequestMethod.POST)
  public ResponseEntity addUser(@RequestBody UserModel userModel) {
    boolean checkUser = userService.findUserByEmail(userModel.getEmail());
    if (checkUser) {
      return ResponseEntity.badRequest().body("Email existed.");
    }
    userService.addUser(new User(userModel));
    return ResponseEntity.ok().body("OK");
  }

  @GetMapping("/login")
  public String login(Model model, String error, String logout) {
    if (error != null) {
      model.addAttribute("error",
              "Sorry, your username or password is incorrect. Please try again!");
    }
    if (logout != null) {
      model.addAttribute("message", "You have been logged out successfully.");
    }
    return "login";
  }

  @RequestMapping(path = {"/listUser"}, method = RequestMethod.GET)
  public String listUsers(Model model,
                          @RequestParam(defaultValue = CommonConstant.PAGE_DEFAULT) int page,
                          @RequestParam(defaultValue = CommonConstant.SIZE_DEFAULT) int size) {
    PageRequest pageable = PageRequest.of((page - 1), size);
    Page<User> users = userService.users(pageable);
    model.addAttribute("users", users.toList());
    model.addAttribute("totalPage", users.getTotalPages());
    model.addAttribute("totalElement", users.getTotalElements());
    model.addAttribute("size", size);
    model.addAttribute("page", page);
    return "users/listUser";
  }

  @GetMapping(path = {"/viewUser"})
  public String viewUser(Model model, long userId, ModelMap modelMap) {
    User user = userService.findByUserId(userId);
    model.addAttribute("user", user);
    return "users/viewUser";
  }

  @GetMapping(path = {"/editUser"})
  public String editUserPage(Model model, long userId, ModelMap modelMap) {
    Set<Long> longList = new HashSet<>();
    User user = userService.findByUserId(userId);
    user.getRoles().forEach(role -> longList.add(role.getRoleId()));
    modelMap.addAttribute("userModel", new UserModel());
    model.addAttribute("user", user);
    model.addAttribute("roleOfUser", longList);
    model.addAttribute("listRole", roleService.getList());
    return "users/editUser";
  }

  @PostMapping("/editUser")
  public ResponseEntity editUser(@RequestBody UserModel userModel) {
    String response = userService.update(new User(userModel));
    return ResponseEntity.ok().body(response);
  }
}
