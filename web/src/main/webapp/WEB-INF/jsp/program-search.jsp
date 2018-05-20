<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tom
  Date: 19.05.2018
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Programs</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/searchProgram" method="post">
    Name: <br>
    <input type="text" name="name"> <br>
    Description: <br>
    <input type="text" name="description"> <br>
    Price: <br>
    from <input type="text" name="from">
    to <input type="text" name="to"> <br>

    offset <input type="text" name="offset">
    limit <input type="text" name="limit">
    <input type="submit" value="Search"/>
</form>
<h2><c:forEach items="${requestScope.programs}" var="program">
    ${program.name} ${program.description} ${program.price}<br>
</c:forEach></h2>
</body>
</html>
