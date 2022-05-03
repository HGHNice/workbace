<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/5/2
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="get">
   用户名<label>
    <input type="text" name="username">
</label>
    <input type="submit">

</form>
</body>
</html>
