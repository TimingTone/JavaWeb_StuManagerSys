package org.student.servlet;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;
                                                                //第二步， 编写servlet(一个servlet处理一个功能)
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddStudentServlet")

public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req代表request， resp代表response
        int no = Integer.parseInt(req.getParameter("sno"));
        String name = req.getParameter("sname");
        int age = Integer.parseInt(req.getParameter("sage"));
        String address = req.getParameter("saddress");

        //将以上四个数据封装到实体类中
        Student student = new Student(no, name, age, address);

        //增加学生
        //接口 x = new 实现类();
        IStudentService studentService = new StudentServiceImpl();
        boolean result = studentService.addStudent(student);

        //设置响应编码
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("utf-8");
        //servlet中使用out对象， 需要PrintWriter创建
        PrintWriter out = resp.getWriter();
        if(result){
            out.println("增加成功");
            resp.sendRedirect("QueryAllStudentsServlet");
        }else{
            out.println("增加失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
