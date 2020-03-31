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
import java.io.PrintWriter;
//通过sno修改学生信息
@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //通过name属性来获取sno值
        int no = Integer.parseInt(req.getParameter("sno"));
        //获取要修改的信息
        String name = req.getParameter("sname");
        Integer age = Integer.parseInt(req.getParameter("sage"));
        String address = req.getParameter("saddress");
        //将修改后的内容封装到实体类中
        Student student = new Student(no, name, age, address);

        IStudentService service = new StudentServiceImpl();
        boolean result = service.updateStudentBySno(no, student);
        //设置响应编码
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();
        if(result) {
            out.println("更新成功");
            //修改完成跳转到查询全部学生并显示
            resp.sendRedirect("QueryAllStudentsServlet");
        }else{
            out.println("更行失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
