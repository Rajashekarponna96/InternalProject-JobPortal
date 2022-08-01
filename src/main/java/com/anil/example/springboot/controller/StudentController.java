package com.anil.example.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.anil.example.springboot.entity.Admin;
import com.anil.example.springboot.entity.Panel;
import com.anil.example.springboot.entity.Student;
import com.anil.example.springboot.repository.AdminRepository;
import com.anil.example.springboot.repository.PanelRepository;
import com.anil.example.springboot.repository.StudentRepository;
import com.anil.example.springboot.service.PanelService;
import com.anil.example.springboot.service.StudentService;

@Controller
@RequestMapping("/dataportal/")
public class StudentController {
	private final StudentRepository studentRepository;

	@Autowired
	StudentService studentService;

	@Autowired
	AdminRepository adminrepository;

	HttpSession session;

	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

//private final PanelRepository panelRepository;

	@Autowired
	PanelService panelService;

	@Autowired
	PanelRepository panelepository;

	// this for displaying index page inside job page
	@GetMapping("job")
	public String job() {
		return "job.html";
	}

	// home
	@GetMapping("index")
	public String home() {
		return "index";

	}

	// Admin View
	@GetMapping("Adminview")
	public String adminView() {
		return "adminview";
	}

	// this for link for panel login
	// @GetMapping("checkdetails")
	@RequestMapping(path = "panellogin", method = RequestMethod.GET)
	public String showloginadminForm() {

		return "panellogin.html";
	}

	// add admin
	@GetMapping("addAdmin")
	public String addAdmin() {
		return "admin.html";
	}

	// candidatelogin
	@RequestMapping(path = "candidatelogin", method = RequestMethod.GET)
	public String candidateLogin() {
		return "candidatelogin";
	}

	// admin login
	@GetMapping("adminlogin")
	public String adminLogin() {
		return "adminloginpage.html";
	}
//	public StudentController(StudentRepository studentRepository) {
//		this.studentRepository = studentRepository;
//	}
//	

//	@RequestMapping(path = "rolecheck",method = RequestMethod.POST )
//	public String loginPage(@RequestParam("role") String role) {
//		if("admin".equals(role))
//		{
//			return "adminloginpage";
//		}
//		else if("candidate".equals(role)) {
//			return "candidatelogin";
//		}
//		else if("panel".equals(role)) {
//			return "Panellogin";
//		}
//		else {
//			return "index";
//		}
//	}

	// here admin index page when u select it will redirect to checkdetails ened
	// point

	@RequestMapping(path = "rolecheck", method = RequestMethod.POST)
	public String loginPage(@RequestParam("role") String role) {
		if ("admin".equals(role)) {
			return "adminloginpage";
			// return "candidatelogin";
		}
		if ("candidate".equals(role)) {
			return "candidatelogin";
		}
		if ("panel".equals(role)) {
			return "panellogin";
		} else {
			return "index";
		}
	}

	// admin check details end point

	// @GetMapping("checkdetails")
	@RequestMapping(path = "checkdetails", method = RequestMethod.GET)
	public String showAdminForm() {

		return "admin";
	}

