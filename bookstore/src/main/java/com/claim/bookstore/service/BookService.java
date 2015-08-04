package com.claim.bookstore.service;

import java.util.LinkedList;
import java.util.List;

import com.claim.bookstore.dao.BookDAO;
import com.claim.bookstore.dao.BookDAOImpl;
import com.claim.bookstore.model.Author;
import com.claim.bookstore.model.Book;
import com.claim.bookstore.model.Category;

public class BookService {

	private static List<Book> bookList;
	private static List<Category> catList;
	private  BookDAO bookDao ;


	public void setBookDao(BookDAO bookDao) {
		this.bookDao = bookDao;
	}



	
	public List<Book> getAllBooksList() {
           List<Book> allBooks = bookDao.findAllBooks();
		return allBooks;
	}
	public List<Category> getCategoryList() {
        List<Category> catList = bookDao.findAllCategories();

		return catList;
	}
	
	 public Book createBook(Book b) {
			Book book = new Book();
			book.setId((long)bookList.size() + 1);
			book.setBookTitle(b.getBookTitle());
			bookList.add(book);
			return book;
		    }	

}