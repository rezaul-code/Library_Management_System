<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title> Admin -viewBooks</title>
    <link rel="stylesheet" href="css/mystyle.css">
</head>
<body>

<header class="site-header">
    <h1>📚 The School Library</h1>
</header>

<main class="home-content">
    <div class="welcome-section">
        <h2>📖 Book Details</h2>
        <table class="styled-table">
            <thead>
                <tr>
                	<th>Id</th>
                    <th>Book Title</th>
                    <th>Author</th>
                    <th>Category</th>
                    <th>Availability</th>
                    <th>update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
            
            <c:if test="${empty booklist}">
   				 <tr><td colspan="4" style="color: red;">No books found or list is empty!</td></tr>
				</c:if>
           
            
            
                <c:forEach var="bookvar" items="${booklist}">
                    <tr>
                    	<td>${bookvar.id}</td>
                        <td>${bookvar.title}</td>
                        <td>${bookvar.author}</td>
                        <td>${bookvar.category}</td>
						<td>${bookvar.availability}</td>
						<td> <a href="/update" class="btn">Update</a> </td>
						<td><a href="/delete" class="btn">Delete</a></td>
                    </tr>
                </c:forEach>
                <p>Total books received: ${fn:length(booklist)}</p> 
                
            </tbody>
        </table>
    </div>
</main>

<footer class="site-footer">
    <p>&copy; 2020–2025 The School Library. All rights reserved.</p>
</footer>

</body>
</html>
