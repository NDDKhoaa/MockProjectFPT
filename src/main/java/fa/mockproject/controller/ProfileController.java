package fa.mockproject.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
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

import fa.mockproject.entity.Account;
import fa.mockproject.entity.CV;
import fa.mockproject.entity.Candidate;
import fa.mockproject.entity.Channel;
import fa.mockproject.entity.EntryTest;
import fa.mockproject.entity.Faculty;
import fa.mockproject.entity.Interview;
import fa.mockproject.entity.Location;
import fa.mockproject.entity.Skill;
import fa.mockproject.entity.TraineeCandidateProfile;
import fa.mockproject.entity.TraineeCandidateProfileStatus;
import fa.mockproject.entity.TraineeCandidateProfileType;
import fa.mockproject.entity.University;
import fa.mockproject.model.EntryTestModel;
import fa.mockproject.model.InterviewModel;
import fa.mockproject.model.InterviewTestResultModel;
import fa.mockproject.model.TraineeCandidateProfileModel;
import fa.mockproject.model.WrapEntryTestModel;
import fa.mockproject.model.WrapInterviewModel;
import fa.mockproject.service.impl.AccountServiceImpl;
import fa.mockproject.service.impl.CVServiceImpl;
import fa.mockproject.service.impl.CandidateServiceImpl;
import fa.mockproject.service.impl.ChannelServiceImpl;
import fa.mockproject.service.impl.EntryTestServiceImpl;
import fa.mockproject.service.impl.FacultyServiceImpl;
import fa.mockproject.service.impl.InterviewServiceImpl;
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
	private EntryTestServiceImpl entryTestServiceImpl;

	@Autowired
	private InterviewServiceImpl interviewServiceImpl;

	@Autowired
	private AccountServiceImpl accountServiceImpl;

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
			Account account = profile.getAccount();
			TraineeCandidateProfileModel profileModel = new TraineeCandidateProfileModel(profile, candidate, status,
					type, university, faculty, location, skill, channel, cv, account);
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
		Account account = profile.getAccount();
		TraineeCandidateProfileModel profileModel = new TraineeCandidateProfileModel(profile, candidate, status, type,
				university, faculty, location, skill, channel, cv, account);
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

	@RequestMapping("/updateCandidateResults")
	public String updateCandidateResult(Model modelp,
			@RequestParam("traineeCandidateProfileId") long traineeCandidateProfileId) {
		TraineeCandidateProfile profile = traineeCandidateProfileService.findById(traineeCandidateProfileId);
		Candidate candidate = profile.getCandidate();
		List<InterviewTestResultModel> resultList = new ArrayList<>();
		InterviewTestResultModel resultP = new InterviewTestResultModel("Pass");
		InterviewTestResultModel resultF = new InterviewTestResultModel("Failed");
		resultList.add(resultP);
		resultList.add(resultF);
		TraineeCandidateProfileModel model = new TraineeCandidateProfileModel(profile, candidate);
		modelp.addAttribute("resultList", resultList);
		modelp.addAttribute("model", model);
		List<InterviewModel> interviewModel = new ArrayList<>();
		List<EntryTestModel> entryTestModel = new ArrayList<>();
		WrapInterviewModel listInterviewModel = new WrapInterviewModel(interviewModel);
		listInterviewModel.addModel(new InterviewModel());
		modelp.addAttribute("listInterviewModel", listInterviewModel);
		WrapEntryTestModel listEntryTestModel = new WrapEntryTestModel(entryTestModel);
		listEntryTestModel.addModel(new EntryTestModel());
		modelp.addAttribute("listEntryTestModel", listEntryTestModel);
		return "updateCandidateResult";
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
		Account account = profile.getAccount();
		mav.addObject("updateAccount", account);
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

		if (multipartFile.getSize() != 0) {
			TraineeCandidateProfile profileID = traineeCandidateProfileService.findById(traineeCandidateProfileId);
			Candidate candidateID = profileID.getCandidate();
			CV cvId = profileID.getCv();
			University university1 = universityService.get(university.getUniversityId());
			Faculty faculty1 = facultyService.findById(faculty.getFacultyId());
			Location location1 = locationService.findById(location.getLocationId());
			Skill skill1 = skillService.get(skill.getSkillId());
			Channel channel1 = channelService.get(channel.getChannelId());
			String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
			long fileSize = multipartFile.getSize();
			byte[] content = multipartFile.getBytes();
			CV cv1 = new CV(fileName, fileSize, content);
			String typeId = profileID.getType().getProfileStatusId();
			String StatusID = candidateID.getStatus().getProfileStatusId();
			Account account1 = profileID.getAccount();
			TraineeCandidateProfileStatus status1 = traineeCandidateProfileStatusService.findById(StatusID);
			TraineeCandidateProfileType type1 = traineeCandidateProfileTypeService.findById(typeId);
			Candidate candidate2 = new Candidate(candidate1);
			Candidate candidate = new Candidate(candidate2, channel1, location1, status1);
			TraineeCandidateProfile profile = new TraineeCandidateProfile(traineeCandidateProfile, candidate,
					university1, faculty1, skill1, cv1, type1, account1);
			profile.setTraineeCandidateProfileId(profileID.getTraineeCandidateProfileId());
			candidate.setCandidateId(candidateID.getCandidateId());
			cv1.setCvId(cvId.getCvId());
			cvService.save(cv1);
			candidateService.save(candidate);
			traineeCandidateProfileService.save(profile);
		} else {
			TraineeCandidateProfile profileID = traineeCandidateProfileService.findById(traineeCandidateProfileId);
			Candidate candidateID = profileID.getCandidate();
			CV cvId = profileID.getCv();
			University university1 = universityService.get(university.getUniversityId());
			Faculty faculty1 = facultyService.findById(faculty.getFacultyId());
			Location location1 = locationService.findById(location.getLocationId());
			Skill skill1 = skillService.get(skill.getSkillId());
			Channel channel1 = channelService.get(channel.getChannelId());
			String fileName = cvId.getName();
			long fileSize = cvId.getSize();
			byte[] content = cvId.getContent();
			CV cv1 = new CV(fileName, fileSize, content);
			String typeId = profileID.getType().getProfileStatusId();
			String StatusID = candidateID.getStatus().getProfileStatusId();
			Account account1 = profileID.getAccount();
			TraineeCandidateProfileStatus status1 = traineeCandidateProfileStatusService.findById(StatusID);
			TraineeCandidateProfileType type1 = traineeCandidateProfileTypeService.findById(typeId);
			Candidate candidate2 = new Candidate(candidate1);
			Candidate candidate = new Candidate(candidate2, channel1, location1, status1);
			TraineeCandidateProfile profile = new TraineeCandidateProfile(traineeCandidateProfile, candidate,
					university1, faculty1, skill1, cv1, type1, account1);
			profile.setTraineeCandidateProfileId(profileID.getTraineeCandidateProfileId());
			candidate.setCandidateId(candidateID.getCandidateId());
			cv1.setCvId(cvId.getCvId());
			cvService.save(cv1);
			candidateService.save(candidate);
			traineeCandidateProfileService.save(profile);
		}

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
		String fullname = model.getFullName();
		int countspace = 0;
		for (char c : fullname.toCharArray()) {
			if (c == ' ') {
				countspace++;
			}
		}
		String[] parts = fullname.split("\\s", countspace + 1);
		String name = parts[countspace];
		String username = "";
		username += name;
		for (int i = 0; i < countspace; i++) {
			username += parts[i].charAt(0);
		}
		List<Account> accountList = accountServiceImpl.listAll();
		for (Account account : accountList) {
			if (account.getAccount().equals(username)) {
				char c = username.charAt(username.length() - 1);
				if (!Character.isDigit(c)) {
					username = username + "1";
				}
			}
		}
		for (Account accounts : accountList) {
			if (accounts.getAccount().equals(username)) {
				char c = username.charAt(username.length() - 1);
				if (Character.isDigit(c)) {
					int intc = c;
					intc = intc + 1;
					char charc = (char) intc;
					StringBuilder usernameStringBuilder = new StringBuilder(username);
					usernameStringBuilder.setCharAt(usernameStringBuilder.length() - 1, charc);
					username = new String(usernameStringBuilder);
				}
			}
		}
		model.setAccount(username);
		model.setPassword(username);
		Account account1 = new Account(model);
		TraineeCandidateProfileStatus status = traineeCandidateProfileStatusService.findById(model.getStatusId());
		TraineeCandidateProfileType type = traineeCandidateProfileTypeService.findById(model.getTypeId());
		CV cv = new CV(model);
		Candidate candidate = new Candidate(model, channel, location, status);
		TraineeCandidateProfile profile = new TraineeCandidateProfile(model, candidate, university, faculty, skill, cv,
				type, account1);
		List<Candidate> candidates = new ArrayList<>();
		candidates.add(candidate);
		status.setCandidate(candidates);
		traineeCandidateProfileStatusService.save(status);
		cvService.save(cv);
		candidateService.save(candidate);
		profile.setCandidate(candidate);
		traineeCandidateProfileService.save(profile);
		account1.setTraineeCandidateProfile(profile);
		accountServiceImpl.save(account1);
		return "redirect:/viewCandidate";
	}

	@RequestMapping(value = "/saveUpdateResults", method = RequestMethod.POST)
	public String saveResults(@ModelAttribute("listInterviewModel") WrapInterviewModel listInterviewModel,
			@ModelAttribute("listEntryTestModel") WrapEntryTestModel listEntryTestModel,
			@RequestParam("traineeCandidateProfileId") long traineeCandidateProfileId) {
		TraineeCandidateProfile profile = traineeCandidateProfileService.findById(traineeCandidateProfileId);
		Candidate candidateId = profile.getCandidate();
		List<InterviewModel> interviewModels = listInterviewModel.getInterviewModels();
		List<EntryTestModel> entryTestModels = listEntryTestModel.getEntryTestModels();
		for (InterviewModel interviewModel : interviewModels) {
			Interview interview = new Interview(interviewModel, candidateId);
			interview.setCandidate(candidateId);
			interviewServiceImpl.save(interview);
		}
		for (EntryTestModel entryTestModel : entryTestModels) {
			EntryTest entryTest = new EntryTest(entryTestModel, candidateId);
			entryTest.setCandidate(candidateId);
			entryTestServiceImpl.save(entryTest);
		}

		/*
		 * if (interview.getResult().equals("Pass") &&
		 * entryTest.getResult().equals("Pass")) { String statusId = "IP";
		 * TraineeCandidateProfileStatus status =
		 * traineeCandidateProfileStatusService.findById(statusId);
		 * candidateId.setStatus(status); candidateService.save(candidateId); } if
		 * (entryTest.getResult().equals("Failed") &&
		 * interview.getResult().equals("Pass")) { String statusId = "TF";
		 * TraineeCandidateProfileStatus status =
		 * traineeCandidateProfileStatusService.findById(statusId);
		 * candidateId.setStatus(status); candidateService.save(candidateId); } if
		 * (interview.getResult().equals("Failed") &&
		 * entryTest.getResult().equals("Pass")) { String statusId = "IF";
		 * TraineeCandidateProfileStatus status =
		 * traineeCandidateProfileStatusService.findById(statusId);
		 * candidateId.setStatus(status); candidateService.save(candidateId); } if
		 * (interview.getResult().equals("Failed") &&
		 * entryTest.getResult().equals("Failed")) { String statusId = "IF";
		 * TraineeCandidateProfileStatus status =
		 * traineeCandidateProfileStatusService.findById(statusId);
		 * candidateId.setStatus(status); candidateService.save(candidateId); } if
		 * (interview.getResult().equals("0") && entryTest.getResult().equals("Pass")) {
		 * String statusId = "TP"; TraineeCandidateProfileStatus status =
		 * traineeCandidateProfileStatusService.findById(statusId);
		 * candidateId.setStatus(status); candidateService.save(candidateId); } if
		 * (interview.getResult().equals("0") && entryTest.getResult().equals("Failed"))
		 * { String statusId = "TF"; TraineeCandidateProfileStatus status =
		 * traineeCandidateProfileStatusService.findById(statusId);
		 * candidateId.setStatus(status); candidateService.save(candidateId); } if
		 * (entryTest.getResult().equals("0") && interview.getResult().equals("Pass")) {
		 * String statusId = "IP"; TraineeCandidateProfileStatus status =
		 * traineeCandidateProfileStatusService.findById(statusId);
		 * candidateId.setStatus(status); candidateService.save(candidateId); } if
		 * (entryTest.getResult().equals("0") && interview.getResult().equals("Failed"))
		 * { String statusId = "IF"; TraineeCandidateProfileStatus status =
		 * traineeCandidateProfileStatusService.findById(statusId);
		 * candidateId.setStatus(status); candidateService.save(candidateId); } if
		 * (interview.getResult().equals("0") && entryTest.getResult().equals("0")) {
		 * String statusId = "New"; TraineeCandidateProfileStatus status =
		 * traineeCandidateProfileStatusService.findById(statusId);
		 * candidateId.setStatus(status); candidateService.save(candidateId); }
		 */
		return "redirect:/viewCandidate";
	}

	@RequestMapping("/deleteCandidate")
	public String DeleteProfile(@RequestParam("traineeCandidateProfileId") long traineeCandidateProfileId) {
		TraineeCandidateProfile profile = traineeCandidateProfileService.findById(traineeCandidateProfileId);
		Candidate candidate = profile.getCandidate();
		CV cv = profile.getCv();
		List<EntryTest> tests = entryTestServiceImpl.findByCandidate(candidate);
		List<Interview> interviews = interviewServiceImpl.findByCandidate(candidate);
		Account account = profile.getAccount();
		for (EntryTest test : tests) {
			entryTestServiceImpl.delete(test);
		}
		for (Interview interview : interviews) {
			interviewServiceImpl.delete(interview);
		}
		accountServiceImpl.delete(account);
		traineeCandidateProfileService.delete(profile);
		candidateService.delete(candidate);
		cvService.delete(cv);
		return "redirect:/viewCandidate";
	}

	@RequestMapping(value = "/deleteCandidates", method = RequestMethod.POST)
	public String DeleteProfiles(HttpServletRequest request) {
		String[] list = request.getParameterValues("chkCheckBoxId");
		if (list != null) {
			for (String id : request.getParameterValues("chkCheckBoxId")) {
				long longId = Long.parseLong(id);
				TraineeCandidateProfile profile = traineeCandidateProfileService.findById(longId);
				Candidate candidate = profile.getCandidate();
				CV cv = profile.getCv();
				List<EntryTest> tests = entryTestServiceImpl.findByCandidate(candidate);
				List<Interview> interviews = interviewServiceImpl.findByCandidate(candidate);
				Account account = profile.getAccount();
				for (EntryTest test : tests) {
					entryTestServiceImpl.delete(test);
				}
				for (Interview interview : interviews) {
					interviewServiceImpl.delete(interview);
				}
				accountServiceImpl.delete(account);
				traineeCandidateProfileService.delete(profile);
				candidateService.delete(candidate);
				cvService.delete(cv);
			}
			return "redirect:/viewCandidate";
		} else {
			return "redirect:/viewCandidate";
		}
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

	@RequestMapping("/searchProfile")
	public ModelAndView searchProfile(@RequestParam String word) {
		ModelAndView mav = new ModelAndView("searchProfileResults");
		List<TraineeCandidateProfileModel> modelList = new ArrayList<TraineeCandidateProfileModel>();
		List<TraineeCandidateProfile> profileList = traineeCandidateProfileService.search(word);
		if (profileList.isEmpty()) {
			List<TraineeCandidateProfileStatus> statusList = traineeCandidateProfileStatusService.search(word);
			for (TraineeCandidateProfileStatus status : statusList) {
				List<Candidate> candidates = status.getCandidate();
				for (Candidate candidate : candidates) {
					TraineeCandidateProfileStatus status1 = candidate.getStatus();
					TraineeCandidateProfile profile1 = traineeCandidateProfileService.findByCandidate(candidate);
					TraineeCandidateProfileModel profileModel = new TraineeCandidateProfileModel(profile1, status1);
					modelList.add(profileModel);
				}
			}
		} else {
			for (TraineeCandidateProfile profile : profileList) {
				Candidate candidate = new Candidate(profile.getCandidate());
				TraineeCandidateProfileStatus status = candidate.getStatus();
				TraineeCandidateProfileModel profileModel = new TraineeCandidateProfileModel(profile, status);
				modelList.add(profileModel);
			}
		}
		mav.addObject("modelList", modelList);
		return mav;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}