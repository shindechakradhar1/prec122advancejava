package com.prec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prec.controllers.entities.Movie;

@Controller
@RequestMapping("/movies")
public class MoviesController {

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
	public String addMovies(@ModelAttribute Movie movie) {
		System.out.println(movie);
		
		return "success";
	}
	
	@GetMapping("/all")
	public String getAllMovies() {
		return "movies/allmovies";
	}
}
