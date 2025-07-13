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
    <h2>${admin}</h2>
</header>

<main class="home-content">
    <div class="welcome-section">
        <form action="update" method="post">
            <input type="hidden" name="id" value="${book1.id}" />

            Title: <input type="text" name="title" value="${book1.title}" /><br/><br/>
            Author: <input type="text" name="author" value="${book1.author}" /><br/><br/>

            Category:
            <select name="category" style="width: 170px">
                <option value="story" ${book1.category == 'story' ? 'selected' : ''}>Story</option>
                <option value="history" ${book1.category == 'history' ? 'selected' : ''}>History</option>
                <option value="science" ${book1.category == 'science' ? 'selected' : ''}>Science</option>
                <option value="comics" ${book1.category == 'comics' ? 'selected' : ''}>Comics</option>
            </select>
            <br><br>

            Availability:
            <select name="availability" style="width: 170px">
                <option value="yes" ${book1.availability == 'yes' ? 'selected' : ''}>Yes</option>
                <option value="no" ${book1.availability == 'no' ? 'selected' : ''}>No</option>
            </select>
            <br/><br/>

            <input type="submit" value="Update Book" class="btn" />
        </form>
    </div>
</main>

<footer class="site-footer">
    <p>&copy; 2020–2025 The School Library. All rights reserved.</p>
</footer>

</body>
</html>
