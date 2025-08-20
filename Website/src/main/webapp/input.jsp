<!-- input.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Input Form</title>
</head>
<body>
    <h2>Enter Your Details</h2>
    <form action="Display.jsp" method="post">
        Name: <input type="text" name="name" required><br><br>
        Email: <input type="email" name="email" required><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
