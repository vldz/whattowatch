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
    <title>Home page</title>
</head>
<body>
    <h1>hello from home page to me</h1>
    <%= request.getParameter("myParam") %>
    <%= request.getAttribute("myAtr") %>

    <h1>my param from session: </h1>
    <%= session.getAttribute("myParam") %>

    <c:out value="wassup"/>

    <c:if test="${myAtr eq 'my mode'}">
        ${'im in if statement'}
    </c:if>

    ${'chto-to'}

    <ul>
    <c:forEach items="${list}" var="s">
        <li>${s}</li>
    </c:forEach>

    </ul>
</body>
</html>

