package com.semih.controller;

import java.util.Optional;

import com.semih.entity.Author;
import com.semih.service.AuthorService;
import com.semih.util.MyUtil;

public class AuthorController {

	AuthorService authorService;

	public AuthorController() {
		super();
		this.authorService = new AuthorService();
	}

	public void delete() {
		long id = MyUtil.readInt("Enter the Id of author you want to delete.");
		authorService.delete(id);
	}

	public void update() {
		long id = MyUtil.readInt("Enter the Id of author you want to update.");
		Author author = new Author(null, null);

		String firstname = MyUtil.readString("Enter the new firstname of author you want to update.");
		String lastname = MyUtil.readString("Enter the new lasttname of author you want to update.");
		author.setFirstName(firstname);
		author.setLastName(lastname);
		authorService.update(id, author);

	}

	public void listAll() {
		authorService.listAll();
	}

	public Author find() {
		long id = MyUtil.readInt("Enter the Id of author that you want to find.");
		return authorService.find(id);
	}

	public Optional<Author> findByName(String firstname, String lastname) {

		return authorService.findByName(firstname, lastname);
	}

}
