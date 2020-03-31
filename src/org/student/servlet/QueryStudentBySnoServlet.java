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

@WebServlet("/QueryStudentBySnoServlet")
public class QueryStudentBySnoServlet extends HttpServlet {
    //通过学号查询学生
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        int no = Integer.parseInt(req.getParameter("sno"));
        IStudentService service = new StudentServiceImpl();
        Student student = service.queryStudentBySno(no);

        System.out.println(student);
        //在前台jsp显示
        req.setAttribute("student", student);
        req.getRequestDispatcher("studentInfo.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
