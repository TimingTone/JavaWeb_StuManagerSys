package org.student.dao.impl;

import org.student.dao.IStudentDao;
import org.student.entity.Student;
import org.student.util.DBUtil;

;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//第四步， 编写数据访问层（Dao层）原子性的增删改查
//实现类
public class StudentDaoImpl implements IStudentDao {

//    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//    private final String URL = "jdbc:mysql://localhost:3306/queryprac";
//    private final String USER = "user";
//    private final String PSW = "password";

    //查询学生是否存在
    public boolean isExist(int sno){
        return queryStudentBySno(sno)==null? false:true;
    }

    //增加学生
    public boolean addStudent(Student student){
        String sql = "insert into student values(?, ?, ?, ?)";
        Object[] params = {student.getSno(), student.getSname(), student.getSage(), student.getSaddress()};
        return DBUtil.executeUpdate(sql, params);
    }

    //根据学号删除学生
    public boolean deleteStudentBySno(int sno){
        String sql = "delete from student where sno=?";
        Object[] params = {sno};
        return DBUtil.executeUpdate(sql, params);
    }


    //根据学号修改学生信息(根据学号找人然后修改信息)
    public boolean updateStudentBySno(int sno, Student student){
        String sql = "update student set sname=?, sage=?, saddress=? where sno=?";
        Object[] params = {student.getSname(), student.getSage(), student.getSaddress(), sno};
        return DBUtil.executeUpdate(sql, params);
    }

//select * from student
    //查询全部学生
    public List<Student> queryAllStudents(){
        List<Student> students = new ArrayList<>();
        ResultSet rs = null;
        //封装学生
        Student student = null;
        try {
            String sql = "select * from student";
            rs = DBUtil.executeQuery(sql, null);
            while (rs.next()) {
                int no = rs.getInt("sno");
                String name = rs.getString("sname");
                int age = rs.getInt("sage");
                String address = rs.getString("saddress");
                student = new Student(no, name, age, address);
                students.add(student);
            }
            return students;
        } catch (SQLException se) {
            se.printStackTrace();
            //没有这个student
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.conn);
//            try {
//                if (DBUtil.conn != null) DBUtil.conn.close();
//                if (DBUtil.pstmt != null) DBUtil.pstmt.close();
//                if (DBUtil.rs != null) DBUtil.rs.close();
//                if (rs != null) rs.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//
//            }
        }
    }
//select * from student where sno=?
    //根据学生的学号来查询学生的具体信息
    public Student queryStudentBySno(int sno) {
        ResultSet rs = null;
        //封装学生
        Student student = null;
        try {
            String sql = "select * from student where sno=?";
            Object[] params = {sno};
            rs = DBUtil.executeQuery(sql, params);
            if (rs.next()) {
                int no = rs.getInt("sno");
                String name = rs.getString("sname");
                int age = rs.getInt("sage");
                String address = rs.getString("saddress");
                student = new Student(no, name, age, address);
            }
            return student;
        } catch (SQLException se) {
            se.printStackTrace();
            //没有这个student
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (DBUtil.conn != null) DBUtil.conn.close();
                if (DBUtil.pstmt != null) DBUtil.pstmt.close();
                if (DBUtil.rs != null) DBUtil.rs.close();
                if (rs != null) rs.close();
            } catch (SQLException se) {
                se.printStackTrace();

            }
        }

    }
}






















