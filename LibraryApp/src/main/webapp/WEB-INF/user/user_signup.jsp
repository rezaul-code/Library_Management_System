<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome | Library Management System</title>
    <link rel="stylesheet" href="css/mystyle.css">
</head>
<body>

<header class="site-header">
    <h1>📚 The School Library</h1>
    <button id="theme-toggle" class="btn">🌙 Dark Mode</button>
    
</header>

<main  class="home-content">
  		<div class="welcome-section">
  			<h2>Sign Up in Here</h2>
  			
  			<form action="usersignup"  method="post" >
  			
  			
  			<input type="text" name="username"   placeholder="UserName" required="required" >
  			<br>
  			<input type="text"  name="name" placeholder="Full Name" required="required">	
  			<br>
  			 <input type="email" name="email" placeholder="Email" required />
  			 <br>
  			 <input type="text" name="phone_no" placeholder="phone Number" required="required" >
  			 <br>
  			<input type="password" name="password" placeholder="Password" required="required">
  			<br>
  			
  			<button type="submit">Submit</button>
  			  			
  			</form>
  			${message}
  				
  		
  		</div>
  
  </main>


<footer class="site-footer">
    <p>&copy; 2020–2025 The School Library. All rights reserved.</p>
</footer>

<script src="js/theme-toggle.js"></script>

</body>
</html>
