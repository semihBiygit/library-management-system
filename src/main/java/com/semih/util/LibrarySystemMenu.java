package com.semih.util;

import java.util.HashMap;
import java.util.Optional;

import com.semih.controller.BookController;
import com.semih.controller.StudentController;
import com.semih.entity.Student;

public class LibrarySystemMenu {

	StudentController studentController;
	BookController bookController;

	public LibrarySystemMenu() {
		super();
		this.studentController = new StudentController();
		this.bookController = new BookController();
	}

	public void menu() {

		HashMap<Integer, String> menuItems = new HashMap<>();
		menuItems.put(1, "Admin");
		menuItems.put(2, "Student");

		int key = MyUtil.menu(menuItems);

		switch (key) {
		case 1:
			adminMenu();
			break;
		case 2:
			studentLogin();
			break;

		default:
			break;
		}
	}

	private Student studentLogin() {
		String username = MyUtil.readString("Please enter username.");
		String password = MyUtil.readString("Please enter password.");

		Optional<Student> stu = studentController.findByUsername(username);
		if (stu.isPresent()) {
			if (stu.get().getPassword().equals(password)) {
				studentMenu(stu.get());
			} else {
				System.out.println("Wrong username or password ");
			}
		} else {
			System.out.println("Wrong username or password ");
		}
		return stu.get();
	}

	private void adminMenu() {

		HashMap<Integer, String> menuItems = new HashMap<>();
		menuItems.put(1, "Add Student ");
		menuItems.put(2, "Delete Student ");
		menuItems.put(3, "Add Book ");
		menuItems.put(4, "Delete Book ");
		menuItems.put(5, "List all Books ");
		menuItems.put(6, "List borrowed Books ");

		int key = MyUtil.menu(menuItems);

		switch (key) {
		case 1:
			studentController.create();
			break;
		case 2:
			studentController.delete();
			break;
		case 3:
			bookController.createBook();
			break;
		case 4:
			bookController.delete();
			break;
		case 5:
			bookController.listAll();
			break;
		case 6:
			bookController.listBorrowedBooks();
			break;
		case 7:
			bookController.holderInfo();
			break;
		default:
			break;
		}
	}

	private void studentMenu(Student student) {
		HashMap<Integer, String> menuItems = new HashMap<>();
		menuItems.put(1, "Borrow Book ");
		menuItems.put(2, "Return Book ");

		int key = MyUtil.menu(menuItems);

		switch (key) {
		case 1:
			bookController.borrowBook(student);
			break;
		case 2:
			bookController.returnBook(student);
			break;
		}

	}
}
