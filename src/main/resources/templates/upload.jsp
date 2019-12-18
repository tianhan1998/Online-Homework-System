<%--
  Created by IntelliJ IDEA.
  User: 14451
  Date: 2019/12/4
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <form action="${pageContext.request.contentPath}/fileUpLoad.do" method="post" enctype="multipart/form-data" >
        文件:<input type="file" name="file"><br/>
        <input type="submit" value="上传">
    </form>
</body>
</html>
