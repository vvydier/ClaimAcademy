package com.claim.bookstore.main;

import java.util.List;

import com.claim.bookstore.model.Book;
import com.claim.bookstore.service.BookService;
import com.claim.bookstore.service.BookServiceImpl;

public class BookApp {
	private static BookService bookService = new BookServiceImpl();

	public static void main(String[] args) {
		// List all books
		System.out.println("Listing all Books:");
		findAllBooks();

		System.out.println("++++++++++++++++++++++++++++++");

		System.out.println("Searching Books by Keyword: Java");

		searchBooksByKeyword("java");

	}

	private static void findAllBooks() {
		List<Book> books = bookService.findAll();
		for (Book book : books) {
			System.out.println(book);
		}
	}

	private static void searchBooksByKeyword(String keyWord) {
		List<Book> books = bookService.searchBooksByKeyword(keyWord);
		for (Book book : books) {
			System.out.println(book);
		}
	}

}