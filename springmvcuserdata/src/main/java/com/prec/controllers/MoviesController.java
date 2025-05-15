package com.prec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prec.entities.Movie;
import com.prec.services.MoviesService;

@Controller
@RequestMapping("/movies")
public class MoviesController {
	
	@Autowired
	private MoviesService service;

	@GetMapping("")
	public String getMoviesHomePage() {
		return "movies/movieshome";
	}
	
	@GetMapping("/new")
	public String newMovies(Model model) {
		model.addAttribute("movie", new Movie());
		return "movies/newmovies";
	}
	
	@PostMapping("/reg")
	public String addMovies(@ModelAttribute Movie movie, Model model) {
		
		model.addAttribute("msg", service.addMovies(movie));
		return "success";
	}
	
	@GetMapping("/all")
	public String getAllMovies(Model model) {
		
		model.addAttribute("moviesList", service.fetchAll());
		
		return "movies/allmovies";
	}
	
	@GetMapping("/update/id/{id}")
	public String updateMovies(@PathVariable int id, Model model) {
		model.addAttribute("movie",service.fetchMovies(id));
		return "movies/updatemovies";
	}
	@GetMapping("/delete/id/{id}")
	public String deleteMovies(@PathVariable int id, Model model) {
		model.addAttribute("msg",service.deleteMovies(id));
		return "success";
	}
	
	@PostMapping("/update")
	public String updateMovies(@ModelAttribute Movie movie, Model model) {
		model.addAttribute("msg", service.updateMovies(movie));
		return "success";
	}
}
