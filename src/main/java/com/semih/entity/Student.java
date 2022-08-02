package com.semih.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Student extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "user_type")
	@Enumerated(EnumType.STRING)
	private UserType userType = UserType.STUDENT;

	@ManyToMany(mappedBy = "studentList")
	private List<Book> books;

	public Student(String username, String password) {
		super(username, password);
	}
}
