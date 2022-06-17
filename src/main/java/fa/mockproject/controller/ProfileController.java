package fa.mockproject.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fa.mockproject.entity.CV;
import fa.mockproject.entity.Candidate;
import fa.mockproject.entity.Channel;
import fa.mockproject.entity.Faculty;
import fa.mockproject.entity.Location;
import fa.mockproject.entity.Skill;
import fa.mockproject.entity.TraineeCandidateProfile;
import fa.mockproject.entity.TraineeCandidateProfileStatus;
import fa.mockproject.entity.TraineeCandidateProfileType;
import fa.mockproject.entity.University;
import fa.mockproject.model.TraineeCandidateProfileModel;
import fa.mockproject.service.impl.CVServiceImpl;
import fa.mockproject.service.impl.CandidateServiceImpl;
import fa.mockproject.service.impl.ChannelServiceImpl;
import fa.mockproject.service.impl.FacultyServiceImpl;
import fa.mockproject.service.impl.LocationServiceImpl;
import fa.mockproject.service.impl.SkillServiceImpl;
import fa.mockproject.service.impl.TraineeCandidateProfileServiceImpl;
import fa.mockproject.service.impl.TraineeCandidateProfileStatusServiceImpl;
import fa.mockproject.service.impl.TraineeCandidateProfileTypeServiceImpl;
import fa.mockproject.service.impl.UniversityServiceImpl;

@Controller
public class ProfileController {

	@Autowired
	private CandidateServiceImpl candidateService;

	@Autowired
	private ChannelServiceImpl channelService;

	@Autowired
	private UniversityServiceImpl universityService;

	@Autowired
	private LocationServiceImpl locationService;

	@Autowired
	private FacultyServiceImpl facultyService;

	@Autowired
	private SkillServiceImpl skillService;

	@Autowired
	private CVServiceImpl cvService;

	@Autowired
	private TraineeCandidateProfileServiceImpl traineeCandidateProfileService;

	@Autowired
	private TraineeCandidateProfileTypeServiceImpl traineeCandidateProfileTypeService;

	@Autowired
	private TraineeCandidateProfileStatusServiceImpl traineeCandidateProfileStatusService;

	@RequestMapping("/createCandidate")
	public String createCandidate(Model model) {
		model.addAttribute("traineeCandidateForm", new TraineeCandidateProfileModel());
		List<Channel> channelList = channelService.listAll();
		model.addAttribute("channelList", channelList);
		List<University> universityList = universityService.listAll();
		model.addAttribute("universityList", universityList);
		List<Faculty> facultyList = facultyService.listAll();
		model.addAttribute("facultyList", facultyList);
		List<Location> locationList = locationService.listAll();
		model.addAttribute("locationList", locationList);
		List<Skill> skillList = skillService.listAll();
		model.addAttribute("skillList", skillList);
		CV cv = new CV();
		model.addAttribute("cv", cv);
		return "createCandidate";
	}

	@RequestMapping(value = "/saveProfile", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("traineeCandidateForm") TraineeCandidateProfileModel model,
			@RequestParam("file") MultipartFile multipartFile) throws IOException {
		University university = universityService.get(model.getUniversityId());
		Faculty faculty = facultyService.findById(model.getFacultyId());
		Location location = locationService.findById(model.getLocationId());
		Skill skill = skillService.get(model.getSkillId());
		Channel channel = channelService.get(model.getChannelId());
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		long fileSize = multipartFile.getSize();
		byte[] content = multipartFile.getBytes();
		model.setCVname(fileName);
		model.setSize(fileSize);
		model.setContent(content);
		TraineeCandidateProfileStatus status = traineeCandidateProfileStatusService.findById(model.getStatusId());
		TraineeCandidateProfileType type = traineeCandidateProfileTypeService.findById(model.getTypeId());
		CV cv = new CV(model);
		TraineeCandidateProfile profile = new TraineeCandidateProfile(model, location, university, faculty, skill, cv,
				type);
		Candidate candidate = new Candidate(model, channel, profile, status);
		cvService.save(cv);
		candidateService.save(candidate);
		traineeCandidateProfileService.save(profile);
		return "redirect:/createCandidate";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}