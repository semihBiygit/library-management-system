package com.semih.controller;

import com.semih.entity.Student;
import com.semih.service.StudentService;
import com.semih.util.MyUtil;

public class StudentController {

	StudentService studentService;

	public StudentController() {
		super();
		this.studentService = new StudentService();
	}

	public void create() {

		String username = MyUtil.readString("Please enter username ");
		String password = MyUtil.readString("Please enter password ");

		Student stu = new Student(username, password);

		studentService.create(stu);
	}

	public void delete() {

		long id = MyUtil.readInt("Enter the ID of the student you want to be deleted.");
		studentService.delete(id);

	}

	public void update() {
		long id = MyUtil.readInt("Please enter the student ID that you want to update. ");

		String username = MyUtil.readString("Please enter the new student username. ");
		String password = MyUtil.readString("Please enter the new student password. ");

		Student updatedStudent = new Student(username, password);
		studentService.update(id, updatedStudent);

	}
	
	public void listAll() {
		studentService.listAll();
	}
	
	public Student find() {
		int id = MyUtil.readInt("Please enter the id of the student that you want to find.");
		return studentService.find(id);
	}

}
