package fa.mockproject.controller;

import fa.mockproject.entity.User;
import fa.mockproject.model.UserModel;
import fa.mockproject.service.SecurityService;
import fa.mockproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    SecurityService securityService;


    @GetMapping("/addUser")
    public String registration(ModelMap model) {
        model.addAttribute("userModel", new UserModel());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("userModel") UserModel userModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addUser";
        }
        userService.addUser(new User(userModel));
        securityService.autoLogin(userModel.getEmail(), userModel.getPassword());
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");
        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        return "login";
    }

    @RequestMapping(path = {"/listUser"}, method = RequestMethod.GET)
    public String listUsers(Model model, int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        List<User> users = userService.users(pageable);
        model.addAttribute("users", users);
        return "listUser";
    }

    @GetMapping(path = {"/editUser"})
    public String editUser(Model model, long userId, ModelMap modelMap) {
        User viewUser = userService.findUserByUserId(userId);
        User user = userService.findByUserId(viewUser);
        modelMap.addAttribute("userModel", new UserModel());
        model.addAttribute("viewUser", viewUser);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/editUser")
    public String editEmployee(@ModelAttribute("employeeModel") UserModel userModel, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "editUser" + "?employeeId=" + userModel.getUserId();
        }
}

