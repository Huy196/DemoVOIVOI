<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/13/2024
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script src="js/login.js"></script>


</head>
<body>
<div>
    <h1>Đăng nhập</h1>

    <form action="login?action=login" method="post" onsubmit="return validateForm()">
        <div class="form-group">
            <label for="username">Tên đăng nhập:</label>
            <input type="text" id="username" name="username" placeholder="Nhập tên đăng nhập">
        </div>
        <div class="form-group">
            <label for="password">Mật khẩu:</label>
            <input type="password" id="password" name="password" placeholder="Nhập mật khẩu">
        </div>

        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>

        <div id="errorMsg" class="error"></div>
        <button type="submit" class="btn">Đăng Nhập</button>


    </form>


</div>

</body>
</html>
