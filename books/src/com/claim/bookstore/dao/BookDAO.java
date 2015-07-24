package com.claim.bookstore.dao;

import java.util.List;

import com.claim.bookstore.model.Book;
import com.claim.bookstore.model.Category;

public interface BookDAO {
	public List<Book> findAllBooks();
	
	public List<Category> findAllCategories();
	
	public List<Book> searchBooksByKeyword(String keyWord);
	

}
