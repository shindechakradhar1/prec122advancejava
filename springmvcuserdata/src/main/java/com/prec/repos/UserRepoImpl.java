package com.prec.repos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prec.components.SessionFactoryBean;
import com.prec.entities.Hobby;
import com.prec.entities.Movie;
import com.prec.entities.User;

@Repository
public class UserRepoImpl implements UserRepo {

	@Autowired
	private SessionFactoryBean sessionFactoryBean;
	
	@Override
	public String addUser(User user) {
		try(Session session=sessionFactoryBean.getSessionFactory().openSession();){
			Transaction transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			return "User Data Added Successfully";
		}
		
	}

	@Override
	public List<User> fetchAllUser() {
		List<User> userList;
		List<Movie> movieList=null;
		Set<Hobby> hobbySet=null;
		try(
				Session session=sessionFactoryBean.getSessionFactory().openSession();
			){
//			userList = session.createQuery("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.hobbiesSet h LEFT JOIN FETCH u.movieList", User.class).list();
			userList = session.createQuery("SELECT u FROM User u", User.class).list();
			for(User user:userList) {
				movieList = new ArrayList<>(user.getMovieList());
				hobbySet = new HashSet<>(user.getHobbiesSet());
				user.setHobbiesSet(hobbySet);
				user.setMovieList(movieList);
			}
		}
		return userList;
	}

	@Override
	public User fetchUser(int id) {
		List<Movie> movieList=null;
		Set<Hobby> hobbySet=null;
		try(
				Session session=sessionFactoryBean.getSessionFactory().openSession();
			){
//			return session.get(User.class, id);
//			Query<User> query = session.createQuery("SELECT u FROM User u LEFT JOIN FETCH u.hobbiesSet LEFT JOIN FETCH DISTINCT u.movieList WHERE u.id=:number", User.class);
			Query<User> query = session.createQuery("SELECT u FROM User u WHERE u.id=:number", User.class);
			query.setParameter("number", id);
			User user=query.getSingleResult();
			movieList = new ArrayList<>(user.getMovieList());
			hobbySet = new HashSet<>(user.getHobbiesSet());
			user.setHobbiesSet(hobbySet);
			user.setMovieList(movieList);
			return user;
		}
	}

	@Override
	public String updateUser(User user) {
		try(
				Session session=sessionFactoryBean.getSessionFactory().openSession();
			){
			Transaction transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
		}
		
		return "User record Updated Successfully..";
	}

	@Override
	public String deleteUser(int id) {
		try(
				Session session=sessionFactoryBean.getSessionFactory().openSession();
			){
			Transaction transaction = session.beginTransaction();
			session.delete(fetchUser(id));
			transaction.commit();
		}
		
		return "User record Deleted Successfully..";
	}

}
