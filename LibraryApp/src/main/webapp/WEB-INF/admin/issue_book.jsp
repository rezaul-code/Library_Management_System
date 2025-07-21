<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>issue-Books</title>
    <link rel="stylesheet" href="css/mystyle.css">
</head>
<body>

<header class="site-header">
    <h1>📚 The School Library</h1>
    <h2>Welcome ${admin}</h2>
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
                    <th>Issue</th>
                    <th>Update</th>
                    
                </tr>
            </thead>
            <tbody>
           
                <c:forEach var="bookvar" items="${issue_pending}">
    				<tr>
				        <td>${bookvar.id}</td>
				        <td>${bookvar.bookId}</td>   
				        <td>${bookvar.user}</td>
				        <td>${bookvar.action}</td>
				        
				        <form action="updateissuebooks" method="get">
						<td>
							<select name="action" class="btn">
							 <option value="" disabled selected>-- Select action --</option>
							 
							 <c:if test="${bookvar.action ne 'approved' }">
								<option value="Approved">Approve</option>
								</c:if>
								
								<c:if test="${bookvar.action ne 'unapprove' }">
								<option value="Unapprove">Unapprove</option>
								</c:if>
								
								
							</select>
						
						</td>
						<input type="hidden" name="id" value="${bookvar.id }">
						
						<td><button type="submit" class="btn" >Update</button></td>
						</form>
						
						
				</c:forEach>

            </tbody>
            <h2>${message}</h2>
             
        </table>
    </div>
   
</main>

<footer class="site-footer">
    <p>&copy; 2020–2025 The School Library. All rights reserved.</p>
</footer>

</body>
</html>
