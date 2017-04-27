<%@ page errorPage = "error.jsp" %>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   

<!DOCTYPE html>					  
<html>
  <head>
    <title>Books</title>
    <link rel = "stylesheet" href = "style.css" type = "text/css"></link>
  </head>
  <body>
  
    <sql:setDataSource                    
      var = "myDS"                                           
      driver = "com.mysql.jdbc.Driver"
      url = "jdbc:mysql://localhost:3306/books"
      user = "root" 
      password = "welcome1"
    />
    
    <sql:query var = "listBooks" dataSource = "${myDS}"> 
      SELECT * FROM book ORDER BY id;
    </sql:query>

    <p>
       <center><h3>List of Books</h3></center>
    </p>
    <div align="center">
      <table class = "books" border = "1" cellpadding = "5">
        <tr>
          <th>Id</th>
          <th>Book Title</th>
          <th>Publisher</th>
	  	  <th>Price</th>
        </tr>
        <c:forEach var = "item" items = "${listBooks.rows}"> 
          <tr>
            <td class = "rght"><c:out value="${item.id}" /></td>
            <td class = "cent"><c:out value="${item.book_title}" /></td>
            <td class = "cent"><c:out value="${item.publisher}" /></td>
	    <td class = "rght"><c:out value="\$${item.price}" /></td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </body>
</html>
