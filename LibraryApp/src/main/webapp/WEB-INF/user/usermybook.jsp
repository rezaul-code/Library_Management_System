<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User-Books</title>
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
        <h2>📖 My Book Details</h2>
        <table class="styled-table">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>BookId</th>
                    <th>User</th>
                    <th>Action</th>
                    <th>Action</th>
                    
                </tr>
            </thead>
            <tbody>
           
                <c:forEach var="bookvar" items="${booklist}">
    				<tr>
				        <td>${bookvar.id}</td>
				        <td>${bookvar.bookId}</td>   
				        <td>${bookvar.user}</td>
				        <td>${bookvar.action}</td>
				        <td><a href="return?id=${bookvar.id}&bookId=${bookvar.bookId}" class="btn">Return</a></td>
    				</tr>
				</c:forEach>

            </tbody>
        </table>
        <h3>${mssg}</h3>
    </div>
</main>

<footer class="site-footer">
    <p>&copy; 2020–2025 The School Library. All rights reserved.</p>
</footer>

<script src="js/theme-toggle.js"></script>

</body>
</html>
