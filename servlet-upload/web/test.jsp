<%--
  Created by IntelliJ IDEA.
  User: nero
  Date: 2019/7/22
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<h2>File upload demo</h2>
<form action="fileload" method="post" enctype="multipart/form-data">
    <input type="file" name="filename" size="45"><br>
    <input type="submit" name="submit" value="submit">
</form>
</body>
</html>