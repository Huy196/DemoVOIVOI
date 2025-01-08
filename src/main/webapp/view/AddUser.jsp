<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/12/2024
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body  style="text-align: center">
<h1>Thêm người dùng </h1>
<h2>
    <a href="users?action=list">Quay lại trang người dùng</a>
</h2>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>Họ và tên </th>
                <td>
                    <input type="text" name="name" size="45" placeholder="Tên..."/>
                </td>
            </tr>
            <tr>
                <th>Email </th>
                <td>
                    <input type="text" name="email" size="45" placeholder="Email.../> "/>
                </td>
            </tr>
            <tr>
                <th>Quốc tịch </th>
                <td>
                    <input type="text" name="country" size="45" placeholder="Quốc tịch...  "/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Thêm người dùng "/>
                </td>
            </tr>
        </table>
    </form>
</div>


</body>
</html>
