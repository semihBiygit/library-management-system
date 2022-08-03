package com.semih.util;

import java.util.HashMap;

import com.semih.controller.BookController;
import com.semih.controller.StudentController;

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
			// adminLogin
			adminMenu();
			break;
		case 2:
			// studentLogin
			break;

		default:
			break;
		}
	}

	private void adminMenu() {

		HashMap<Integer, String> menuItems = new HashMap<>();
		menuItems.put(1, "Add Student ");
		menuItems.put(2, "Delete Student ");
		menuItems.put(3, "Add Book ");
		menuItems.put(4, "Delete Book ");
		menuItems.put(5, "Return Time of Books ");
		menuItems.put(6, "Book Tenants ");

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

			break;
		case 6:

			break;

		default:
			break;
		}
	}

}
