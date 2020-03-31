<%--
  Created by IntelliJ IDEA.
  User: whiterose
  Date: 2020/3/29
  Time: 8:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Students</title>
</head>
<body>
<%--第一步： 编写add.jsp页面--%>

    <form action="AddStudentServlet" method="post">
        学号: <input type="text" name="sno"/><br/>
        名字: <input type="text" name="sname"/><br/>
        年龄: <input type="text" name="sage"/><br/>
        住址: <input type="text" name="saddress"/><br/>
        <input type="submit" value="NewAdd"/>
        <a href="QueryAllStudentsServlet">Return</a>
    </form>

</body>
</html>
