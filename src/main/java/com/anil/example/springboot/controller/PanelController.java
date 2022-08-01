package com.anil.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anil.example.springboot.repository.PanelRepository;
import com.anil.example.springboot.service.PanelService;
@RestController
@RequestMapping("/pannel")
public class PanelController {
	
	
	@Autowired
	PanelService panelService;

	@Autowired
	PanelRepository panelRepository;
	
	

	public PanelController(PanelRepository panelRepository) {
		this.panelRepository = panelRepository;
	}
	/*
	
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
	
	
	
	
	 // add pannel to list redirest
	 
	@GetMapping("panellist")
	public String showUpdateFormPanel(Model model) {
		model.addAttribute("dataportal", panelService.getAllPanel());
		return "student";
	}
	
	
	
	// ad pannel add
	

	@PostMapping("addpannel")
	public String addPannel(@Valid Panel panel, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "addpanel";
		}
		System.out.println("This is testing");
		panelService.addPanel(panel);
		return "redirect:panellist";
	}
	
	
	
	 //panel update
	 
	@PostMapping("updatepanel/{id}")
	public String updatePanel(@PathVariable("id") long id, @Valid Panel panel, BindingResult result, Model model) {
		if (result.hasErrors()) {
			panel.setId(id);
			return "update-panel";
		}

		panelService.addPanel(panel);
		model.addAttribute("dataportal", panelService.getAllPanel());
		return "student";
	}
	
	
		
	// pannel upadte 
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
		
		
		
	*/	
}
