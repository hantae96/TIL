<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hantae
  Date: 2023/03/19
  Time: 9:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List Page</h1>

<ul>
    <c:forEach var="dto" items = "${list}">
        <li>${dto}</li>
    </c:forEach>
</ul>
</body>
</html>
