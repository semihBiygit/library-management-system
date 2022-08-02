package com.semih.service;

import com.semih.dao.AuthorDao;
import com.semih.entity.Author;

public class AuthorService implements Crud<Author> {

	private AuthorDao authorDao;

	public AuthorService() {
		super();
		this.authorDao = new AuthorDao();
	}

	@Override
	public void create(Author entity) {
		authorDao.create(entity);

	}

	@Override
	public void delete(long id) {
		authorDao.delete(id);

	}

	@Override
	public void update(long id, Author entity) {
		authorDao.update(id, entity);

	}

	@Override
	public void listAll() {
		authorDao.listAll();

	}

	@Override
	public Author find(long id) {
		Author stu = authorDao.find(id);

		return stu;
	}

}
