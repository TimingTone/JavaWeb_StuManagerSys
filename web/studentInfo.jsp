<%@ page import="org.student.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: whiterose
  Date: 2020/3/31
  Time: 1:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Detail Information</title>
</head>
<body>
    <%
        Student student = (Student)request.getAttribute("student");
    %>
    <!-- 通过表单展示学生信息-->
    <form action="UpdateStudentServlet">
        学号：<input type="text" name="sno" value="<%=student.getSno()%>" readonly="readonly"> <br/>
        姓名：<input type="text" name="sname" value="<%=student.getSname()%>"> <br/>
        年龄：<input type="text" name="sage" value="<%=student.getSage()%>"> <br/>
        地址：<input type="text" name="saddress" value="<%=student.getSaddress()%>"> <br/>
        <input type="submit" value="Modify">
        <a href="QueryAllStudentsServlet">Return</a>
    </form>
</body>
</html>
