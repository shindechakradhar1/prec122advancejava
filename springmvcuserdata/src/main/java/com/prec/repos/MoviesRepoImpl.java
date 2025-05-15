package com.prec.repos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prec.components.SessionFactoryBean;
import com.prec.entities.Movie;

@Repository
public class MoviesRepoImpl implements MoviesRepo{

	@Autowired
	private SessionFactoryBean sessionFactoryBean;
	
	@Override
	public String addMovies(Movie movie) {
		Session session = sessionFactoryBean.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(movie);
		transaction.commit();
		session.close();
		return "Movie Record Stored Successfully..";
	}

	@Override
	public List<Movie> fetchAll() {
		Session session = sessionFactoryBean.getSessionFactory().openSession();
		List<Movie> movieList= session.createQuery("FROM Movie", Movie.class).list();
		session.close();
		return movieList;
	}

	@Override
	public Movie fetchMovies(int id) {
		Movie movie=null;
		Session session = sessionFactoryBean.getSessionFactory().openSession();
		
		movie=session.get(Movie.class, id);
		session.close();
		return movie;
	}

	@Override
	public String updateMovies(Movie movie) {
		Session session = sessionFactoryBean.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(movie);
		transaction.commit();
		session.close();
		return "Movie Record updated successfully..";
	}

	@Override
	public String deleteMovies(int id) {
		Session session = sessionFactoryBean.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
//		session.delete(session.get(Movie.class, id));
		session.delete(fetchMovies(id));
		transaction.commit();
		session.close();
		return "Record Deleted Successfully..";
	}
	
}
