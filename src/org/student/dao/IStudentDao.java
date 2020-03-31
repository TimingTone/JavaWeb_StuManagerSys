package org.student.dao;

import org.student.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface IStudentDao {

    //根据学生的学号来查询学生的具体信息
    public Student queryStudentBySno(int sno) ;

    //查询学生是否存在
    public boolean isExist(int sno);


    //增加学生
    public boolean addStudent(Student student);

    //根据学号删除学生
    public boolean deleteStudentBySno(int sno);

    //根据学号修改学生信息(根据学号找人然后修改信息)
    public boolean updateStudentBySno(int sno, Student student);


    //查询全部学生
    public List<Student> queryAllStudents();

}
