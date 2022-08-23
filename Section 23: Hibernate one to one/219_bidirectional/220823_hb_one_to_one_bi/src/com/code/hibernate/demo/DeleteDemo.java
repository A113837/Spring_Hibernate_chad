package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Instructor;
import com.code.hibernate.demo.entity.InstructorDetail;
import com.code.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		//create session factor
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			

			
			//start a transaction
			session.beginTransaction();
			
			//get instructor by primary key/id
			
			//delete the instructors
			int theId=1;
			Instructor tempInstructor =
					session.get(Instructor.class, theId);
			
			System.out.println("Found instructor: "+tempInstructor);
			
			//delete the instructors
			if(tempInstructor != null) {
				
				System.out.println("Deleting: "+tempInstructor);
				
				//NOTE: will also delete associated "details"
				//because CascadeType.ALL
				session.delete(tempInstructor);
			}
			
			//commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		

	}

}
