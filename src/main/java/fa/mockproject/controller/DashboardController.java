package fa.mockproject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fa.mockproject.entity.DashboardData;
import fa.mockproject.entity.Location;
import fa.mockproject.entity.TraineeCandidateProfileStatus;
import fa.mockproject.entity.enumtype.ClassBatchStatusEnum;
import fa.mockproject.model.DashboardModel;
import fa.mockproject.service.CandidateService;
import fa.mockproject.service.ClassBatchService;
import fa.mockproject.service.LocationService;
import fa.mockproject.service.TraineeCandidateProfileStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private LocationService locationService;
    @Autowired
    private ClassBatchService classBatchService;
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private TraineeCandidateProfileStatusService traineeCandidateProfileStatusService;

    @GetMapping(path = {"/dashboard"})
    public String dashboardPage(Model model) {
        model.addAttribute("locations", locationService.listAll());
        model.addAttribute("classPlanning",
                classBatchService.getListTrainee(null, ClassBatchStatusEnum.Planning));
        model.addAttribute("classPlanned",
                classBatchService.getListTrainee(null, ClassBatchStatusEnum.Planned));
        model.addAttribute("classInProgress",
                classBatchService.getListTrainee(null, ClassBatchStatusEnum.InProgress));
        model.addAttribute("candidateStatus", traineeCandidateProfileStatusService.listAll());
        return "dashboards/classDashboard";
    }

    @GetMapping(path = {"/getStatus"})
    public ResponseEntity status(String status) throws JsonProcessingException {
        String ajaxResponse = "";
        ObjectMapper mapper = new ObjectMapper();
        if (status.equals("class")) {
            ajaxResponse = mapper.writeValueAsString(ClassBatchStatusEnum.values());
        } else {
            ajaxResponse = mapper.writeValueAsString(traineeCandidateProfileStatusService.listAll());
        }

        return ResponseEntity.ok().body(ajaxResponse);
    }

    @PostMapping(path = {"/dashboardType"})
    public ResponseEntity dashboard(@RequestBody DashboardModel data) throws JsonProcessingException {
        Location location;
        if (data.getLocation().equals("all")) {
            location = null;
        } else {
            location = new Location(data.getLocation());
        }
        String ajaxResponse = "";
        ObjectMapper mapper = new ObjectMapper();
        if (data.getDashboardFor().equals("class")) {
            List<DashboardData> dataList;
            if (data.getStatus() == null || data.getStatus().equals("all")) {
                dataList = classBatchService.getListTrainee(location, null);

            } else {
                dataList = classBatchService.getListTrainee(location,
                        ClassBatchStatusEnum.valueOf(data.getStatus()));
            }
            ajaxResponse = mapper.writeValueAsString(dataList);
        }
        if (data.getDashboardFor().equals("candidate")) {
            List<DashboardData> dataList;
            if (data.getStatus() == null || data.getStatus().equals("all")) {
                dataList = candidateService.findByLocationAndStatus(location, null);
            } else {
                dataList = candidateService.findByLocationAndStatus(location,
                        new TraineeCandidateProfileStatus(data.getStatus()));
            }
            ajaxResponse = mapper.writeValueAsString(dataList);
        }
        return ResponseEntity.ok().body(ajaxResponse);
    }
}
