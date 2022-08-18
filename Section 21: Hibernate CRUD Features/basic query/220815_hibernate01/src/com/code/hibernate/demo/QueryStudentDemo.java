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
			for(Student tempStudent : theStudents)
			{
				System.out.println(tempStudent);
			}
		

			//commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		

	}

}
