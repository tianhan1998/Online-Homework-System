<%--
  Created by IntelliJ IDEA.
  User: 14451
  Date: 2019/12/7
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/student/selectStudent.do" method="post">
        姓名：<input type="text" name="sname"><br>
        性别：<input type="text" name="sex"><br>
        所在院校：<input type="text" name="college"><br>
        行政班级：<input type="text" name="classname"><br>
        手机号：<input type="text" name="number"><br>
        <input type="submit" value="搜索">
    </form>
    <table border="1px">
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>所在院校</td>
            <td>行政班级</td>
            <td>手机号</td>
        </tr>
    </table>
    <c:forEach var="student" items="list" varStatus="list">
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>所在院校</td>
            <td>行政班级</td>
            <td>手机号</td>
        </tr>
    </c:forEach>
</body>
</html>
