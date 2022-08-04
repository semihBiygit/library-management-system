package com.semih.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.semih.entity.Author;
import com.semih.entity.Book;
import com.semih.entity.BookDetail;
import com.semih.entity.Student;
import com.semih.service.AuthorService;
import com.semih.service.BookDetailService;
import com.semih.service.BookService;
import com.semih.util.MyUtil;

public class BookController {
	BookService bookService;
	BookDetailService detailService;
	AuthorService authorService;
	Author author;

	public BookController() {
		super();
		this.detailService = new BookDetailService();
		this.bookService = new BookService();
		this.authorService = new AuthorService();
	}

	public void createBook() {
		String title = MyUtil.readString("Please enter the name of the book you will add ");

		BookDetail detail = new BookDetail();
		Book book = new Book();

		detail.setTitle(title);
		BookDetail bookDetailWithId = detailService.create(detail);

		String firstName = MyUtil.readString("Please enter the firstname of the author");
		String lastName = MyUtil.readString("Please enter the  lastname of the author");

		Optional<Author> optAuthor = authorService.findByName(firstName, lastName);
		if (optAuthor.isEmpty()) {
			author = new Author(firstName, lastName);
			authorService.create(author);
		} else {
			author = optAuthor.get();
			System.err.println("Writer is available in db");
		}
		book.setAuthor(author);
		book.setDetail(bookDetailWithId);
		bookService.create(book);

	}

	public void delete() {

		long id = MyUtil.readInt("Enter the id of the book you want to be deleted.");
		bookService.delete(id);

	}

	public void update() {
		long id = MyUtil.readInt("Please enter the book ID that you want to update");
		// String title = MyUtil.readString("Please enter the book name you want to
		// update");

		Book updatedBook = new Book();
		bookService.update(id, updatedBook);

	}

	public void listAll() {
		bookService.listAll().forEach(book-> System.out.println(book));;
	}

	public void listBorrowedBooks() {

		bookService.listAll().stream().filter(book -> book.getDetail().isBorrowed() == true)
				.forEach(book -> System.out.println(book));

	}

	public Book find() {
		int id = MyUtil.readInt("Please enter the id of the book that you want to find");
		return bookService.find(id);
	}

	public void borrowBook(Student student) {

		List<Book> books = bookService.listAll().stream().filter(book -> !book.getDetail().isBorrowed())
				.collect(Collectors.toList());

		books.forEach(book -> System.out.println(book.getId() + " " + book.getDetail().getTitle()));

		int bookId = MyUtil.readInt("Please enter the id of the book you want to rent.");
		int duration = MyUtil.readInt("How many days will you rent?");

		Book borrowBook = bookService.find(bookId);
		LocalDate date = LocalDate.now();
		borrowBook.getDetail().setBorrowDate(date);
		borrowBook.getDetail().setBookReturnDate(date.plusDays(duration));
		borrowBook.getStudentList().add(student);
		borrowBook.getDetail().setBorrowed(true);
		student.getBooks().add(borrowBook);
		bookService.update(bookId, borrowBook);

	}

	public void returnBook(Student student) {

		List<Book> books = student.getBooks();
		books.forEach(book -> System.out.println(book.getId() + " " + book.getDetail().getTitle()));
		int bookId = MyUtil.readInt("Please enter the id of the book you want to return ");
		Book returnBook = bookService.find(bookId);
		returnBook.getDetail().setBorrowed(false);
		returnBook.getDetail().setBookReturnDate(LocalDate.now());
		bookService.update(bookId, returnBook);

	}
	
	public Student holderInfo() {
		int bookId = MyUtil.readInt("Please enter the id of the book you want to find out who owns it.");
		
		Book book = bookService.find(bookId);
		List<Student> studentBorrowedBook = book.getStudentList();
		return studentBorrowedBook.get(studentBorrowedBook.size()-1);
	}

}
