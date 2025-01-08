<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/15/2024
  Time: 7:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/Test.css">
    <script src="js/Test.js"></script>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body>
<div class="menu"> <!-- Menu cố định -->
    <ul>
        <li>Trang chủ</li>
        <li>Sản phẩm</li>
        <li>Liên hệ</li>
    </ul>
</div>

<div class="content">
    <button id="openOverlay">Mở màn hình đè</button>
    <p>Nội dung chính của trang web...</p>
</div>

<!-- Màn hình đè -->
<div id="overlay" class="overlay" style="text-align: center">
    <div class="overlay-content" style="text-align: center">
        <iframe id="iframeOverlay" src="" frameborder="0" style="width: 200px; height: 100px; text-align: center ;padding: 10px"></iframe>
        <button id="closeOverlay">Đóng</button>
    </div>
</div>

</body>
</html>
