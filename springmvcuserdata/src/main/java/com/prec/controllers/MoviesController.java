package com.prec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/movies")
public class MoviesController {

	@GetMapping("/movies")
	public String getMoviesHomePage() {
		return "/movies/movieshome";
	}
}
