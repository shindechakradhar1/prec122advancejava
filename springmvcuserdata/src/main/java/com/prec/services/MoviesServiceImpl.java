package com.prec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prec.entities.Movie;
import com.prec.repos.MoviesRepo;

@Service
public class MoviesServiceImpl implements MoviesService{

	@Autowired
	private MoviesRepo repo;
	
	@Override
	public String addMovies(Movie movie) {
		return repo.addMovies(movie);
	}

	@Override
	public List<Movie> fetchAll() {
		return repo.fetchAll();
	}

	@Override
	public Movie fetchMovies(int id) {
		return repo.fetchMovies(id);
	}

	@Override
	public String updateMovies(Movie movie) {
		return repo.updateMovies(movie);
	}

	@Override
	public String deleteMovies(int id) {
		return repo.deleteMovies(id);
	}
	
}
