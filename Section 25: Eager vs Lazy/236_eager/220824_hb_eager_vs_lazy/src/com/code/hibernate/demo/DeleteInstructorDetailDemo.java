package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Instructor;
import com.code.hibernate.demo.entity.InstructorDetail;
import com.code.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

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
			
			//get instructor detail object
			int theId=3;
			InstructorDetail tempInstructorDetail =
					session.get(InstructorDetail.class, theId);
			
			//print the instructor detail
			System.out.println("tempInstructorDetail: "+tempInstructorDetail);
			
			//print the associated instructor
			System.out.println("the associated instructor: "+tempInstructorDetail.getInstructor());
			
			//now, delete the instructor detail
			System.out.println("Deleting temInstructorDetail: "+tempInstructorDetail);
			
			//remove the associated object reference
			//break bi-directional link
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(tempInstructorDetail);
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
		finally {
			
			//handle connection leak issue
			session.close();
			
			factory.close();
		}
		

	}

}
