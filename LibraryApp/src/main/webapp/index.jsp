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

<main class="home-content">


    <section class="welcome-section">
        <h2>Welcome to the Library Management System</h2>
        <p>Please choose an option below:</p>
       
        <div class="action-buttons">
        
            <a href="admin" class="btn">Admin</a>
            <a href="userindex" class="btn">User</a>
        
        </div>
        
        
    </section>
</main>

<footer class="site-footer">
    <p>&copy; 2020–2025 The School Library. All rights reserved.</p>
</footer>

<script src="js/theme-toggle.js"></script>

</body>
</html>
