<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Book Operation</title>
    <link rel="stylesheet" href="css/mystyle.css">
</head>

<body>

<header class="site-header">
    <div class="header-left">
        <h1>📚 The School Library</h1>
    </div>
    <div class="header-center">
        <h2>Welcome ${admin}</h2>
    </div>
    <div class="header-right">
        <a href="logout" class="btnn">Logout</a>
    </div>
    <button id="theme-toggle" class="btn">🌙 Dark Mode</button>
    
</header>


<main class="home-content">
    <div class="welcome-section">
    
   <div class="book-header">
   
    <h2>📖 Book Details</h2>
    </div>
    
    <form action="book_section" method="get" class="search-form">
        <input name="search_text" type="text" placeholder="Enter book title or id to search ...." value="${param.search_text}" class="search-input">
        <button type="submit" class="search-button">🔍 Search</button>
    </form>


     
     
        
        <table class="styled-table">
            <thead>
                <tr>
                	<th>Id</th>
                    <th>Book Title</th>
                    <th>Author</th>
                    <th>Category</th>
                    <th>Availability</th>
                    <th>Update</th>
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
						<td> <a href="update?id=${bookvar.id}" class="btn">Update</a> </td>
						<td><a href="delete?id=${bookvar.id}" class="btn">Delete</a></td>
                    </tr>
                </c:forEach>
                
                <div class="top-bar">
				    <a href="addbooks" class="btnnn">Add Books</a>
				    <p class="book-count">Total books received: ${fn:length(booklist)}</p>
				</div>

                <h5>${message}</h5>
                
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
