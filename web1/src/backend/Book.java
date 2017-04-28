package backend;

public class Book {    
	
	long id;    
	String bookTitle;
	String publisher;    
	long price;    
	public Book(long id, String bookTitle, String publisher, long price) {    
	    this.id = id;    
	    this.bookTitle = bookTitle;    
	    this.publisher = publisher;    
	    this.price = price;    
	}
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public long getId() {
		return id;
	}
	public void setId(long l) {
		this.id = l;
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
	public void setPrice(long l) {
		this.price = l;
	}
	
	
}    
