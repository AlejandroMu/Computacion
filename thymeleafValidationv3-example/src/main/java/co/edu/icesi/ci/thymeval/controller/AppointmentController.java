package co.edu.icesi.ci.thymeval.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.icesi.ci.thymeval.model.Appointment;
import co.edu.icesi.ci.thymeval.model.User;
import co.edu.icesi.ci.thymeval.service.AppointmentService;
import co.edu.icesi.ci.thymeval.service.UserService;

@Controller
public class AppointmentController {

	private AppointmentService appointmentService;
	private UserService userService;
	private Iterable<User> doctors;
	private Iterable<User> patients;

	@Autowired
	public AppointmentController(AppointmentService appointmentService, UserService userService) {
		this.userService = userService;
		this.appointmentService = appointmentService;
		doctors = userService.findAllDoctors();
		patients = userService.findAllPatients();
	}

	@GetMapping("/apps/")
	public String indexApp(Model model) {
		model.addAttribute("apps", appointmentService.findAll());
		return "apps/index";
	}

	@GetMapping("/apps/add")
	public String addApp(Model model) {
		model.addAttribute("appoint", new Appointment());
		model.addAttribute("doctors", doctors);
		model.addAttribute("patients", patients);
		return "apps/add-app";
	}

	@PostMapping("/apps/add")
	public String saveApp(Appointment appoint, Model model,
			@RequestParam(value = "action", required = true) String action) {
		if (!action.equals("Cancel")) {
			appointmentService.save(appoint);
		}
		return "redirect:/apps/";
	}

	@GetMapping("/apps/edit/{id}")
	public String showUpdateApp(@PathVariable("id") long id, Model model) {
		Optional<Appointment> appoint = appointmentService.findById(id);

		if (!appoint.isPresent())
			throw new IllegalArgumentException("Invalid appointment Id:" + id);
		model.addAttribute("appoint", appoint.get());
		return "apps/update-app";
	}

	@PostMapping("/apps/edit/{id}")
	public String updateApp(@PathVariable("id") long id, @RequestParam(value = "action", required = true) String action,
			Appointment appoint, Model model) {
		if (!action.equals("Cancel")) {
			appointmentService.save(appoint);
			model.addAttribute("apps", appointmentService.findAll());
		}
		return "redirect:/apps/";
	}

	@GetMapping("/apps/del/{id}")
	public String deleteApp(@PathVariable("id") long id, Model model) {
		Appointment app = appointmentService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		appointmentService.delete(app);
		model.addAttribute("users", appointmentService.findAll());
		return "apps/index";
	}
}
