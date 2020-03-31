package org.student.servlet;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/QueryAllStudentsServlet")
public class QueryAllStudentsServlet extends HttpServlet {

    //查询所有学生
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");


        IStudentService service = new StudentServiceImpl();
        List<Student> students = service.queryAllStudents();

        System.out.println(students);
        //将信息放到request域中
        req.setAttribute("students", students);
        //request域中有数据,通过请求转发的形式跳转(重定向会丢失request域)
        //pageContext<request<session<application 优先使用最小的域，对系统损耗小
        req.getRequestDispatcher("index.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
