package in.prec.hibernatemapping;

import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import in.prec.hibernatemapping.entities.Address;
import in.prec.hibernatemapping.entities.Department;
import in.prec.hibernatemapping.entities.Student;
import in.prec.hibernatemapping.entities.Subject;
import in.prec.hibernatemapping.entities.Teacher;
import inn.prec.hibernatemapping.dtos.StudentAreaCount;
import inn.prec.hibernatemapping.dtos.StudentCountByCity;


public class App {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Configuration configuration = new Configuration();
		configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/precmappingdemo");
		configuration.setProperty("hibernate.connection.username", "root");
		configuration.setProperty("hibernate.connection.password", "root");
		configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		configuration.setProperty("hibernate.hbm2ddl.auto", "update");
		configuration.setProperty("hibernate.show_sql", "true");
		configuration.setProperty("hibernate.format_sql", "true");
//		configuration.addAnnotatedClass(Student.class);
//		configuration.addAnnotatedClass(Address.class);
//		configuration.addAnnotatedClass(Department.class);
		configuration.addAnnotatedClass(Teacher.class);
		configuration.addAnnotatedClass(Subject.class);
		configuration.addAnnotatedClass(Department.class);
		configuration.addAnnotatedClass(Student.class);
		configuration.addAnnotatedClass(Address.class);
		
//		------------------------------------------------------------------------------------
//		Setting up Department and Teacher Objects
		
//		Department dept= new Department();
//		dept.setDepartmentName("Comp Engg.");
//		Teacher teacher1 = new Teacher("Kharde",LocalDate.now(), dept);
//		Teacher teacher2 = new Teacher();
//		teacher2.setTeacherName("Kote");
//		teacher2.setTeacherJoinigDate(LocalDate.now());
//		teacher2.setDepartment(dept);
//		
//		------------------------------------------------------------------------------------
//		Setting up Subject object
		
//		List<Subject> subjectList = new ArrayList<>();
//		Subject subject1 = new Subject("JAVA");
//		Subject subject2 = new Subject("HTML");
//		subjectList.add(subject1);
//		subjectList.add(subject2);
//		Department dept =new Department();
//		dept.setDepartmentName("Comp. Engg");
//		Teacher teacher = new Teacher("Shinde", LocalDate.now(), subjectList, dept);
		
//		teacher1.setSubjectList(subjectList);
//		teacher2.setSubjectList(subjectList);
//		Student student = new Student("Sarika",21,LocalDate.of(2000, 6, 8),new Address("Loni", "A Nagar", 41001), null);
		
//		Teacher teacher = new Teacher();
//		
//		teacher.setTeacherName("Shinde");
//		teacher.setTeacherJoinigDate(LocalDate.now());
//		teacher.setSubjectList(subjectList);
//		
		
//		Address address = new Address(2, "Rahata", "A. Nagar", 413740);
//		Student student = new Student(2, "Sakshi", 20, LocalDate.of(2004, 9, 15), address);

//		------------------------------------------------------------------------------------
//		Hibernate Framework setup
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.getTransaction();

