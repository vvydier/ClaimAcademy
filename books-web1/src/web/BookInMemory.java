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
 * Servlet implementation class BookInMemory
 */
@WebServlet("/BookInMemory")
public class BookInMemory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookCache cache = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookInMemory() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		// Init BookCache
		cache = new BookCache();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map<Long, Book> books =  cache.getBooks();

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>List of Books</title>");
		
		out.println("<table border=\"1\">");

		for (Iterator<Long> iterator = books.keySet().iterator(); iterator.hasNext();) {
			long id = iterator.next();
			Book eachBook = books.get(id);
			out.println("<tr>");
			out.println("<td>" + eachBook.getId() + "</td>");
			out.println("<td>" + eachBook.getBookTitle() + "</td>");
			out.println("<td>" + eachBook.getPublisher() + "</td>");
			out.println("<td>" + eachBook.getPrice() + "</td>");

			out.println("</tr>");

		}

		out.println("</head>");

		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
