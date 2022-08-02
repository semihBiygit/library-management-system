package com.semih.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.semih.entity.Admin;
import com.semih.entity.Author;
import com.semih.entity.Book;
import com.semih.entity.BookDetail;
import com.semih.entity.Student;
import com.semih.entity.User;



public class HibernateSession {

	private static final SessionFactory sessionFactory = sessionFactoryHibernate();

	private static SessionFactory sessionFactoryHibernate() {
		SessionFactory factory = null;
		try {
			Configuration config = new Configuration(); // creating instance

			config.addAnnotatedClass(User.class);
			config.addAnnotatedClass(Admin.class);
			config.addAnnotatedClass(Student.class); 
			config.addAnnotatedClass(Book.class); 
			config.addAnnotatedClass(BookDetail.class); 
			config.addAnnotatedClass(Author.class); 

			factory = config.configure("hibernate.cfg.xml").buildSessionFactory();

		} catch (Exception ex) {
			ex.getMessage();
		}
		return factory;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
