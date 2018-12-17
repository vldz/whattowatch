<%--
  Created by IntelliJ IDEA.
  User: vladyslav
  Date: 11/28/18
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Movie page</title>
</head>
<body>
    <h3>movie.jsp</h3>
    <c:if test="${movie != null}">
    <h2 align="center">${movie.id}. ${movie.name}</h2>
    </c:if>

    <h1 align="center">Movies:</h1>
    <ul>
        <c:forEach items="${movies}" var="movie">
        <li>Id = ${movie.id}, name = ${movie.name}</li>
        </c:forEach>
    </ul>

    <form:form method="POST"
               action="/app/movie" modelAttribute="movie">
        <table>
            <tr>
                <td><form:label path="id">Id</form:label></td>
                <td><form:input path="id"/></td>
            </tr>
            <tr>
                <td><form:label path="name">Name</form:label></td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </form:form>

</body>
</html>

