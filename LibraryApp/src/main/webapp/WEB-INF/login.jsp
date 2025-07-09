<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>login page</title>
 <link rel="stylesheet" type="text/css" href="css/mystyle.css"></head>
<body>

  <header>
    <h1>The School</h1>
    <h2>${fullName}</h2>
  </header>

  <main>
  		<div >
  			<h2>Log in Here</h2>
  			
  			<form action="login"  method="post" >
  			
  			<input type="text" name="username"   placeholder="UserName" required="required" >
  			<br>
  			<br>
  			<input type="password" name="password" placeholder="Password" required="required">
  			<br>
  			<br>
  			<button type="submit">Submit</button>
  			<br>
  			${error}
  			
  			</form>
  		
  		
  		</div>
  
  </main>

  <footer>
    <p>Copyright@2020-2025</p>
  </footer>

</body>
</html>
