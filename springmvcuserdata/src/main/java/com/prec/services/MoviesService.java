package com.prec.services;

import java.util.List;

import com.prec.entities.Movie;

public interface MoviesService {
	String addMovies(Movie movie);
	
	List<Movie> fetchAll();
	
	Movie fetchMovies(int id);
	
	String updateMovies(Movie movie);
	
	String deleteMovies(int id);
}
