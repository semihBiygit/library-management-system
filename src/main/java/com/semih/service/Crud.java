package com.semih.service;

public interface Crud<T> {

	public T create(T entity);

	public void delete(long id);

	public void update(long id, T entity);

	public void listAll();

	public T find(long id);

}
