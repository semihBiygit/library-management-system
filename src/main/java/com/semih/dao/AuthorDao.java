package com.semih.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;

import com.semih.entity.Author;

import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class AuthorDao implements Crud<Author> {

	@Override
	public void create(Author entity) {
		Session session = null;

		try {
			session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Author data is added to DB.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding author data.");
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(long id) {
		Session session = null;
		try {
			Author deleteAuthor = find(id);
			if (deleteAuthor != null) {
				session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(deleteAuthor);
				session.getTransaction().commit();
				System.out.println("Author data is deleted from DB.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while deleting Author data.");
		} finally {
			session.close();
		}

	}

	@Override
	public void update(long id, Author entity) {
		Session session = null;
		try {
			Author author = find(id);
			if (author != null) {
				author.setFirstName(entity.getFirstName());
				author.setLastName(entity.getLastName());
				author.setBooks(entity.getBooks());
				author.setId(entity.getId());

				session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(author);
				session.getTransaction().commit();
				System.out.println("Author data is succesfully updated.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while updating Author data.");
		} finally {
			session.close();
		}

	}

	@Override
	public List<Author> listAll() {

		Session session = databaseConnectionHibernate();
		String query = "select author from Author as author";
		TypedQuery<Author> typedQuery = session.createQuery(query, Author.class);
		List<Author> authorList = typedQuery.getResultList();

		for (Author author : authorList) {
			System.out.println(author);
		}
		return authorList;
	}

	@Override
	public Author find(long id) {

		Session session = databaseConnectionHibernate();
		Author author;

		try {
			author = session.find(Author.class, id);

			if (author != null) {
				System.out.println("Author fount : " + author);
				return author;
			} else {
				System.out.println("Author not found!");
				return author;
			}

		} catch (Exception e) {
			System.out.println("Some problem has accured author find operation.");
		} finally {
			session.close();
		}
		return null;
	}
	
	public Optional<Author> findByName(String firstname, String lastname) {

		Session session = databaseConnectionHibernate();
		Author author;
		String hql = "select a from Author as a where a.firstName =:fn and a.lastName =:ln ";
		@SuppressWarnings("deprecation")
		Query query = session.createQuery(hql);
		query.setParameter("fn", firstname);
		query.setParameter("ln", lastname);
		try {
			author = (Author) query.getSingleResult();
			return Optional.of(author);
		} catch (Exception e) {
			System.out.println("findByName error");
			return Optional.empty();
		}
	}

}
