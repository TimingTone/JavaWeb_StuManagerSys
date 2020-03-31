<%@ page import="org.student.entity.Student" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: whiterose
  Date: 2020/3/29
  Time: 8:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Student info List</title>
  </head>
  <body>
      <table border="1px">
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>地址</th>
            <th>操作</th>
        </tr>
          <%
              //获取request域中的数据(将Object转化为Student对象)
              List<Student> students = (List<Student>)request.getAttribute("students");
              for(Student student:students){
          %>
            <%-- html 代码--%>
                <tr>
                    <td><a href="QueryStudentBySnoServlet?sno=<%=student.getSno()%>"><%=student.getSno()%></a></td>
                    <td><%=student.getSname()%></td>
                    <td><%=student.getSage()%></td>
                    <td><%=student.getSaddress()%></td>
                    <td><a href="DeleteStudentServlet?sno=<%=student.getSno()%>">DEL</a></td>
                </tr>
          <%
              }

          %>

      </table>
      <a href="add.jsp">NEW ADD</a>
  </body>
</html>
