package backend;

public class Book {

	long id;
	String bookTitle;
	String publisher;
	long price;
	
	public Book() {
		super();
	}
	
	public Book(long id, String bookTitle, String publisher, long price) {
		super();
		this.id = id;
		this.bookTitle = bookTitle;
		this.publisher = publisher;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
}
