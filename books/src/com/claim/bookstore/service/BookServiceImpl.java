package com.claim.bookstore.service;

import java.util.List;

import com.claim.bookstore.dao.BookDAO;
import com.claim.bookstore.dao.BookDAOImpl;
import com.claim.bookstore.model.Book;
import com.claim.bookstore.model.Category;

public class BookServiceImpl implements BookService{
	private static BookDAO bookDao = new BookDAOImpl();
	
	@Override
	public List<Book> findAll() {
		List<Book> list  = bookDao.findAllBooks();
		return list;
	}

	@Override
	public List<Category> findAllCategories() {
		List<Category> list  = bookDao.findAllCategories();
		return list;
	}

	@Override
	public List<Book> searchBooksByKeyword(String keyWord) {
		List<Book> list  = bookDao.searchBooksByKeyword(keyWord);
		return list;
	}

}
