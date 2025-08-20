<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Library Book Search</title></head>
<body>
    <h1>Search Books</h1>
   <form action="BookSearchServlet" method="get">
    Title: <input type="text" name="title" /> <br />
    Author: <input type="text" name="author" /> <br />
    <input type="submit" value="Search" />
</form>
   
</body>
</html>
