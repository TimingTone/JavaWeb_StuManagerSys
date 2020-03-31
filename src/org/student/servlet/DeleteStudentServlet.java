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

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //删除学生(不要在safari上运行)

        req.setCharacterEncoding("utf-8");
        int no = Integer.parseInt(req.getParameter("sno"));
        IStudentService service = new StudentServiceImpl();
        boolean result = service.deleteStudentBySno(no);
        //设置响应编码
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        if(result){
            //out.println("删除成功");
            resp.sendRedirect("QueryAllStudentsServlet");
        }else{
            out.println("删除失败");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
