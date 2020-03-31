package org.student.service;

import org.student.entity.Student;

import java.util.List;

public interface IStudentService {
    //逻辑增加学生（查+增）
    public boolean addStudent(Student student);

    //删除学生
    public boolean deleteStudentBySno(int sno);

    //修改学生信息
    public boolean updateStudentBySno(int sno, Student student);

    //根据学号查询学生
    public Student queryStudentBySno(int sno);

    //查询全部学生
    public List<Student> queryAllStudents();
}
