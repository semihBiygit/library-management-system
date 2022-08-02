package com.semih.util;

import java.util.HashMap;

import com.semih.controller.StudentController;

public class LibrarySystemMenu {

	StudentController studentController;

	public LibrarySystemMenu() {
		super();
		this.studentController = new StudentController();
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
		int key = MyUtil.readInt("Please make your selection ");
		switch (key) {
		case 1:
			studentController.create();
			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

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
