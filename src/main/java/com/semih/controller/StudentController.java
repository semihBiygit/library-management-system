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

}
