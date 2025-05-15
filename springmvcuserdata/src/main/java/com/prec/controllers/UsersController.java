package com.prec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prec.entities.Movie;

@Controller
@RequestMapping("/users")
public class UsersController {

	@GetMapping("")
	public String getUsersHome() {
		return "user/userhome";
	}
	@GetMapping("/new")
	public String newUsers(Model model) {
		model.addAttribute("movie", new Movie());
		return "user/newusers";
	}
}
