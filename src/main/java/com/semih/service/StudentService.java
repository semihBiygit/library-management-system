package com.semih.service;

import com.semih.dao.StudentDao;
import com.semih.entity.Student;

public class StudentService implements Crud<Student> {

	private StudentDao studentDao;

	public StudentService() {
		super();
		this.studentDao = new StudentDao();
	}

	@Override
	public void create(Student entity) {
		studentDao.create(entity);

	}

	@Override
	public void delete(long id) {
		studentDao.delete(id);

	}

	@Override
	public void update(long id, Student entity) {
		studentDao.update(id, entity);

	}

	@Override
	public void listAll() {
		studentDao.listAll();

	}

	@Override
	public Student find(long id) {
		Student stu = studentDao.find(id);

		return stu;
	}

}
