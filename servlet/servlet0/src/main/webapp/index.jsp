<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/22
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <div style="text-align: center">
            <div>
                用户名： <input type="text" name="username" ><br>
                密码：<input type="password" name="password"><br>
                <input type="checkbox" name="hobby" value="代码">代码
                <input type="checkbox" name="hobby" value="女孩">女孩
                <input type="submit" value="登录"/>
            </div>

        </div>

    </form>
</body>
</html>
