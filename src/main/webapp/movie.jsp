<%--
  Created by IntelliJ IDEA.
  User: vladyslav
  Date: 11/28/18
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Movie page</title>
</head>
<body>
    <h3>movie.jsp</h3>
    <ul>
    <c:forEach items="${model}" var="entry">
        <li>Key = ${entry.key}, value = ${entry.value}</li>
    </c:forEach>
    </ul>
</body>
</html>

