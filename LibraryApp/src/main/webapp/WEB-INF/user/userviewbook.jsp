<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>user-viewBooks</title>
    <link rel="stylesheet" href="css/mystyle.css">
</head>
<body>

<header class="site-header">
    <h1>📚 The School Library</h1>
   <h2>Welcome ${username}</h2>
     <a href="logout" class="btnn">Logout</a>
     <button id="theme-toggle" class="btn">🌙 Dark Mode</button>
     
</header>

<main class="home-content">
    <div class="welcome-section">
    
  <form action="book_section" method="get" class="search-form">
  <input name="search_text" type="text" placeholder="Enter book title or id to search ........" value="${param.search_text}" class="search-input">
  <button type="submit" class="search-button">🔍 Search</button>
</form>
 
    
    
    
    
        <h2>📖 Book Details</h2>
        <table class="styled-table">
            <thead>
                <tr>
                    <th>Book Title</th>
                    <th>Author</th>
                    <th>Category</th>
                    <th>Availability</th>
                    <th>Reserve</th>
                </tr>
            </thead>
            <tbody>
            <div>
            	<c:if test="${empty booklist}">
   				 <tr><td colspan="4" style="color: red;">No books found or list is empty!</td></tr>
				</c:if>
            </div>
            
            
                <c:forEach var="bookvar" items="${booklist}">
                    <tr>
                        <td>${bookvar.title}</td>
                        <td>${bookvar.author}</td>
                        <td>${bookvar.category}</td>
						<td>${bookvar.availability}</td>
                  
 						<c:choose>
 								<c:when test ="${bookvar.availability eq 'Yes'}">
 								<td><a href="reservebook?id=${bookvar.id}" class="btn">Reserve Book</a></td>
 								</c:when>
 								
 								<c:otherwise>
 								<td><a class="btn disabled" style="pointer-events: none; opacity: 0.5;">Reserve Book</a></td>
 								</c:otherwise>
 						</c:choose>
 
 
 				 </tr>
 				 
                </c:forEach>
                <p>Total books available: ${fn:length(booklist)}</p>
                <h2>${status}</h2>
                
            </tbody>
        </table>
    </div>
</main>

<footer class="site-footer">
    <p>&copy; 2020–2025 The School Library. All rights reserved.</p>
</footer>

<script src="js/theme-toggle.js"></script>

</body>
</html>
