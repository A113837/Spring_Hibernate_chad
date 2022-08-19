package com.code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factor
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//use the session object to sava Java object
			
			//start a transaction
			session.beginTransaction();
			
			
			//query students
			List<Student> theStudents = session.createQuery("from Student").list();
			
			//display the students
			displayStudents(theStudents);
			
			//query students; lastName='Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").list();
		
			//display the students
			System.out.println("\n\nStudents who have last name of Doe");
			displayStudents(theStudents);
			
			//query students: lastName='Doe' OR firstName='Daffy'
			theStudents = session.createQuery("from Student s where"
					+" s.lastName='Doe' OR s.firstName='Daffy'").list();
			
			System.out.println("\n\nStudents who have lastName='Doe' OR firstName='Daffy'");
			displayStudents(theStudents);
			
			//query students where eamil LIKE '%luv2code.com'
			theStudents = session.createQuery("from Student s where"
					+" s.email LIKE '%luv2code.com'").list();
			
			System.out.println("\n\nStudents who have email ends with @luv2code.com");
			displayStudents(theStudents);
			
			//query students where emial like gmail.com
			theStudents = session.createQuery("from Student s where"
					+ " s.email LIKE '%gmail.com'").list();
			
			System.out.println("\n\nStudents who have email ends with @gmail.com");
			displayStudents(theStudents);
			
			
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("done");
		}
		finally {
			factory.close();
		}
		

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents)
		{
			System.out.println(tempStudent);
		}
	}

}
