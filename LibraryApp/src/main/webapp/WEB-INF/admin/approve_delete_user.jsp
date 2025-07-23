<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>user table for admin </title>
    <link rel="stylesheet" href="css/mystyle.css">
</head>
<body>

<header class="site-header">
    <h1>📚 The School Library</h1>
     <h3>${admin}</h3>
     <a href="logout" class="btnn">Logout</a>
</header>


<main class="home-content">
	<div class="welcome-section">
		<table class="styled-table">
			<thead>
				<th>User Name</th>
				<th>Full Name</th>
				<th>Email</th>
				<th>Phone No</th>
				<th>Password</th>
				<th>Status</th>
				<th>Action</th>
				<th>Action</th>
			</thead>
			
			<tbody>
				
                <c:forEach var="user" items="${userlist}">
                    <tr>
                    	<td>${user.userName}</td>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td>${user.phone_no}</td>
						<td>${user.password}</td>
						<td>${user.status}</td>
						
						<form action="userUpdate" method="get">
						<td>
							<select name="status" class="btn">
							 <option value="" disabled selected>-- Select Status --</option>
							 
							 <c:if test="${user.status ne 'approved' }">
								<option value="approved">Approve</option>
								</c:if>
								
								<c:if test="${user.status ne 'unapprove' }">
								<option value="unapprove">Unapprove</option>
								</c:if>
								
								<c:if test="${user.status ne 'delete' }">
								<option value="delete">Delete</option>
								</c:if>
								
							</select>
						
						</td>
						<input type="hidden" name="id" value="${user.id }">
						
						<td><button type="submit" class="btn" >Update</button></td>
						</form>
						
                    </tr>
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
