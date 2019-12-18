<%--
  Created by IntelliJ IDEA.
  User: 14451
  Date: 2019/11/29
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/student/addStudent.do" method="POST">
        姓名：<input type="text" name="sname"><br>
        性别：<input type="text" name="sex"><br>
        所在院校：<input type="text" name="college"><br>
        行政班级：<input type="text" name="classname"><br>
        手机号：<input type="text" name="number"><br>
        <input type="submit" value="提交">
    </form>
    <a href="${pageContext.request.contextPath}/jsp/delete.jsp">删除</a>
    <a href="${pageContext.request.contextPath}/jsp/update.jsp">修改</a>
</body>
</html>
