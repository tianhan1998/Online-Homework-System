<%--
  Created by IntelliJ IDEA.
  User: 14451
  Date: 2019/12/9
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/student/deleteStudent.do" method="POST">
        sid：<input type="text" name="sid"><br>
        <input type="submit" value="删除">
    </form>
</body>
</html>
