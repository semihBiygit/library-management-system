package com.semih.service;

import com.semih.dao.AdminDao;
import com.semih.entity.Admin;

public class AdminService implements Crud<Admin> {

	private AdminDao adminDao;

	public AdminService() {
		super();
		this.adminDao = new AdminDao();
	}

	@Override
	public Admin create(Admin entity) {
		adminDao.create(entity);
		return entity;

	}

	@Override
	public void delete(long id) {
		adminDao.delete(id);

	}

	@Override
	public void update(long id, Admin entity) {
		adminDao.update(id, entity);

	}

	@Override
	public void listAll() {
		adminDao.listAll();

	}

	@Override
	public Admin find(long id) {
		Admin stu = adminDao.find(id);

		return stu;
	}

}
