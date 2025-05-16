package com.prec.controllers;

import java.beans.PropertyEditorSupport;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prec.entities.Hobby;
import com.prec.entities.Movie;
import com.prec.entities.User;
import com.prec.services.HobbiesService;
import com.prec.services.MoviesService;
import com.prec.services.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private MoviesService moviesService;
	
	@Autowired
	private HobbiesService hobbiesService;
	
	@Autowired
	private UserService userService;
	
	@InitBinder
	public void idToMovie(WebDataBinder binder) {
		binder.registerCustomEditor(Movie.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String id) {
				Movie movie = moviesService.fetchMovies(Integer.parseInt(id));
				setValue(movie);
			}
		});
	}
	
	@InitBinder
	public void idToHobby(WebDataBinder binder) {
		binder.registerCustomEditor(Hobby.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String id) {
				Hobby hobby = hobbiesService.fetchHobby(Integer.parseInt(id));
				setValue(hobby);
			}
		});
	}
	
	@GetMapping("")
	public String getUsersHome() {
		return "user/userhome";
	}
	@GetMapping("/new")
	public String newUsers(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("movieList", moviesService.fetchAll());
		model.addAttribute("hobbiesList", hobbiesService.fetchAll());
		return "user/newusers";
	}
	
	@PostMapping("/reg")
	public String addUser(@ModelAttribute User user, Model model) {
//		System.out.println(user);
		String msg=userService.addUser(user);
		model.addAttribute("msg", msg);
		return "success";
	}
	
	@GetMapping("/all")
	public String allUsers(Model model) {
		List<User> userList=userService.fetchAllUser();
		model.addAttribute("users", userList);
		System.out.println(userList);
		return "user/allusers";
	}
	
	@GetMapping("/update/id/{id}")
	public String getUser(@PathVariable int id, Model model) {
		model.addAttribute("user", userService.fetchUser(id));
		model.addAttribute("movieList", moviesService.fetchAll());
		model.addAttribute("hobbiesList", hobbiesService.fetchAll());
		return "user/updateusers";
	}
	
	@PostMapping("/update")
	public String udpateUser(@ModelAttribute User user, Model model) {
		String msg=userService.updateUser(user);
		model.addAttribute("msg", msg);
		return "success";
	}
	
	@GetMapping("/delete/id/{id}")
	public String deleteUser(@PathVariable int id, Model model) {
		model.addAttribute("msg", userService.deleteUser(id));
		return "success";
	}
}
