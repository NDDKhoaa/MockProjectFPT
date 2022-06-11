package fa.mockproject.controller;

import fa.mockproject.entity.User;
import fa.mockproject.model.UserModel;
import fa.mockproject.service.SecurityService;
import fa.mockproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

  /*  @GetMapping(path = {"/editEmployee"})
    public String editEmployee(Model model, int employeeId, ModelMap modelMap) {
        Employee viewEmployee = employeeService.getEmployeeById(employeeId);
        Account account = accountService.findAccountByEmployeeId(viewEmployee);
        modelMap.addAttribute("employeeModel", new EmployeeModel());
        model.addAttribute("employee", viewEmployee);
        model.addAttribute("account", account);
        return "editEmployee";
    }

    @PostMapping("/editEmployee")
    public String editEmployee(@ModelAttribute("employeeModel") EmployeeModel employeeModel, BindingResult bindingResult) {
        userValidator.validate(employeeModel, bindingResult);
        if (bindingResult.hasErrors()) {
            return "editEmployee" + "?employeeId=" + employeeModel.getEmployeeId();
        }
        employeeService.update(new Employee(employeeModel));
        return "redirect:/listEmployee";
    }*/
}

