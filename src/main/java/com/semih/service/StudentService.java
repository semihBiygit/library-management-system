package com.semih.service;

import java.util.List;
import java.util.Optional;

import com.semih.dao.StudentDao;
import com.semih.entity.Student;

public class StudentService implements Crud<Student> {

	private StudentDao studentDao;

	public StudentService() {
		super();
		this.studentDao = new StudentDao();
	}

	@Override
	public Student create(Student entity) {
		studentDao.create(entity);
		return entity;

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
	public List<Student> listAll() {
		return studentDao.listAll();

	}

	@Override
	public Student find(long id) {
		Student stu = studentDao.find(id);

		return stu;
	}

	public Optional<Student> findByUsername(String username) {

		return studentDao.findByUsername(username);
	}

}
