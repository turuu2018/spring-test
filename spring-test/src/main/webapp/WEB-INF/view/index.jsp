<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

Spring Test<br>

<c:forEach items="${users}" var="_user">
    <p>${_user.username}</p>
    <p>${_user.lastName}</p>
    <p>${_user.firstName}</p>
    <p><fmt:formatDate value="${_user.registeredDate}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
    <hr>
</c:forEach>
