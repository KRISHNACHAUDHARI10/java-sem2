<!-- display.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display User Data</title>
</head>
<body>
    <h2>Submitted User Data</h2>
    <p><strong>Name:</strong> <%= request.getParameter("name") %></p>
    <p><strong>Email:</strong> <%= request.getParameter("email") %></p>
</body>
</html>
