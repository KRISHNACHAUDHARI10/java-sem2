<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Book Search Results</title></head>
<body>
    <h1>Search Results</h1>
    <ul>
        <c:forEach var="book" items="${books}">
            <li>${book.title} by ${book.author}</li>
        </c:forEach>
    </ul>
    <a href="index.jsp">Back to Search</a>
</body>
</html>