	// admin registration end point
	@PostMapping("adminregistration")
	public String addAdmin(@Valid Admin admin, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "admin";
		}
		System.out.println("This is testing");
		adminrepository.save(admin);
		return "index";
	}

	/*
	 * @RequestMapping(path = "checkdetails",method = RequestMethod.POST) public
	 * String showSignUpForm(@RequestParam("username") String
	 * username, @RequestParam("password") String password, Model
	 * model,HttpServletRequest request) { Admin admindata =
	 * adminrepository.findByusername(username); if(admindata == null){ return
	 * "index"; } System.out.println(admindata);
	 * if(admindata.getUsername().equals(username)&&admindata.getPassword().equals(
	 * password)) { request.getSession(); session = request.getSession(false);
	 * 
	 * if(session != null) {
	 * 
	 * return "adminview";
	 * 
	 * } return "index"; } else {
	 * System.out.println("In correct username or password " +
	 * "the entered user name is "+username +"the entereted password is "
	 * +password); model.addAttribute("message",
	 * "there is no active session invalid username password"); return "index"; }
	 * 
	 * }
	 * 
	 */
	// admin enter into student page check details
	@RequestMapping(path = "checkdetails", method = RequestMethod.POST)
	public String showSignUpForm(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model, HttpServletRequest request) {
		Admin admindata = adminrepository.findByusername(username);
		if (admindata == null) {
			return "index";
		}
		System.out.println(admindata);
		if (admindata.getUsername().equals(username) && admindata.getPassword().equals(password)) {
			request.getSession();
			session = request.getSession(false);

			/*
			 * if (session != null) {
			 * 
			 * model.addAttribute("dataportal", studentService.getAllStudent()); return
			 * findPaginated(1, model);
			 * 
			 * } return "index";
			 */
			request.getSession();
			session = request.getSession(false);

			if (session != null) {

				return "adminview";

			}
			return "index";
		} else {
			System.out.println("In correct username or password " + "the entered user name is " + username
					+ "the entereted password is " + password);
			model.addAttribute("message", "there is no active session invalid username password");
			return "index";
		}

	}

	// sign up for adding to add candidate page
	@GetMapping("signup")
	public String showSignUpForm(Student student, HttpServletRequest request, Model model) {
		session = request.getSession(false);
		if (session != null) {

			return "add-student";

		}
		model.addAttribute("message", "there is no active session");
		System.out.println("i am printing because of invalid session");

		return "index";
	}

	// add to when u submit add candiate click

	@PostMapping("add")
	public String addStudent(@Valid Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-student";
		}
		System.out.println("This is testing");
		studentService.addStudent(student);
		return "redirect:list";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model, HttpServletRequest request) {
		session = request.getSession(false);
		if (session != null) {
			model.addAttribute("dataportal", studentService.getAllStudent());
			return "student";
		}
		model.addAttribute("message", "there is no active session");
		System.out.println("i am printing because of invalid session");

		return "index";
	}

	/*
	 * //candidate list
	 * 
	 * @GetMapping("list") public String showUpdateForm(Model model) {
	 * model.addAttribute("dataportal", studentService.getAllStudent()); return
	 * "student"; }
	 */
	// edit the candiate page to edit the admin page edit

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("student", student);
		return "update-student";
	}

	// update candiate when u click edit it will update new updated page
	@PostMapping("update/{id}")
	public String updateStudent(@PathVariable("id") long id, @Valid Student student, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			student.setId(id);
			return "update-student";
		}

		studentService.addStudent(student);
		model.addAttribute("dataportal", studentService.getAllStudent());
		return "student";
	}

	// here the normal /particular candiate login
	@RequestMapping(path = "candidatecheck", method = RequestMethod.POST)
	public String candidateView(@RequestParam("email") String email, @RequestParam("password") String password,
			Model model) {
		Student candidate = studentService.findByEmail(email);
		System.out.println(candidate);
		if (candidate == null) {
			return "candidatelogin";
		}
		System.out.println(candidate);
		if (candidate.getEmail().equals(email) && candidate.getPhoneNo().equals(password)) {
			model.addAttribute("dataportal", studentService.findByEmail(email));
			return "candidateview";
		} else {
			System.out.println("I am in error but coming till here " + "the entered user name is " + email
					+ "the entereted password is " + password);
			return "candidatelogin";
		}
	}

	// edit the candiate the in the candiate page inside candiate can edit

	@GetMapping("studentedit/{id}")
	public String showStudentUpdateForm(@PathVariable("id") long id, Model model) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("student", student);
		return "studentupdate";
	}

	// candidate can edit his after edit it will update end point will return

	@PostMapping("candidateupdate/{id}")
	public String candidateUpdate(@RequestParam("email") String email, @PathVariable("id") long id,
			@Valid Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			student.setId(id);
			return "studentupdate";
		}

		studentService.addStudent(student);
		model.addAttribute("dataportal", studentService.findByEmail(email));
		System.out.println(studentService.findByEmail(email));
		return "candidateview";
	}

	// delete option
	// admin will delete particular candiate
	@GetMapping("delete/{id}")
	public String deleteStudent(@PathVariable("id") long id, Model model) {
		/*
		 * .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		 */
		System.out.println("This is inside delete");
		studentService.deleteStudentById(id);
		model.addAttribute("dataportal", studentService.getAllStudent());
		return "student";
	}

	// delete option
	// admin will delete particular candiate
	@GetMapping("deletepanel/{id}")
	public String deletePannel(@PathVariable("id") long id, Model model) {
		/*
		 * .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		 */
		System.out.println("This is inside delete");
		panelService.deletePaneltById(id);
		model.addAttribute("panels", panelService.getAllPanel());
		return "panel";
	}

	// ==============================================

	/*
	 * pannel check
	 */
	@RequestMapping(path = "panelcheck", method = RequestMethod.POST)
	public String pannelCheck(@RequestParam("email") String email, @RequestParam("password") String password,
			Model model) {
		Panel panel = panelService.findByEmail(email);
		System.out.println(panel);
		if (panel == null) {
			return "panellogin";
		}
		System.out.println(panel);
		if (panel.getEmail().equals(email) && panel.getPhoneNo().equals(password)) {
			model.addAttribute("dataportal", panelService.findByEmail(email));
			return "panelview";
		} else {
			System.out.println("I am in error but coming till here " + "the entered user name is " + email
					+ "the entereted password is " + password);
			return "panellogin";
		}
	}

	/*
	 * sign up for add pannel
	 */
	@GetMapping("signuppannel")
	public String showSignUpFormaddpannel(Panel panel, HttpServletRequest request, Model model) {
		session = request.getSession(false);
		if (session != null) {

			return "addpanel";

		}
		model.addAttribute("message", "there is no active session");
		System.out.println("i am printing because of invalid session");

		return "index";
	}

	/*
	 * add pannel to list redirest
	 */
	@GetMapping("panellist")
	public String showUpdateFormPanel(Model model) {
		model.addAttribute("panels", panelService.getAllPanel());
		System.out.println(panelepository.findAll());
		return "panel";
	}

	/*
	 * ad pannel add
	 */

	@PostMapping("addpannel")
	public String addPannel(@Valid Panel panel, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "addpanel";
		}
		System.out.println("This is testing");
		panelService.addPanel(panel);
		return "redirect:panellist";
	}

	/*
	 * pannel edit
	 */

	@GetMapping("paneledit/{id}")
	public String showPannelUpdateForm(@PathVariable("id") long id, Model model) {
		Panel panel = panelepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid panel Id:" + id));
		model.addAttribute("panel", panel);
		return "update-panel";
	}

	/*
	 * panel update
	 */
	@PostMapping("updatepanel/{id}")
	public String updatePanel(@PathVariable("id") long id, @Valid Panel panel, BindingResult result, Model model) {
		if (result.hasErrors()) {
			panel.setId(id);
			return "update-panel";
		}

		panelService.addPanel(panel);
		model.addAttribute("dataportal", panelService.getAllPanel());
		return "panel";
	}

	/* pannel upadte */
	@PostMapping("panelupdate/{id}")
	public String panelUpdate(@RequestParam("email") String email, @PathVariable("id") long id, @Valid Panel panel,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			panel.setId(id);
			return "panelupdate";
		}

		panelService.addPanel(panel);
		model.addAttribute("dataportal", panelService.findByEmail(email));
		System.out.println(panelService.findByEmail(email));
		return "panelview";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
		int pageSize = 5;

		Page<Student> page = studentService.findPaginated(pageNo, pageSize);
		List<Student> dataportal = page.getContent();
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("dataportal", dataportal);
		return "student";
	}

	// Filter operation code
	@GetMapping("controller")
	public String getStudents(@Param("field") String field, Model model, @Param("keyword") String keyword) {
		switch (field) {

		case "address":
			model.addAttribute("dataportal", studentService.findByAddress(keyword));
			return "student";

		case "name":
			model.addAttribute("dataportal", studentService.findThroughName(keyword));
			return "student";

		case "email":
			model.addAttribute("dataportal", studentService.findThroughEmail(keyword));
			return "student";

		case "alternatePhoneNo":
			model.addAttribute("dataportal", studentService.findThroughalternatePhoneNo(keyword));
			return "student";

		case "phoneNo":
			model.addAttribute("dataportal", studentService.findThroughPhoneNo(keyword));
			return "student";

		case "status":
			model.addAttribute("dataportal", studentService.findThroughStatus(keyword));
			return "student";

		default:
			model.addAttribute("dataportal", studentService.findByKeyword(keyword));
			return "student";

		}

	}

	@GetMapping("logout")
	public String logoutAction(HttpServletRequest request) {

		request.getSession();
		session = request.getSession(false);

		session.invalidate();

		return "index";
	}
}