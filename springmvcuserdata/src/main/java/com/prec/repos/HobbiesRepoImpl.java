package com.prec.repos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prec.components.SessionFactoryBean;
import com.prec.entities.Hobby;

@Repository
public class HobbiesRepoImpl implements HobbiesRepo {
	
	@Autowired
	private SessionFactoryBean sessionFactoryBean;

	@Override
	public String addHobbies(Hobby hobby) {
		
		
		Session session = sessionFactoryBean.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(hobby);
		
		transaction.commit();
		session.close();
		return "Hobbies Added Successfully..";
	}

	@Override
	public List<Hobby> fetchAll() {
		
		Session session = sessionFactoryBean.getSessionFactory().openSession();
//		Transaction transaction = session.beginTransaction();
		
		List<Hobby> hobbiesList=session.createQuery("SELECT h FROM Hobby h", Hobby.class).list();
		
//		transaction.commit();
		session.close();
		return hobbiesList;
	}

	@Override
	public Hobby fetchHobby(int id) {
		Hobby hobby=null;
		Session session = sessionFactoryBean.getSessionFactory().openSession();
		hobby=session.get(Hobby.class, id);
		session.close();
		return hobby;
	}

	@Override
	public String updateHobbies(Hobby hobby) {
		Session session = sessionFactoryBean.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(hobby);
		transaction.commit();
		session.close();
		return "Hobbies record Updated Successfully..";
	}

	@Override
	public String deleteHobbies(int id) {
		Session session = sessionFactoryBean.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(fetchHobby(id));
		transaction.commit();
		session.close();
		
		return "Hobbies Record Deleted Successfully..";
	}

	
}
