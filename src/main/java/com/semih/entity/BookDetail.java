package com.semih.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class BookDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String title;
	@Column(name = "is_borrowed")
	private boolean isBorrowed;
	@Column(name = "book_borrowed_date")
	private LocalDate borrowDate;
	@Column(name = "return_date")
	private LocalDate bookReturnDate;
	
	@OneToOne(mappedBy = "detail")
	private Book book;

}
