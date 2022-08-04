package com.semih.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

import com.semih.entity.Student;

import jakarta.persistence.TypedQuery;

public class StudentDao implements Crud<Student> {

	@Override
	public void create(Student entity) {
		Session session = null;

		try {
			session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Student data is added to DB.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding student data.");
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(long id) {
		Session session = null;
		try {
			Student deleteStudent = find(id);
			if (deleteStudent != null) {
				session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(deleteStudent);
				session.getTransaction().commit();
				System.out.println("Student data is deleted from DB.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while deleting Student data.");
		} finally {
			session.close();
		}

	}

	@Override
	public void update(long id, Student entity) {
		Session session = null;
		try {
			Student stu = find(id);
			if (stu != null) {
				stu.setUsername(entity.getUsername());
				stu.setPassword(entity.getPassword());
				stu.setBooks(entity.getBooks());

				session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(stu);
				session.getTransaction().commit();
				System.out.println("Student data is succesfully updated.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while updating Student data.");
		} finally {
			session.close();
		}

	}

	@Override
	public List<Student> listAll() {

		Session session = databaseConnectionHibernate();
		String query = "select stu from Student as stu";
		TypedQuery<Student> typedQuery = session.createQuery(query, Student.class);
		List<Student> studentList = typedQuery.getResultList();

		for (Student student : studentList) {
			System.out.println(student);
		}
		return studentList;
	}

	@Override
	public Student find(long id) {

		Session session = databaseConnectionHibernate();
		Student stu;

		try {
			stu = session.find(Student.class, id);

			if (stu != null) {
				System.out.println("Student fount : " + stu);
				return stu;
			} else {
				System.out.println("Student not found!");
				return stu;
			}

		} catch (Exception e) {
			System.out.println("Some problem has accured student find operation.");
		} finally {
			session.close();
		}
		return null;
	}

	public Optional<Student> findByUsername(String username) {
		
		Session session = databaseConnectionHibernate();
		Student student;
		String hql = "select stu from Student as stu where stu.username =:un";
		@SuppressWarnings("unchecked")
		SelectionQuery<Student> query = (SelectionQuery<Student>) session.createSelectionQuery(hql);
		query.setParameter("un", username);
		try {
			student = query.getSingleResult();
			return Optional.of(student);
		}catch(Exception e){
			return Optional.empty();
		}finally {
			session.close();
		}
	}

}
