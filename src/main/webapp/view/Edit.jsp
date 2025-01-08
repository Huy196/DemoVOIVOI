<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/13/2024
  Time: 8:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Sửa người dùng</title>
</head>
<body>

<div align="center">
    <h1>Sửa người dùng</h1>

    <form method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>Họ và tên</th>
                <td>
                    <input type="text" name="nameEdit" size="45" value="${user.name}" />
                </td>
            </tr>
            <tr>
                <th>Email</th>
                <td>
                    <input type="text" name="emailEdit" size="45" value="${user.email}" />
                </td>
            </tr>
            <tr>
                <th>Quốc tịch</th>
                <td>
                    <input type="text" name="countryEdit" size="45" value="${user.country}" />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Cập nhật"/>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
