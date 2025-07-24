<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
    <link rel="stylesheet" href="css/mystyle.css">
</head>
<body>

<header class="site-header">
    <h1>📚 The School Library</h1>
    <h2>Welcome ${admin}</h2> 
    <a href="logout" class="btnn">Logout</a> 
    <button id="theme-toggle" class="btn">🌙 Dark Mode</button>
    
</header>

<main class="home-content">

	<section class="welcome-section">
	
        <h2>Welcome to the Library Management System</h2>
        <p>Please add book detail's:</p>
       
        <div class="action-buttons">
        
        <form action="addbooks" method="post">
        
        	<input type="number" name="id" placeholder="enter id" required="required" >
        	<br>
        	<input type="text" name="title"   placeholder="Title" required="required" >
  			<br>
  			<input type="text" name="author" placeholder="Author" required="required">
  			<br>
  			 <select name="category" style="width: 170px">
  			 	<option value="Story"> Story</option>
  			 	<option value="History"> History</option>
  			 	<option value="Science"> Science</option>
  			 	<option value="Comics"> Comics</option>
  			 	<option value="Programming"> Programming</option>
  			 	<option value="Arts"> Arts</option>
  			 	<option value="Chemistry"> Chemistry</option>
  			 	 
  			 </select>
  			<br>
        	<button type="submit" class="btn">Submit</button>
        	  <h4>${message}</h4>
        </form>
           
        
        </div>
        
        
    </section>

    
</main>

<footer class="site-footer">
    <p>&copy; 2020–2025 The School Library. All rights reserved.</p>
</footer>

<script src="js/theme-toggle.js"></script>

</body>
</html>
