package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import backend.Book;
/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet2")
public class BookServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<Long, Book> cache = new HashMap<Long, Book>();

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/books",
				"root", "welcome1");
	}

	private void closeConnection(Connection connection) {
		if (connection == null)
			return;
		try {
			connection.close();
		} catch (SQLException ex) {
		}
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void init() throws ServletException {
		super.init();
//		cache  = new BookCache();


		String sql = "select * from book";

		Connection connection = null;
		
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getLong("id"));
				book.setBookTitle(resultSet.getString("book_title"));
				book.setPublisher(resultSet.getString("publisher"));
				book.setPrice(resultSet.getLong("price"));
				cache.put(resultSet.getLong("id"), book);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		
//        cache.addBook(1, new Book(1, "Title1", "Claim", 10));
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		Map<Long, Book> books = cache.get(key);
		PrintWriter out = response.getWriter();
		out.println("<html>");
	    out.println("<head>");
	    out.println("<title>List of Books</title>");
	    out.println("</head>");
	    out.println("<body bgcolor=\"white\">");
		out.println("<table border=\"1\">");
	    for (Iterator<Long> iterator = cache.keySet().iterator(); iterator.hasNext();) {
			Long id = iterator.next();
			Book eachBook = cache.get(id);
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
