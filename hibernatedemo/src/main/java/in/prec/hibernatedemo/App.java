package in.prec.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Student student = new Student();
    	student.setAge(20);
    	student.setName("Ayush");
    	Configuration config = new Configuration();
//    	config.configure("in/prec/hibernatedemo/configurations/hibernate.cfg.xml");
    	config.configure();
    	SessionFactory sessionFactory = config.buildSessionFactory();
    	Session session= sessionFactory.openSession();
    	Transaction transaction= session.beginTransaction();
    	
//    	session.save(student);
    	student=session.get(Student.class, 2);
//    	student.setName("Vaibhav");
//    	session.saveOrUpdate(student);
    	session.delete(student);
    	transaction.commit();
    	session.close();
    	sessionFactory.close();
    	
    	
    }
}
