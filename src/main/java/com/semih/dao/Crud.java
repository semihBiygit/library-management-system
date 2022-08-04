package com.semih.dao;

import java.util.List;

import org.hibernate.Session;

import com.semih.util.HibernateSession;


public interface Crud<T> {
	
	public void create(T entity);

	public void delete(long id);

	public void update(long id, T entity);

	public List<T> listAll();

	public T find(long id);

	default Session databaseConnectionHibernate() {
		return HibernateSession.getSessionFactory().openSession();
	}

}