		transaction.begin();

//		------------------------------------------------------------------------------------
//		Crud Operations
		
//        session.save(student);
//		Student student1 = session.get(Student.class, 2);
//		student1.getAddress().setAddressArea("Shrirampur");
//		session.saveOrUpdate(student1);
////		System.out.println(student1);
//		session.save(teacher1);
//		session.save(teacher2);
//		session.save(dept);
//		session.save(subject1);
//		session.save(subject2);
//		Teacher teacher = session.get(Teacher.class, 1);
//		teacher.getSubjectList().get(1).setSubjectName("Thymleaf");
//		session.save(teacher1);
//		session.save(teacher2);
//		student.setDepartment(session.get(Department.class, 1));
//		session.save(student);
//		Student result=session.get(Student.class, 0);
//		System.out.println(result);
//		Hbernate Query Language
//		List<Student> studentList=session.createQuery("FROM Student", Student.class).getResultList();
		
		
//		studentList.forEach(System.out::println);
//		Address address=studentList.get(0).getAddress();
//		System.out.println(address);
		
//		System.out.println(studentList.get(0).getDepartment());
		
//		System.out.println(session.get(Student.class, 1));
//		System.out.println(session.get(Student.class, 2));
//		System.out.println(session.get(Student.class, 3));
//		System.out.println(session.get(Student.class, 4));
//		System.out.println(session.get(Student.class, 1));
//		System.out.println(session.get(Student.class, 1));
		
//		------------------------------------------------------------------------------------
//		NamedQuery Example
		
//		Query<Student> createNamedQuery = session.createNamedQuery("Student.fetchByName", Student.class);
//		createNamedQuery.setParameter("name", "Sarika");	
//		List<Student> studentList=createNamedQuery.getResultList();
//		studentList.forEach(System.out::println);
		
//		------------------------------------------------------------------------------------
//		HQL OR GROUP By example
		
//		Query<Student> createQuery = session.createQuery("SELECT s FROM Student s LEFT JOIN FETCH s.address a  where a.addressArea=:area", Student.class);
//		Query<Object[]> createQuery = session.createQuery("SELECT count(s), a.addressArea FROM Student s JOIN  s.address a GROUP BY a.addressArea", Object[].class);
//		createQuery.setParameter("area", "Loni");		
//		List<Student> studentList=createQuery.getResultList();
		
		
//		List<Object[]> studentList=createQuery.getResultList();
//		for(Object[] element:studentList) {
//			System.out.println(element[0]);
//			System.out.println(element[1]);
//		}
		
		
//		------------------------------------------------------------------------------------
//		DTO Example
		
		
//		List<StudentAreaCount> studentList = session.createQuery("SELECT new inn.prec.hibernatemapping.dtos.StudentAreaCount(count(s), a.addressArea) FROM Student s JOIN  s.address a GROUP BY a.addressArea", StudentAreaCount.class).getResultList();
		
//		List<StudentAreaCount> studentList=createQuery.getResultList();
		
//		studentList.forEach(System.out::println);
		
//		Query<StudentCountByCity> query = session.createQuery("SELECT new inn.prec.hibernatemapping.dtos.StudentCountByCity(COUNT(s), a.addressCity) FROM Student s JOIN s.address a GROUP BY a.addressCity", StudentCountByCity.class);
//		
//		List<StudentCountByCity> countList=query.getResultList();
//		
//		countList.forEach(System.out::println);
		
		
//		------------------------------------------------------------------------------------
//		Native query example
		
//		session.createNativeQuery("INSERT INTO department(departmentName) VALUES(:dName)")
//		.setParameter("dName", "IT")
//		.executeUpdate();
//		transaction.commit();
		
		
//		------------------------------------------------------------------------------------
//		NamedNativeQuery Exmaple
		
//		session.createNamedQuery("Department.Insert").setParameter("dName", "E&TC").executeUpdate();

		
//		------------------------------------------------------------------------------------
//		Criteria Queries
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Department> criteriaQuery = criteriaBuilder.createQuery(Department.class);
		Root<Department> department = criteriaQuery.from(Department.class);
		
		Join<Object, Object> department_teacher = department.join("teacherSet");
		
		System.out.println("Enter column Name: ");
		String coloumnName = scanner.next();
		
		scanner.nextLine();
		System.out.println("Enter Value: ");
		String value = scanner.nextLine();
		
		System.out.println("Enter Choice:");
		System.out.println("1: Equal");
		System.out.println("2: Greater");
		int choice = scanner.nextInt();
		criteriaQuery.select(department);
		if(choice==1)
			criteriaQuery.where(criteriaBuilder.equal(department_teacher.get(coloumnName), value));
		if(choice==2)
			criteriaQuery.where(criteriaBuilder.greaterThan(department.get(coloumnName), value));
		
		session.createQuery(criteriaQuery).getResultList().forEach(System.out::println);
		
		session.close();
		sessionFactory.close();
		scanner.close();
	}
}
