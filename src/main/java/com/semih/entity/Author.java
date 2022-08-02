package com.semih.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "first_name")
	private String firtName;
	@Column(name = "last_name")
	private String lastName;
	@OneToMany(mappedBy = "author")
	private List<Book> books;

	public Author(String firtName, String lastName) {
		super();
		this.firtName = firtName;
		this.lastName = lastName;
		this.books = new ArrayList<Book>();
	}

}
