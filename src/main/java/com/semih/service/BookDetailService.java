package com.semih.service;

import java.util.List;

import com.semih.dao.BookDetailDao;
import com.semih.entity.BookDetail;

public class BookDetailService implements Crud<BookDetail> {

	private BookDetailDao bookDetailDao;

	public BookDetailService() {
		super();
		this.bookDetailDao = new BookDetailDao();
	}

	@Override
	public BookDetail create(BookDetail entity) {
		bookDetailDao.create(entity);
		return entity;

	}

	@Override
	public void delete(long id) {
		bookDetailDao.delete(id);

	}

	@Override
	public void update(long id, BookDetail entity) {
		bookDetailDao.update(id, entity);

	}

	@Override
	public List<BookDetail> listAll() {
		return bookDetailDao.listAll();


	}

	@Override
	public BookDetail find(long id) {
		BookDetail stu = bookDetailDao.find(id);

		return stu;
	}

}
