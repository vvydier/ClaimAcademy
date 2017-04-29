package backend;

import java.util.HashMap;
import java.util.Map;

public class BookCache {

	public Map<Long, Book> books = new HashMap<Long, Book>();
	
	public BookCache() {
		
		books.put((long) 1, new Book(1, "Book1", "Publisher1", 10));
		books.put((long) 2, new Book(2, "Book2", "Publisher2", 10));
		books.put((long) 3, new Book(3, "Book3", "Publisher3", 10));
//		books.put((long) 4, new Book(3, "Book3", "Publisher3", 10));
//		books.put((long) 5, new Book(3, "Book3", "Publisher3", 10));
//		books.put((long) 6, new Book(3, "Book3", "Publisher3", 10));
//		books.put((long) 7, new Book(3, "Book3", "Publisher3", 10));
//		books.put((long) 8, new Book(3, "Book3", "Publisher3", 10));

	}
	
	public Map<Long, Book> getBooks() {
		return books;
	}
	
	public void addBook(long id, Book book) {
		books.put((long) id, book);
	}

}
