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
import org.springframework.web.servlet.ModelAndView;

import co.edu.icesi.ci.thymeval.model.User;
import co.edu.icesi.ci.thymeval.model.UserGender;
import co.edu.icesi.ci.thymeval.model.UserType;
import co.edu.icesi.ci.thymeval.service.UserService;

@Controller
public class UserController {

	private UserService userService;
	private UserGender[] userGenders;
	private UserType[] userTypes;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;

		userGenders = userService.getGenders();
		userTypes = userService.getTypes();

	}

	@GetMapping("/users/")
	public String indexUser(Model model) {
		model.addAttribute("users", userService.findAll());
		return "users/index";
	}

	@GetMapping("/users/add")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("genders", userGenders);
		model.addAttribute("types", userTypes);
		return "users/add-user";
	}

	@PostMapping("/users/add")
	public String saveUser(@Valid User user, BindingResult bindingResult, Model model,
			@RequestParam(value = "action", required = true) String action) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("genders", userGenders);
				model.addAttribute("types", userTypes);
				return "users/add-user";
			}
			userService.save(user);
		}
		return "redirect:/users/";
	}

	@GetMapping("/users/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Optional<User> user = userService.findById(id);
		if (user == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);
		model.addAttribute("user", user.get());
		model.addAttribute("genders", userService.getGenders());
		model.addAttribute("types", userService.getTypes());
		return "users/update-user";
	}

	@PostMapping("/users/edit/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {
		if (action != null && !action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("genders", userGenders);
				model.addAttribute("types", userTypes);
				return "users/update-user";
			}
			userService.save(user);
			// model.addAttribute("users", userService.findAll());
		}
		return "redirect:/users/";
	}

	@GetMapping("/users/del/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		User user = userService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		userService.delete(user);
		// model.addAttribute("users", userService.findAll());
		return "users/index";
	}
}
