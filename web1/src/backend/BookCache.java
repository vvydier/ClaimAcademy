package backend;

import java.util.*; 

public class BookCache {

	public Map<Long, Book> books = new HashMap<Long, Book>();

    public BookCache() {
            books.put((long) 1, new Book(1, "Beginning Groovy, Grails and Griffon", "VVV", 10));
            books.put((long)2, new Book(2, "Modern Java Web Development", "VVV", 20));
            books.put((long)3, new Book(3, "Beginning Java 7 ", "VVV", 20));
            books.put((long)4, new Book(4, "Beginning Scala", "VVV", 20));
            
    }

    public Map<Long, Book> getBooks() {
            return books;
    }

    public void addBook(long i, Book book) {
            books.put(i, book);
    }
}
