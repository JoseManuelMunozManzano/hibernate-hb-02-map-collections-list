package com.neimerc.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.neimerc.hibernate.demo.entity.Student;

public class CreateStudentImagesListDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the object
			Student tempStudent = new Student("José Manuel", "Muñoz Manzano", "aaaaa@a.com");
			List<String> theImages = tempStudent.getImages();
			
			theImages.add("photo1.jpg");
			theImages.add("photo2.jpg");
			theImages.add("photo3.jpg");
			theImages.add("photo4.jpg");
			theImages.add("photo4.jpg");  // Duplicate, no problem!

			// start a transaction
			session.beginTransaction();

			// save the object
			System.out.println("Saving the student and images...");
			session.persist(tempStudent);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			// clean up code
			session.close();
			factory.close();
		}
	}

}
