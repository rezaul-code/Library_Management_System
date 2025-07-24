<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Book</title>
    <link rel="stylesheet" href="css/mystyle.css">
</head>
<body>

<header class="site-header">
    <h1>📚 The School Library</h1>
    <h2>Welcome ${admin}</h2>
    <button id="theme-toggle" class="btn">🌙 Dark Mode</button>
        
    
</header>

<main class="home-content">
    <div class="welcome-section">
        <form action="update" method="post">
            <input type="hidden" name="id" value="${book1.id}" />

            Title: <input type="text" name="title" value="${book1.title}" /><br/><br/>
            Author: <input type="text" name="author" value="${book1.author}" /><br/><br/>

            Category:
            <select name="category" style="width: 170px">
                <option value="Story" ${book1.category == 'Story' ? 'selected' : ''}>Story</option>
                <option value="History" ${book1.category == 'History' ? 'selected' : ''}>History</option>
                <option value="Science" ${book1.category == 'Science' ? 'selected' : ''}>Science</option>
                <option value="Comics" ${book1.category == 'Comics' ? 'selected' : ''}>Comics</option>
                 <option value="Programming" ${book1.category == 'Programming' ? 'selected' : ''}>Programming</option>
                  <option value="Arts" ${book1.category == 'Arts' ? 'selected' : ''}>Arts</option>
                   <option value="Chemistry" ${book1.category == 'Chemistry' ? 'selected' : ''}>Chemistry</option>
            </select>
            <br><br>

            Availability:
            <select name="availability" style="width: 170px">
                <option value="Yes" ${book1.availability == 'Yes' ? 'selected' : ''}>Yes</option>
                <option value="No" ${book1.availability == 'No' ? 'selected' : ''}>No</option>
            </select>
            <br/><br/>

            <input type="submit" value="Update Book" class="btn" />
        </form>
    </div>
</main>

<footer class="site-footer">
    <p>&copy; 2020–2025 The School Library. All rights reserved.</p>
</footer>

<script src="js/theme-toggle.js"></script>

</body>
</html>
