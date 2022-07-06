package fa.mockproject.controller;

import fa.mockproject.entity.Location;
import fa.mockproject.entity.User;
import fa.mockproject.entity.enumtype.ClassBatchStatusEnum;
import fa.mockproject.security.CustomUserDetails;
import fa.mockproject.service.ClassBatchService;
import fa.mockproject.service.LocationService;
import fa.mockproject.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

  @Autowired
  private SecurityService securityService;
  @Autowired
  private LocationService locationService;
  @Autowired
  private ClassBatchService classBatchService;

  @GetMapping(path = {"/dashboard"})
  public String dashboardPage(Model model) {
    UserDetails userDetails = securityService.findLoggedInUsername();
    User user = ((CustomUserDetails) userDetails).getUser();
    String fullName = user.getFirstName() + "" + user.getLastName();
    model.addAttribute("fullName", fullName);
    model.addAttribute("roles", user.getRoles());
    model.addAttribute("locations", locationService.listAll());
    model.addAttribute("classPlanning",
            classBatchService.getListTrainee(null, ClassBatchStatusEnum.Planning));
    model.addAttribute("classPlanned",
            classBatchService.getListTrainee(null, ClassBatchStatusEnum.Planned));
    model.addAttribute("classInProgress",
            classBatchService.getListTrainee(null, ClassBatchStatusEnum.InProgress));
    return "dashboard";
  }
}
