package com.semih.service;

import com.semih.dao.BookDao;
import com.semih.entity.Book;

public class BookService implements Crud<Book> {

	private BookDao bookDao;

	public BookService() {
		super();
		this.bookDao = new BookDao();
	}

	@Override
	public void create(Book entity) {
		bookDao.create(entity);

	}

	@Override
	public void delete(long id) {
		bookDao.delete(id);

	}

	@Override
	public void update(long id, Book entity) {
		bookDao.update(id, entity);

	}

	@Override
	public void listAll() {
		bookDao.listAll();

	}

	@Override
	public Book find(long id) {
		Book stu = bookDao.find(id);

		return stu;
	}

}
