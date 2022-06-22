package fa.mockproject.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
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
		mav.addObject("profile", profileModel);
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

	@RequestMapping("/updateCandidate")
	public ModelAndView updateCandidate(@RequestParam("traineeCandidateProfileId") long traineeCandidateProfileId) {
		ModelAndView mav = new ModelAndView("updateCandidate");
		TraineeCandidateProfile profile = traineeCandidateProfileService.findById(traineeCandidateProfileId);
		Candidate candidate = new Candidate(profile.getCandidate());
		mav.addObject("updateCandidate", candidate);
		TraineeCandidateProfileStatus status = candidate.getStatus();
		mav.addObject("updateStatus", status);
		TraineeCandidateProfileType type = profile.getType();
		mav.addObject("updateType", type);
		University university = profile.getUniversity();
		mav.addObject("updateUniversity", university);
		Faculty faculty = profile.getFaculty();
		mav.addObject("updateFaculty", faculty);
		Location location = candidate.getLocation();
		mav.addObject("updateLocation", location);
		Skill skill = profile.getSkill();
		mav.addObject("updateSkill", skill);
		Channel channel = candidate.getChannel();
		mav.addObject("updateChannel", channel);
		CV cv = new CV(profile.getCv());
		mav.addObject("updateCv", cv);
		mav.addObject("updateProfile", profile);
		List<Channel> channelList = channelService.listAll();
		mav.addObject("channelList", channelList);
		List<University> universityList = universityService.listAll();
		mav.addObject("universityList", universityList);
		List<Faculty> facultyList = facultyService.listAll();
		mav.addObject("facultyList", facultyList);
		List<Location> locationList = locationService.listAll();
		mav.addObject("locationList", locationList);
		List<Skill> skillList = skillService.listAll();
		mav.addObject("skillList", skillList);
		CV cv1 = new CV();
		mav.addObject("cv1", cv1);
		return mav;
	}

	@RequestMapping(value = "/saveUpdate", method = RequestMethod.POST)
	public String saveUpdateCandidate(@ModelAttribute("updateCandidate") Candidate candidate1,
			@ModelAttribute("updateStatus") TraineeCandidateProfileStatus status,
			@ModelAttribute("updateType") TraineeCandidateProfileType type,
			@ModelAttribute("updateUniversity") University university, @ModelAttribute("updateFaculty") Faculty faculty,
			@ModelAttribute("updateLocation") Location location, @ModelAttribute("updateSkill") Skill skill,
			@ModelAttribute("updateChannel") Channel channel, @ModelAttribute("updateCv") CV cv,
			@ModelAttribute("updateProfile") TraineeCandidateProfile traineeCandidateProfile,
			@RequestParam("file") MultipartFile multipartFile,
			@RequestParam("traineeCandidateProfileId") long traineeCandidateProfileId) throws IOException {
		TraineeCandidateProfile profileID = traineeCandidateProfileService.findById(traineeCandidateProfileId);
		University university1 = universityService.get(university.getUniversityId());
		Faculty faculty1 = facultyService.findById(faculty.getFacultyId());
		Location location1 = locationService.findById(location.getLocationId());
		Skill skill1 = skillService.get(skill.getSkillId());
		Channel channel1 = channelService.get(channel.getChannelId());
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		long fileSize = multipartFile.getSize();
		byte[] content = multipartFile.getBytes();
		CV cv1 = new CV(fileName, fileSize, content);
		String typeId = "Candidate";
		String StatusID = "New";
		TraineeCandidateProfileStatus status1 = traineeCandidateProfileStatusService.findById(StatusID);
		TraineeCandidateProfileType type1 = traineeCandidateProfileTypeService.findById(typeId);
		Candidate candidate2 = new Candidate(candidate1);
		Candidate candidate = new Candidate(candidate2, channel1, location1, status1);
		TraineeCandidateProfile profile = new TraineeCandidateProfile(traineeCandidateProfile, candidate, university1,
				faculty1, skill1, cv1, type1);
		profile.setTraineeCandidateProfileId(profileID.getTraineeCandidateProfileId());
		cvService.save(cv1);
		candidateService.save(candidate);
		traineeCandidateProfileService.save(profile);

		return "redirect:/viewCandidate";
	}

	@RequestMapping(value = "/saveProfile", method = RequestMethod.POST)
	public String saveCandidate(@ModelAttribute("traineeCandidateForm") TraineeCandidateProfileModel model,
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
		Candidate candidate = new Candidate(model, channel, location, status);
		TraineeCandidateProfile profile = new TraineeCandidateProfile(model, candidate, university, faculty, skill, cv,
				type);

		cvService.save(cv);
		candidateService.save(candidate);
		profile.setCandidate(candidate);
		traineeCandidateProfileService.save(profile);

		return "redirect:/viewCandidate";
	}
	
	@RequestMapping("/deleteCandidate")
	public String DeleteProfile(@RequestParam("traineeCandidateProfileId") long traineeCandidateProfileId) {
		TraineeCandidateProfile profile = traineeCandidateProfileService.findById(traineeCandidateProfileId);
		Candidate candidate = profile.getCandidate();
		CV cv = profile.getCv();
		traineeCandidateProfileService.delete(profile);
		candidateService.delete(candidate);
		cvService.delete(cv);
		return "redirect:/viewCandidate";
	}


	@GetMapping("/downloadCV")
	public void downloadCV(@Param("cvId") long cvId, HttpServletResponse response) throws IOException {
		CV cv = cvService.getFile(cvId);
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=" + cv.getName();
		response.setHeader(headerKey, headerValue);
		ServletOutputStream outputStream = response.getOutputStream();
		outputStream.write(cv.getContent());
		outputStream.close();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}