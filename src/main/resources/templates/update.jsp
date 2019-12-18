<%--
  Created by IntelliJ IDEA.
  User: 14451
  Date: 2019/12/9
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/student/updateStudent.do" method="POST">
        姓名：<input type="text" name="sname"><br>
        性别：<input type="text" name="sex"><br>
        所在院校：<input type="text" name="college"><br>
        行政班级：<input type="text" name="classname"><br>
        手机号：<input type="text" name="number"><br>
        sid:<input type="text" name="sid"><br>
        <input type="submit" value="修改">
    </form>
</body>
</html>
