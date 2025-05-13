<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Online Time Tracker</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; padding: 50px; }
        h1 { color: #333; }
        p { font-size: 18px; }
        .message { color: green; font-weight: bold; }
    </style>
</head>
<body>
    <h1>Online Time</h1>
    <p>Online for: <c:out value="${sessionScope.onlineTime}"/> seconds</p>
    <c:if test="${sessionScope.onlineTime > 60}">
        <p class="message">Wow! Bạn đã ở đây hơn một phút!</p>
    </c:if>
    <p>Active sessions: <c:out value="${applicationScope.activeSessions}"/></p>
</body>
</html>