<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix="sql" %>	

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel = "stylesheet" href = "style.css" type = "text/css"></link>
	<title>List of Books</title>
</head>

<body>

    <sql:setDataSource                    
      var = "myDS"                                           
      driver = "com.mysql.jdbc.Driver"
      url = "jdbc:mysql://localhost:3306/books"
      user = "root" 
      password = "welcome1"
    />
    
    <sql:query var = "listBooks" dataSource="${myDS}">
		select * from book;
	</sql:query>


<!-- 		select * from book where CATEGORY_ID = 2;
 -->

<p>

<h2>List of Books</h2>

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
		</c:forEach>
	   </table>
</div>

<%-- 
<c:forEach var = "item" items = "${listBooks.rows}">
<tr>
<td class = "cent"><c:out value="${item.book_title}" /></td>
 </tr>
</c:forEach>
 --%>
</body>

</html>