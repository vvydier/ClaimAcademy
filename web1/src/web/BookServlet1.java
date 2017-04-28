package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backend.Book;
import backend.BookCache;
/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet1")
public class BookServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookCache cache = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void init() throws ServletException {
		super.init();
		cache  = new BookCache();
        cache.addBook(1, new Book(1, "Practical Clojure", "VV", 10));
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map<Long, Book> books = cache.getBooks();
		PrintWriter out = response.getWriter();
		out.println("<html>");
	    out.println("<head>");
	    out.println("<title>List of Books</title>");
	    out.println("</head>");
	    out.println("<body bgcolor=\"white\">");
		out.println("<table border=\"1\">");
	    for (Iterator<Long> iterator = books.keySet().iterator(); iterator.hasNext();) {
			Long id = iterator.next();
			Book eachBook = books.get(id);
			out.println("<tr>");
			out.println("<td>"+ eachBook.getId() + "</td>");
			out.println("<td>"+ eachBook.getBookTitle() + "</td>");
			out.println("<td>"+ eachBook.getPublisher() + "</td>");
			out.println("<td>"+ eachBook.getPrice() + "</td>");
			out.println("</tr>");
		}
	    out.println("</body>");
	    out.println("</html>");
	    
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
