package com.claim.bookstore.service;

import java.util.List;

import com.claim.bookstore.model.Book;
import com.claim.bookstore.model.Category;

public interface BookService {
	public List<Book> findAll();
	public List<Category> findAllCategories();
	
	public List<Book> searchBooksByKeyword(String keyWord);
	

}
