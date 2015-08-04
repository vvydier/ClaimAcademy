package com.claim.bookstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.claim.bookstore.model.Author;
import com.claim.bookstore.model.Book;
import com.claim.bookstore.model.Category;

public class CategoryExtractor implements ResultSetExtractor<Category> {  
	  
	 public Category extractData(ResultSet resultSet) throws SQLException,  
	   DataAccessException {  
	    
		 Category category = new Category();
			category.setId(resultSet.getLong("id"));
			category.setCategoryDescription(resultSet
					.getString("category_description"));
	  return category;  
	 }  
	  
	}  


