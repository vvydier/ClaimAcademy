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
 * Servlet implementation class BookInMemory
 */
@WebServlet("/BookInDB")
public class BookInDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<Long, Book> booksInDB = new HashMap<Long, Book>();

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
    public BookInDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		// Get Books
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
				booksInDB.put(resultSet.getLong("id"), book);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		Map<Long, Book> books =  cache.getBooks();

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>List of Books</title>");
		
		out.println("<table border=\"1\">");

		for (Iterator<Long> iterator = booksInDB.keySet().iterator(); iterator.hasNext();) {
			long id = iterator.next();
			Book eachBook = booksInDB.get(id);
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
