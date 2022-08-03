package com.semih.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private Author author;

	@OneToOne(optional = false)
	@JoinColumn(name = "book_detail_id", referencedColumnName = "id")
	private BookDetail detail;

	@ManyToMany
	@JoinTable(name = "book_student", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
	private List<Student> studentList;

	public Book(Author author, BookDetail detail, List<Student> studentList) {
		super();
		this.author = author;
		this.detail = detail;
		this.studentList = studentList;
	}

}
