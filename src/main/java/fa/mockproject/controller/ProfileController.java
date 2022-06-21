package fa.mockproject.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping("/viewCandidate")
	public String viewCandidate(Model model) {
		List<TraineeCandidateProfile> profileList = traineeCandidateProfileService.listAll();
		List<TraineeCandidateProfileModel> modelList = new ArrayList<TraineeCandidateProfileModel>();
		for (TraineeCandidateProfile profile : profileList) {
			Candidate candidate = new Candidate(profile.getCandidate());
			TraineeCandidateProfileStatus status = candidate.getStatus();
			TraineeCandidateProfileType type = profile.getType();
			University university = profile.getUniversity();
			Faculty faculty = profile.getFaculty();
			Location location = candidate.getLocation();
			Skill skill = profile.getSkill();
			Channel channel = candidate.getChannel();
			CV cv = new CV(profile.getCv());
			TraineeCandidateProfileModel profileModel = new TraineeCandidateProfileModel(profile, candidate, status,
					type, university, faculty, location, skill, channel, cv);
			modelList.add(profileModel);
		}
		model.addAttribute("profileList", modelList);
		return "viewCandidate";
	}

	@RequestMapping(value = "/viewCandidateDetails", method = RequestMethod.GET)
	public ModelAndView viewCandidateDetails(
			@RequestParam(value = "traineeCandidateProfileId") long traineeCandidateProfileId) {
		ModelAndView mav = new ModelAndView("viewCandidateDetails");
		TraineeCandidateProfile profile = traineeCandidateProfileService.findById(traineeCandidateProfileId);
		Candidate candidate = new Candidate(profile.getCandidate());
		TraineeCandidateProfileStatus status = candidate.getStatus();
		TraineeCandidateProfileType type = profile.getType();
		University university = profile.getUniversity();
		Faculty faculty = profile.getFaculty();
		Location location = candidate.getLocation();
		Skill skill = profile.getSkill();
		Channel channel = candidate.getChannel();
		CV cv = new CV(profile.getCv());
		TraineeCandidateProfileModel profileModel = new TraineeCandidateProfileModel(profile, candidate, status, type,
				university, faculty, location, skill, channel, cv);
		mav.addObject("profile",profileModel);
		return mav;
	}

	@RequestMapping("/createNewCandidate")
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
		TraineeCandidateProfile profile = new TraineeCandidateProfile(model, university, faculty, skill, cv, type);
		Candidate candidate = new Candidate(model, channel, location, profile, status);
		cvService.save(cv);
		candidateService.save(candidate);
		traineeCandidateProfileService.save(profile);
		return "redirect:/viewCandidate";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}